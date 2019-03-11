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

    private TextView viewIndicator1 = new TextView(this);
    private TextView viewIndicator2 = new TextView(this);
    private TextView viewIndicator3 = new TextView(this);
    private TextView viewIndicator4 = new TextView(this);
    private TextView viewIndicator5 = new TextView(this);
    private TextView viewIndicator6 = new TextView(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        Intent intent = getIntent();

        String indicator1Value = intent.getStringExtra(FormActivity.EXTRA_MESSAGE);
        String indicator2Value = intent.getStringExtra(FormActivity.EXTRA_MESSAGE);
        String indicator3Value = intent.getStringExtra(FormActivity.EXTRA_MESSAGE);
        String indicator4Value = intent.getStringExtra(FormActivity.EXTRA_MESSAGE);
        String indicator5Value = intent.getStringExtra(FormActivity.EXTRA_MESSAGE);
        String indicator6Value = intent.getStringExtra(FormActivity.EXTRA_MESSAGE);




        viewIndicator1.setText(indicator1Value);
        viewIndicator2.setText(indicator2Value);
        viewIndicator3.setText(indicator3Value);
        viewIndicator4.setText(indicator4Value);
        viewIndicator5.setText(indicator5Value);
        viewIndicator6.setText(indicator6Value);

       setContentView(R.layout.activity_table);
    }
}
