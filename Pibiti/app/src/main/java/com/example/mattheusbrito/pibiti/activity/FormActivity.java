package com.example.mattheusbrito.pibiti.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.mattheusbrito.pibiti.R;
import com.example.mattheusbrito.pibiti.mock.Mock;

public class FormActivity extends Activity {

    public final static String EXTRA_INDICATOR1 = "com.example.mattheusbrito.pibiti.INDICATOR1";
    public final static String EXTRA_INDICATOR2 = "com.example.mattheusbrito.pibiti.INDICATOR2";
    public final static String EXTRA_INDICATOR3 = "com.example.mattheusbrito.pibiti.INDICATOR3";
    public final static String EXTRA_INDICATOR4 = "com.example.mattheusbrito.pibiti.INDICATOR4";
    public final static String EXTRA_INDICATOR5 = "com.example.mattheusbrito.pibiti.INDICATOR5";
    public final static String EXTRA_INDICATOR6 = "com.example.mattheusbrito.pibiti.INDICATOR6";

    private EditText indicator1;
    private EditText indicator2;
    private EditText indicator3;
    private EditText indicator4;
    private EditText indicator5;
    private EditText indicator6;

    private Button sendButton;

    private Mock mock = new Mock();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);

        indicator1 = (EditText) findViewById(R.id.indicator1ID);
        indicator2 = (EditText) findViewById(R.id.indicator2ID);
        indicator3 = (EditText) findViewById(R.id.indicador3ID);
        indicator4 = (EditText) findViewById(R.id.indicador4ID);
        indicator5 = (EditText) findViewById(R.id.indicador5ID);
        indicator6 = (EditText) findViewById(R.id.indicator6ID);

        sendButton = (Button) findViewById(R.id.sendButtonID);

        sendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendIndicators();
            }
        });

        }

        public void sendIndicators(){

        Intent intent = new Intent(this, TableActivity.class);

        int indicator1Value = Integer.parseInt(indicator1.getText().toString());
        int indicator2Value = Integer.parseInt(indicator2.getText().toString());
        int indicator3Value = Integer.parseInt(indicator3.getText().toString());
        int indicator4Value = Integer.parseInt(indicator4.getText().toString());
        int indicator5Value = Integer.parseInt(indicator5.getText().toString());
        int indicator6Value = Integer.parseInt(indicator6.getText().toString());


        intent.putExtra(EXTRA_INDICATOR1, indicator1Value);
        intent.putExtra(EXTRA_INDICATOR2, indicator2Value);
        intent.putExtra(EXTRA_INDICATOR3, indicator3Value);
        intent.putExtra(EXTRA_INDICATOR4, indicator4Value);
        intent.putExtra(EXTRA_INDICATOR5, indicator5Value);
        intent.putExtra(EXTRA_INDICATOR6, indicator6Value);

        startActivity(intent);

        }








}
