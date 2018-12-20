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

        sendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String value1 = indicator1.getText().toString();
                String value2 = indicator2.getText().toString();
                String value3 = indicator3.getText().toString();
                String value4 = indicator4.getText().toString();
                String value5 = indicator5.getText().toString();
                String value6 = indicator6.getText().toString();

                Intent intent = new Intent(FormActivity.this, TableActivity.class);

                intent.putExtra("VALUE1", value1);
                intent.putExtra("VALUE2", value2);
                intent.putExtra("VALUE3", value3);
                intent.putExtra("VALUE4", value4);
                intent.putExtra("VALUE5", value5);
                intent.putExtra("VALUE6", value6);

                startActivity(intent);
                }
            });

        }








}
