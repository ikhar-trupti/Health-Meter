package com.example.healthmeterdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class MainActivity2 extends AppCompatActivity {
    private RadioButton selectedGender ;
    private RadioGroup genderGroup;
    private  TextInputEditText userAge ;
    private  TextInputEditText userHeight ;
    private  TextInputEditText userWeight ;
    double resultBMI ;
    double resultBMR ;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        genderGroup = findViewById(R.id.genderGroup);
        genderGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                selectedGender = findViewById(i);

            }
        });
        userAge = findViewById(R.id.age);
        userHeight = findViewById(R.id.height);
        userWeight = findViewById(R.id.weight);

    }
    private void calculation(){


        double age = Double.parseDouble(userAge.getText().toString().trim());
        double height = Double.parseDouble(userHeight.getText().toString().trim());
        double weight = Double.parseDouble(userWeight.getText().toString().trim());

        if(height > 0.0 && weight>0.0 && age> 0.0)
        {
            if (selectedGender.getText().toString().equals("Male")) {
                resultBMR = 88.362 + (13.397 * weight) + (4.799 * height) - (5.677 * age);
            } else {
                resultBMR = 447.593 + (9.247 * weight) + (3.098 * height) - (4.330 * age);
            }
            height *= 0.01;
            resultBMI = weight / (height * height);
            resultBMI = Double.parseDouble(String.format("%.2f", resultBMI));
        } else {
            Toast.makeText(this, "invalid data", Toast.LENGTH_SHORT).show();
        }
    }
    public void goToEnd(View view) {
        calculation();
        Intent intent = new Intent(getApplicationContext() , MainActivity4.class);

        startActivity(intent);

    }
}