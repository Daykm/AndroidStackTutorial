package com.example.daykm.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import java.util.List;

import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class MainActivity extends AppCompatActivity {

    JobService mService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RestAdapter adapter = new RestAdapter.Builder()
                // TODO local host for emulator
                .setEndpoint("http://12.0.0.3")
                .build();

        mService = adapter.create(JobService.class);
    }

    @Override
    protected void onResume() {
        super.onResume();

        final Callback<List<Job>> listJobCallback = new Callback<List<Job>>() {
            @Override public void success(List<Job> jobs, Response response) {
                for(Job job : jobs) {
                    Log.i(MainActivity.class.getSimpleName(), job.getPosition() + " " + job.getLocation());
                }
            }

            @Override public void failure(RetrofitError error) {
                // We don't fail
            }
        };

        final Callback<Job> createJobCallback = new Callback<Job>() {
            @Override public void success(Job job, Response response) {
                mService.listJobs(listJobCallback);
            }

            @Override public void failure(RetrofitError error) {
                // We don't fail
            }
        };

        mService.createJob(new Job("Java Developer", "Bay area"), createJobCallback);
    }


}
