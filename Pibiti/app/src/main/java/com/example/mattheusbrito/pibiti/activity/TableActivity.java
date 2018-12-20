package com.example.mattheusbrito.pibiti.activity;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.mattheusbrito.pibiti.R;
import com.example.mattheusbrito.pibiti.mock.Mock;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class TableActivity extends Activity {

    private TextView v1;
    private TextView v2;
    private TextView v3;
    private TextView v4;
    private TextView v5;
    private TextView v6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_table);

        v1 = (TextView) findViewById(R.id.value1ID);
        v2 = (TextView) findViewById(R.id.value2ID);
        v3 = (TextView) findViewById(R.id.value3ID);
        v4 = (TextView) findViewById(R.id.value4ID);
        v5 = (TextView) findViewById(R.id.value5ID);
        v6 = (TextView) findViewById(R.id.value6ID);

        v1.setText(getIntent().getStringExtra("VALUE1"));
        v2.setText(getIntent().getStringExtra("VALUE2"));
        v3.setText(getIntent().getStringExtra("VALUE3"));
        v4.setText(getIntent().getStringExtra("VALUE4"));
        v5.setText(getIntent().getStringExtra("VALUE5"));
        v6.setText(getIntent().getStringExtra("VALUE6"));


    }
}
