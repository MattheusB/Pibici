package com.example.mattheusbrito.pibiti.activity;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RelativeLayout;

import com.example.mattheusbrito.pibiti.R;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;

import java.util.ArrayList;
import java.util.List;

public class GraphicActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_graphic);


    // in this example, a LineChart is initialized from xml
    LineChart chart = (LineChart) findViewById(R.id.chart);

    Integer[] dataObjects = {1,4,11,12,13,25,36};

    List<Entry> entries = new ArrayList<Entry>();

    for (int i = 0; i < dataObjects.length; i++){
        entries.add(new Entry(dataObjects[i], dataObjects[i]));
        LineDataSet dataSet = new LineDataSet(entries, "Label"); // add entries to dataset
        dataSet.setColor(1);
        dataSet.setValueTextColor(1); // styling, ...

        LineData lineData = new LineData(dataSet);
        chart.setData(lineData);
        chart.invalidate(); // refresh


    }



    }


}
