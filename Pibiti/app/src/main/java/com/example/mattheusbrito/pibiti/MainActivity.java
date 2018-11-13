package com.example.mattheusbrito.pibiti;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends Activity {

    private ImageView tableButton;
    private ImageView formButton;
    private ImageView graphicButton;
    private ImageView analysisButton;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tableButton = (ImageView) findViewById(R.id.graphicID);
        formButton = (ImageView) findViewById(R.id.formID);
        graphicButton = (ImageView) findViewById(R.id.graphicViewID);
        analysisButton = (ImageView) findViewById(R.id.analysisID);


        tableButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, TableActivity.class));
            }
        });

        formButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, FormActivity.class));
            }
        });

        graphicButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, GraphicActivity.class));
            }
        });

        analysisButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, AnalysisActivity.class));
            }
        });
    }
}
