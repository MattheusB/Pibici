package com.example.mattheusbrito.pibiti.activity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.mattheusbrito.pibiti.record.Release;
import com.example.mattheusbrito.pibiti.record.ReleaseAdapter;
import com.google.gson.Gson;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;
import com.loopj.android.http.RequestParams;
import org.json.JSONArray;

import android.widget.ListView;
import android.widget.Toast;

import com.example.mattheusbrito.pibiti.R;
import com.pusher.client.Pusher;
import com.pusher.client.PusherOptions;
import com.pusher.client.channel.Channel;
import com.pusher.client.channel.SubscriptionEventListener;

import java.util.ArrayList;


public class FormActivity extends Activity implements View.OnClickListener {

    private static final String RELEASE_ENDPOINT = "http://localhost:3000/lancamentos";

    private EditText indicator1;
    private EditText indicator2;
    private EditText indicator3;
    private EditText indicator4;
    private EditText indicator5;
    private EditText indicator6;

    private ReleaseAdapter releaseAdapter;

    private Button sendButton;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);

        releaseAdapter = new ReleaseAdapter(this, new ArrayList<Release>());
        final ListView releasesView = (ListView) findViewById(R.id.releaseListID);
        releasesView.setAdapter(releaseAdapter);


        PusherOptions options = new PusherOptions();
        options.setCluster("us2");

        Pusher pusher = new Pusher("6649d90faeacdd56ad9b");
        pusher.connect();

        Channel channel = pusher.subscribe("releases");
        channel.bind("new_release", new SubscriptionEventListener() {
            @Override
            public void onEvent(String channelName, String eventName, final String data) {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Gson gson = new Gson();
                        Release release = gson.fromJson(data, Release.class);
                        releaseAdapter.add(release);
                        releasesView.setSelection(releaseAdapter.getCount() - 1);
                    }
                });
            }

        });


        indicator1 = (EditText) findViewById(R.id.indicator1ID);
        indicator2 = (EditText) findViewById(R.id.indicator2ID);
        indicator3 = (EditText) findViewById(R.id.indicador3ID);
        indicator4 = (EditText) findViewById(R.id.indicador4ID);
        indicator5 = (EditText) findViewById(R.id.indicador5ID);
        indicator6 = (EditText) findViewById(R.id.indicator6ID);

        sendButton = (Button) findViewById(R.id.sendButtonID);

        sendButton.setOnClickListener(this);

        }

        public void sendIndicators(){

        Intent intent = new Intent(this, TableActivity.class);

        int indicator1Value = Integer.parseInt(indicator1.getText().toString());
        int indicator2Value = Integer.parseInt(indicator2.getText().toString());
        int indicator3Value = Integer.parseInt(indicator3.getText().toString());
        int indicator4Value = Integer.parseInt(indicator4.getText().toString());
        int indicator5Value = Integer.parseInt(indicator5.getText().toString());
        int indicator6Value = Integer.parseInt(indicator6.getText().toString());


            RequestParams params = new RequestParams();

            params.put("indicador1", indicator1Value);
            params.put("indicador2", indicator2Value);
            params.put("indicador3", indicator3Value);
            params.put("indicador4", indicator4Value);

            AsyncHttpClient client = new AsyncHttpClient();

            client.post(RELEASE_ENDPOINT, params, new JsonHttpResponseHandler(){

                @Override
                public void onSuccess(
                        int statusCode,
                        cz.msebera.android.httpclient.Header[] headers,
                        JSONArray response) {
                    super.onSuccess(statusCode, headers, response);
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            indicator1.setText("");
                            indicator2.setText("");
                            indicator3.setText("");
                            indicator4.setText("");
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





    @Override
    public void onClick(View v) {
        sendIndicators();
    }


}
