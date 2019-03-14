package com.example.mattheusbrito.pibiti.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.example.mattheusbrito.pibiti.R;

public class TableActivity extends Activity {

    private TextView viewIndicator1;
    private TextView viewIndicator2;
    private TextView viewIndicator3;
    private TextView viewIndicator4;
    private TextView viewIndicator5;
    private TextView viewIndicator6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_table);


    }
}
