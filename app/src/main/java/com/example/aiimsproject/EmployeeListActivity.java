package com.example.aiimsproject;

import android.Manifest;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.aiimsproject.Adapter.EmployeeListAdapter;
import com.example.aiimsproject.Model.Download;
import com.example.aiimsproject.Model.RegistrationRequest;
import com.example.aiimsproject.Model.UpdateStatus;
import com.example.aiimsproject.RestApi.ApiClient;
import com.example.aiimsproject.RestApi.ApiInterface;
import com.example.aiimsproject.Service.DownloadExcelService;
import com.example.aiimsproject.Utils.ConnectivityReceiver;
import com.example.aiimsproject.Utils.DialogUtitlity;
import com.example.aiimsproject.Utils.EmployeeListSingleton;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class EmployeeListActivity extends BaseActivity implements EmployeeListAdapter.EmployeeListListener {
    public static final String MESSAGE_PROGRESS = "message_progress";
    private static final String TAG = EmployeeListActivity.class.getName();
    private static final int PERMISSION_REQUEST_CODE = 1;

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;

    @BindView(R.id.progress)
    ProgressBar processBar;

    private EmployeeListSingleton employeeListSingleton;

    private EmployeeListAdapter employeeListAdapter;
    private List<RegistrationRequest> registrationRequestList = new ArrayList<>();
    private ArrayList<Long> employeeIdList = new ArrayList<Long>();
    private UpdateStatus updateStatus;
    private BroadcastReceiver broadcastReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {

            if (intent.getAction().equals(MESSAGE_PROGRESS)) {

                Download download = intent.getParcelableExtra("download");
                //mProgressBar.setProgress(download.getProgress());

                if (download.getProgress() == 100) {
                    processBar.setVisibility(View.GONE);

                } else {


                }
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        employeeListSingleton = EmployeeListSingleton.getInstance();
        employeeRequestToServer();
        setRecyclerView();
        registerReceiver();

    }

    @Override
    protected void setListener() {

    }

    @Override
    protected void setResources() {

    }

    @Override
    protected int getLayoutResourceId() {
        return R.layout.activity_employee_list;
    }

    @Override
    protected String getToolBarTitle() {
        return getResources().getString(R.string.toolbar_title_employee_list);
    }

    @Override
    protected void startActivity(Class<?> cls) {
        Intent intent = new Intent(this, EmployeeDetailActivity.class);
        intent.putExtra("POSITION", position);
        startActivity(intent);

    }

    private void setRecyclerView() {
        employeeListAdapter = new EmployeeListAdapter(this, registrationRequestList, this);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));
        recyclerView.setAdapter(employeeListAdapter);
        recyclerView.setHasFixedSize(true);

    }

    private void employeeRequestToServer() {
        DialogUtitlity.showLoading(this);
        ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);
        Call<List<RegistrationRequest>> callClient = apiService.getEmployeeList();
        callClient.enqueue(new Callback<List<RegistrationRequest>>() {
            @Override
            public void onResponse(Call<List<RegistrationRequest>> call, Response<List<RegistrationRequest>> response) {
                DialogUtitlity.hideLoading();
                switch (response.code()) {

                    case 200:
                        if (response.body() instanceof List) {
                            registrationRequestList.clear();
                            registrationRequestList.addAll(response.body());
                            employeeListSingleton.setEmployeeList(registrationRequestList);
                            employeeListAdapter.notifyDataSetChanged();
                        }

                }
            }

            @Override
            public void onFailure(Call<List<RegistrationRequest>> call, Throwable t) {
             DialogUtitlity.hideLoading();
             showToast(t.toString());
            }

        });
    }




    @Override
    public void onCheckBoxClicked(int position) {
        RegistrationRequest registrationRequest = registrationRequestList.get(position);
        if (registrationRequest.isChecked()) {
            registrationRequest.setChecked(false);
            employeeIdList.remove(registrationRequest.getId());
        } else {
            registrationRequest.setChecked(true);
            employeeIdList.add(registrationRequest.getId());
        }

        employeeListAdapter.notifyItemChanged(position);

    }
    private  int position ;

    @Override
    public void onItemClicked(int position) {

        this.position = position;
        startActivity(EmployeeDetailActivity.class);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_employee_list, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            /*case android.R.id.home:
                onBackPressed();
                break;*/
            case R.id.action_verify_form:
                Long[] arr = new Long[employeeIdList.size()];
                arr = employeeIdList.toArray(arr);
                updateStatus = new UpdateStatus();
                updateStatus.setId(arr);
                if (checkConnection()) {
                    updateStatus();
                } else {
                    Toast.makeText(this, getResources().getString(R.string.msg_check_connection), Toast.LENGTH_SHORT).show();
                }
                break;

            case R.id.action_get_excel:
                if (checkConnection()) {
                    downloadExcel();
                } else {
                    Toast.makeText(this, getResources().getString(R.string.msg_check_connection), Toast.LENGTH_SHORT).show();
                }
                break;


        }

        return super.onOptionsItemSelected(item);
    }

    public void downloadExcel() {

        if (checkPermission()) {
            startDownload();

        } else {
            requestPermission();
        }
    }

    private boolean checkPermission() {
        int result = ContextCompat.checkSelfPermission(this,
                Manifest.permission.WRITE_EXTERNAL_STORAGE);
        if (result == PackageManager.PERMISSION_GRANTED) {
            processBar.setVisibility(View.VISIBLE);
            return true;

        } else {

            return false;
        }
    }

    private void registerReceiver() {

        LocalBroadcastManager bManager = LocalBroadcastManager.getInstance(this);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(MESSAGE_PROGRESS);
        bManager.registerReceiver(broadcastReceiver, intentFilter);

    }

    private void startDownload() {

        Intent intent = new Intent(this, DownloadExcelService.class);
        startService(intent);

    }

    private void requestPermission() {

        ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, PERMISSION_REQUEST_CODE);

    }

    private void updateStatus() {
        DialogUtitlity.showLoading(this);
        ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);
        Call<String> callClient = apiService.updateStatus(updateStatus);
        callClient.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                DialogUtitlity.hideLoading();
                switch (response.code()) {
                    case 201:
                        employeeRequestToServer();
                        break;
                }

            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                DialogUtitlity.hideLoading();
                showToast(t.toString());
            }
        });

    }


    private boolean checkConnection() {
        boolean isConnected = ConnectivityReceiver.isConnected();
        if (!isConnected) {

            //showSnack(isConnected);
            return false;
        }

        return true;
    }

}
