package com.example.healthease;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class HealthConditionCheckActivity extends AppCompatActivity {

    CardView bmr,bmi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_health_condition_check);

        bmr=findViewById(R.id.bmrCard);
        bmi=findViewById(R.id.bmiCard);

        bmr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(HealthConditionCheckActivity.this, BMR.class));
            }
        });

        bmi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(HealthConditionCheckActivity.this, BMI.class));
            }
        });
    }
}