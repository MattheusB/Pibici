package com.example.mattheusbrito.pibiti.activity;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RelativeLayout;

import com.example.mattheusbrito.pibiti.R;
import com.example.mattheusbrito.pibiti.mock.Mock;
import com.example.mattheusbrito.pibiti.release.Release;
import com.example.mattheusbrito.pibiti.release.ReleaseAdapter;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;

import java.util.ArrayList;
import java.util.List;

public class GraphicActivity extends AppCompatActivity {

    private ReleaseAdapter releaseAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_graphic);

        releaseAdapter = new ReleaseAdapter(this);


    LineChart chart = (LineChart) findViewById(R.id.chart);


    List<Entry> entries = new ArrayList<Entry>();


    for (int i = 0; i < Mock.size(); i++){
        Release release = Mock.get(i);
        if (release.indicador1.equals("Perdas de Qualidade")){
            int total = release.indicador2 + release.indicador3 + release.indicador4;
            entries.add(new Entry(release.indicador5, total));
        }

        LineDataSet dataSet = new LineDataSet(entries, "Label");
        dataSet.setColor(1);
        dataSet.setValueTextColor(1);

        LineData lineData = new LineData(dataSet);
        chart.setData(lineData);
        chart.invalidate();


    }



    }


}
