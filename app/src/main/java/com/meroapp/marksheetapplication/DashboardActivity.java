package com.meroapp.marksheetapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.meroapp.marksheetapplication.MarksCalculation.PercentageCalculator;

import java.util.PriorityQueue;

public class DashboardActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText editText_fullName,editText_iot,editText_android,editText_webApi;
    private Button   button_resultsCalculator;
    private TextView textView_results;
    private String full_name;
    private float iot,android,webApi,results;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText_fullName = findViewById(R.id.editText_fullName);
        editText_iot = findViewById(R.id.editText_iot);
        editText_android = findViewById(R.id.editText_android);
        editText_webApi = findViewById(R.id.editText_webApi);
        button_resultsCalculator = findViewById(R.id.button_resultsCalculator);
        textView_results = findViewById(R.id.textView_results);


        button_resultsCalculator.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        if (TextUtils.isEmpty(editText_fullName.getText().toString())){
            editText_fullName.setError("Please Enter Full Name!");
            return;
        } else if (TextUtils.isEmpty(editText_iot.getText().toString())) {
            editText_iot.setError("Please Enter Full Name!");
            return;
        } else if (TextUtils.isEmpty(editText_android.getText().toString())) {
            editText_android.setError("Please Enter Full Name!");
            return;
        } else if (TextUtils.isEmpty(editText_webApi.getText().toString())) {
            editText_webApi.setError("Please Enter Full Name!");
            return;
        } else {

            iot = Float.parseFloat(editText_iot.getText().toString());
            android = Float.parseFloat(editText_android.getText().toString());
            webApi = Float.parseFloat(editText_webApi.getText().toString());
            full_name = editText_fullName.getText().toString();


            PercentageCalculator percentageCal = new PercentageCalculator(iot, android, webApi);
            results = percentageCal.percentageCalculator();

            textView_results.append("Name: " + full_name
                    + " IOT: " + iot + " ANDROID: "
                    + android + " WEB API: " + webApi
                    + " Total Percentage: "
                    + results + "%" + "\n");
        }
    }
}
