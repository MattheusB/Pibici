package com.example.mattheusbrito.pibiti.activity;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import com.example.mattheusbrito.pibiti.R;
import com.example.mattheusbrito.pibiti.release.Release;
import com.example.mattheusbrito.pibiti.release.ReleaseAdapter;
import com.google.gson.Gson;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;

public class TableActivity extends Activity {

    private static final String RELEASE_ENDPOINT = "http://10.0.2.2:3001/lancamentos";


    private ReleaseAdapter releaseAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_table);

        releaseAdapter = new ReleaseAdapter(this);
        final ListView releasesView = (ListView) findViewById(R.id.releaseListID);
        releasesView.setAdapter(releaseAdapter);


        AsyncHttpClient client = new AsyncHttpClient();

        client.get(RELEASE_ENDPOINT,new JsonHttpResponseHandler() {

            @Override
            public void onSuccess(
                    int statusCode,
                    cz.msebera.android.httpclient.Header[] headers,
                    final JSONArray response) {
                super.onSuccess(statusCode, headers, response);
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        for (int i = 0; i < response.length(); i++) {


                            Gson gson = new Gson();
                            try {
                                Release release = gson.fromJson(response.getString(i), Release.class);

                                releaseAdapter.add(release);
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }

                            releasesView.setSelection(releaseAdapter.getCount() - 1);
                        }
                    }
                });
            }

            @Override
            public void onFailure(
                    int statusCode,
                    cz.msebera.android.httpclient.Header[] headers,
                    String responseString,
                    Throwable throwable) {
                super.onFailure(statusCode, headers, responseString, throwable);
                Toast.makeText(
                        getApplicationContext(), "Não pode ser lancado!",
                        Toast.LENGTH_LONG
                ).show();
            }
        });




    }
}
