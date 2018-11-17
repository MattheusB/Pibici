package com.example.mattheusbrito.pibiti;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;
import com.loopj.android.http.RequestParams;
import org.json.JSONArray;
import android.text.TextUtils;

public class FormActivity extends Activity {

    private EditText indicator1;
    private EditText indicator2;
    private EditText indicator3;
    private EditText indicator4;
    private EditText indicator5;
    private EditText indicator6;

    private Button sendButton;

    private static final String RECORDS_ENDPOINT = "http://localhost:3000/records";

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
                addRelease();
            }

            private void addRelease(){
                String value1 = indicator1.getText().toString();
                String value2 = indicator2.getText().toString();
                String value3 = indicator3.getText().toString();
                String value4 = indicator4.getText().toString();
                String value5 = indicator5.getText().toString();
                String value6 = indicator6.getText().toString();

                if (TextUtils.isEmpty(value1) &&
                        TextUtils.isEmpty(value2) &&
                        TextUtils.isEmpty(value3)&&
                        TextUtils.isEmpty(value4) &&
                        TextUtils.isEmpty(value5) &&
                        TextUtils.isEmpty(value6)) {
                    return;
                }
                RequestParams params = new RequestParams();

                params.put("indicador1", value1);
                params.put("indicador2", value2);
                params.put("indicador3", value3);
                params.put("indicador4", value4);
                params.put("indicador5", value5);
                params.put("indicador6", value6);


                AsyncHttpClient client = new AsyncHttpClient();
                

            }
        });





    }
}
