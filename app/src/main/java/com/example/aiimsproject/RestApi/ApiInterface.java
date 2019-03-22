package com.example.aiimsproject.RestApi;

import com.example.aiimsproject.Model.RegistrationRequest;
import com.example.aiimsproject.Model.UpdateStatus;

import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.Streaming;

public interface ApiInterface {

    @Headers("Content-Type: application/json")
    @PUT("addEmployee")
    Call<String> employeeRegistration(@Body RegistrationRequest registrationRequest);




    @Headers("Content-Type: application/json")
    @GET("empList")
    Call<List<RegistrationRequest>> getEmployeeList();

    @Headers("Content-Type: application/json")
    @PUT("updateStatus")
    Call<String> updateStatus(@Body UpdateStatus updateStatus);


    @Headers("Content-Type: application/pdf")
    @GET("pdf/{id}")
    @Streaming
    Call<ResponseBody> downloadPDF(@Path("id") long userID);





    @Headers("Content-Type: application/pdf")
    @GET("getExcel")
    @Streaming
    Call<ResponseBody> downloadExcel();







}

