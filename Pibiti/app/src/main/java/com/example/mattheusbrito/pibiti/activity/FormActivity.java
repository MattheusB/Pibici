package com.example.mattheusbrito.pibiti.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import org.json.JSONArray;

import android.widget.Spinner;
import android.widget.Toast;

import com.example.mattheusbrito.pibiti.R;


public class FormActivity extends Activity implements View.OnClickListener {

    private static final String RELEASE_ENDPOINT = "http://10.0.2.2:3001/lancamentos";

    private EditText indicator1;
    private EditText indicator2;
    private EditText indicator3;
    private EditText indicator4;
    private EditText indicator5;
    private EditText indicator6;

   private ConstraintLayout constraintProducaoHoraria;
   private ConstraintLayout constraintProducaoReal;
   private ConstraintLayout constraintPerdasQualidade;
   private ConstraintLayout constraintEmbalagemUtilizada;

    private Spinner spinner;

    private ArrayAdapter<CharSequence> indicators;



    private Button sendButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);


/*        indicator1 = (EditText) findViewById(R.id.indicator1ID);
        indicator2 = (EditText) findViewById(R.id.indicator2ID);
        indicator3 = (EditText) findViewById(R.id.indicador3ID);
        indicator4 = (EditText) findViewById(R.id.indicador4ID);*/

        spinner = (Spinner) findViewById(R.id.spinnerID);

        indicators = ArrayAdapter.createFromResource(this, R.array.indicatorsArray, android.R.layout.simple_spinner_item);
        indicators.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        constraintProducaoHoraria = (ConstraintLayout) findViewById(R.id.constraintProducaoHoraria);
        constraintProducaoReal = (ConstraintLayout) findViewById(R.id.constraintProducaoReal);
        constraintPerdasQualidade = (ConstraintLayout) findViewById(R.id.constraintPerdasQualidade);
        constraintEmbalagemUtilizada = (ConstraintLayout) findViewById(R.id.constraintEmbalagemUtilizada);


        spinner.setAdapter(indicators);

        sendButton = (Button) findViewById(R.id.sendButtonID);


        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                switch (position){
                    case 0:
                        setAllGone();
                        constraintProducaoHoraria.setVisibility(View.VISIBLE);
                        break;
                    case 1:
                        setAllGone();
                        constraintProducaoReal.setVisibility(View.VISIBLE);
                        break;
                    case 2:
                        setAllGone();
                        constraintPerdasQualidade.setVisibility(View.VISIBLE);
                        break;
                    case 3:
                        setAllGone();
                        constraintEmbalagemUtilizada.setVisibility(View.VISIBLE);
                        break;
                }


            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {

            }

        });



        sendButton.setOnClickListener(this);

    }

    public void sendIndicators() {

        String indicator1Value = indicator1.getText().toString();
        int indicator2Value = Integer.parseInt(indicator2.getText().toString());
        int indicator3Value = Integer.parseInt(indicator3.getText().toString());
        int indicator4Value = Integer.parseInt(indicator4.getText().toString());

        RequestParams params = new RequestParams();

        params.put("indicador1", indicator1Value);
        params.put("indicador2", indicator2Value);
        params.put("indicador3", indicator3Value);
        params.put("indicador4", indicator4Value);

        AsyncHttpClient client = new AsyncHttpClient();


        client.post(RELEASE_ENDPOINT, params, new JsonHttpResponseHandler() {

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
        Intent intent = new Intent(this, TableActivity.class);
        startActivity(intent);
    }


    private void setAllGone(){
        constraintProducaoHoraria.setVisibility(View.GONE);
        constraintProducaoReal.setVisibility(View.GONE);
        constraintPerdasQualidade.setVisibility(View.GONE);
        constraintEmbalagemUtilizada.setVisibility(View.GONE);
    }




}
