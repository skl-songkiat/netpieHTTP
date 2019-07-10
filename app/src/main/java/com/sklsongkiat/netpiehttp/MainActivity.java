package com.sklsongkiat.netpiehttp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    endpointUrlCallback endpointUrlCallback;
    Button button;
    TextView ResultAPI;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        endpointUrlCallback = new endpointUrlCallback(this);

        button = findViewById(R.id.ok) ;
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                endpointUrlCallback.GET();
                endpointUrlCallback.setCallback(new endpointUrlCallback.APICallback() {
                    @Override
                    public void cb(String json) {
                        Log.d("API : ", json);
                        ResultAPI = (TextView) findViewById(R.id.ResultAPI);
                        ResultAPI.setText(json);
                    }
                });


            }
        });



    }

}
