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

    public final static String EXTRA_MESSAGE = "com.example.mattheusbrito.pibiti.MESSAGE";

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

        indicator1 = (EditText) findViewById(R.id.table1ID);
        indicator2 = (EditText) findViewById(R.id.indicator2ID);
        indicator3 = (EditText) findViewById(R.id.indicador3ID);
        indicator4 = (EditText) findViewById(R.id.indicador4ID);
        indicator5 = (EditText) findViewById(R.id.indicador5ID);
        indicator6 = (EditText) findViewById(R.id.indicator6ID);

        sendButton = (Button) findViewById(R.id.sendButtonID);

        }

        public void sendIndicators(View view){

        Intent intent = new Intent(this, TableActivity.class);

        String indicator1Value = indicator1.getText().toString();
        String indicator2Value = indicator2.getText().toString();
        String indicator3Value = indicator3.getText().toString();
        String indicator4Value = indicator4.getText().toString();
        String indicator5Value = indicator5.getText().toString();
        String indicator6Value = indicator6.getText().toString();


        intent.putExtra(EXTRA_MESSAGE, indicator1Value);
        intent.putExtra(EXTRA_MESSAGE, indicator2Value);
        intent.putExtra(EXTRA_MESSAGE, indicator3Value);
        intent.putExtra(EXTRA_MESSAGE, indicator4Value);
        intent.putExtra(EXTRA_MESSAGE, indicator5Value);
        intent.putExtra(EXTRA_MESSAGE, indicator6Value);

        startActivity(intent);

        }








}
