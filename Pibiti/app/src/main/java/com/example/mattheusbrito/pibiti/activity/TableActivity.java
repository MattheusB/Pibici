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

        Intent intent = getIntent();

        int indicator1Value = intent.getIntExtra(FormActivity.EXTRA_INDICATOR1, 0);
        int indicator2Value = intent.getIntExtra(FormActivity.EXTRA_INDICATOR2, 0);
        int indicator3Value = intent.getIntExtra(FormActivity.EXTRA_INDICATOR3, 0);
        int indicator4Value = intent.getIntExtra(FormActivity.EXTRA_INDICATOR4, 0);
        int indicator5Value = intent.getIntExtra(FormActivity.EXTRA_INDICATOR5, 0);
        int indicator6Value = intent.getIntExtra(FormActivity.EXTRA_INDICATOR6, 0);


        viewIndicator1 = findViewById(R.id.indicatorValue1ID);
        viewIndicator2 = findViewById(R.id.indicatorValue2ID);
        viewIndicator3 = findViewById(R.id.indicatorValue3ID);
        viewIndicator4 = findViewById(R.id.indicatorValue4ID);
        viewIndicator5 = findViewById(R.id.indicatorValue5ID);
        viewIndicator6 = findViewById(R.id.indicatorValue6ID);


        viewIndicator1.setText("" + indicator1Value);
        viewIndicator2.setText("" + indicator2Value);
        viewIndicator3.setText("" + indicator3Value);
        viewIndicator4.setText("" + indicator4Value);
        viewIndicator5.setText("" + indicator5Value);
        viewIndicator6.setText("" + indicator6Value);


    }
}
