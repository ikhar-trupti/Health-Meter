package com.example.healthmeterdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity3 extends AppCompatActivity {
    private TextInputEditText field1;
    private TextInputEditText field2;
    private  Double bmrHere;
    private  Double bmiHere;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        Intent intent = getIntent();
        bmrHere = intent.getDoubleExtra("bmr",0.0);
        bmiHere = intent.getDoubleExtra("bmi",0.0);

            }
//
    public void showResult(View view) {

    }
}