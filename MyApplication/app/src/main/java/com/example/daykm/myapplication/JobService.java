package com.example.daykm.myapplication;

import java.util.List;

import retrofit.Callback;
import retrofit.http.Body;
import retrofit.http.GET;
import retrofit.http.POST;

public interface JobService {

    @GET("/jobs")
    void listJobs(Callback<List<Job>> callback);

    @POST("/jobs")
    void createJob(@Body Job job, Callback<Job> callback);

}
