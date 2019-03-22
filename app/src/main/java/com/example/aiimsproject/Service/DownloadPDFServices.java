package com.example.aiimsproject.Service;

import android.app.IntentService;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Environment;
import android.support.v4.app.NotificationCompat;
import android.support.v4.content.LocalBroadcastManager;
import android.util.Base64;
import android.util.Log;

import com.example.aiimsproject.EmployeeListActivity;
import com.example.aiimsproject.Model.Download;
import com.example.aiimsproject.R;
import com.example.aiimsproject.RestApi.ApiClient;
import com.example.aiimsproject.RestApi.ApiInterface;
import com.example.aiimsproject.Utils.ValidationUtil;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Random;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class DownloadPDFServices extends IntentService implements Callback<ResponseBody> {

    private static final String FileName = "Application Form";

    public DownloadPDFServices() {
        super("Download Service");
    }

    private NotificationCompat.Builder notificationBuilder;
    private NotificationManager notificationManager;
    private int totalFileSize;
    private Long id;


    @Override
    protected void onHandleIntent(Intent intent) {

        notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

        notificationBuilder = new NotificationCompat.Builder(this)
                .setSmallIcon(R.drawable.ic_launcher_background)
                .setContentTitle("Download")
                .setContentText("Downloading File")
                .setAutoCancel(true);
        notificationManager.notify(0, notificationBuilder.build());
        id = intent.getLongExtra("id",-1);
        if(id!=-1) {
            initDownload();
        }

    }

    private void initDownload(){

        ApiInterface apiInterface = ApiClient.getClient().create(ApiInterface.class);
        Call<ResponseBody> listCall = apiInterface.downloadPDF(1552042658089L);
        listCall.enqueue(this);

    }

    @Override
    public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {

        int statusCode = response.code();
        Log.e("PDF", String.valueOf(statusCode));
        if (statusCode == 200) {
            try {
                downloadFile(response.body());
            } catch (IOException e) {
                e.printStackTrace();
            }

        }


    }

    @Override
    public void onFailure(Call<ResponseBody> call, Throwable t) {


    }
    File outputFile;

    private void downloadFile(ResponseBody body) throws IOException {

        byte[] pdfAsBytes = Base64.decode(body.string(), 0);
        int count;
        byte data[] = new byte[1024 * 4];
        long fileSize = body.contentLength();
        InputStream bis = new BufferedInputStream(new ByteArrayInputStream(pdfAsBytes), 1024 * 8);
        Random rand = new Random();

// Obtain a number between [0 - 49].
        int n = rand.nextInt(50);

// Add 1 to the result to get a number from the required range
// (i.e., [1 - 50]).
        n += 1;
        outputFile = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS), FileName+"_"+(ValidationUtil.longToDate(System.currentTimeMillis()))+"_"+n+"_"+".pdf");



        OutputStream output = new FileOutputStream(outputFile);
        long total = 0;
        long startTime = System.currentTimeMillis();
        int timeCount = 1;
        while ((count = bis.read(data)) != -1) {

            total += count;
            totalFileSize = (int) (fileSize / (Math.pow(1024, 2)));
            double current = Math.round(total / (Math.pow(1024, 2)));

            int progress = (int) ((total * 100) / fileSize);

            long currentTime = System.currentTimeMillis() - startTime;

            Download download = new Download();
            download.setTotalFileSize(totalFileSize);

            if (currentTime > 1000 * timeCount) {

                download.setCurrentFileSize((int) current);
                download.setProgress(progress);
                sendNotification(download);
                timeCount++;
            }

            output.write(data, 0, count);
        }
        onDownloadComplete();
        output.flush();
        output.close();
        bis.close();

    }

    private void sendNotification(Download download){

        sendIntent(download);
        notificationBuilder.setProgress(100,download.getProgress(),false);
        notificationBuilder.setContentText(String.format("Downloaded (%d/%d) MB",download.getCurrentFileSize(),download.getTotalFileSize()));
        notificationManager.notify(0, notificationBuilder.build());
    }


    private void sendIntent(Download download){

        Intent intent = new Intent(EmployeeListActivity.MESSAGE_PROGRESS);
        intent.putExtra("download",download);
        LocalBroadcastManager.getInstance(DownloadPDFServices.this).sendBroadcast(intent);
    }

    private void onDownloadComplete(){

        Download download = new Download();
        download.setProgress(100);
        sendIntent(download);

        notificationManager.cancel(0);
        notificationBuilder.setProgress(0,0,false);
        notificationBuilder.setContentText("File Downloaded");
        notificationManager.notify(0, notificationBuilder.build());
        openExcel();

    }

    private void openExcel() {

        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setDataAndType(Uri.fromFile(outputFile), "application/pdf");

        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }

    @Override
    public void onTaskRemoved(Intent rootIntent) {
        notificationManager.cancel(0);
    }


}
