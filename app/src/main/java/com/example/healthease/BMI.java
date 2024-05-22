package com.example.healthease;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import com.example.healthease.HealthConditionCheck.ConditionCheck;
import com.example.healthease.HealthConditionCheck.Factory;

public class BMI extends AppCompatActivity {

    EditText edKg, edFeet, edIns;
    CardView cardBtn;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmi);

        edFeet = findViewById(R.id.edFeet);
        edKg = findViewById(R.id.edKg);
        cardBtn = findViewById(R.id.cardBtn);
        textView = findViewById(R.id.textView);
        edIns = findViewById(R.id.edIns);

        cardBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String kg = edKg.getText().toString();
                String feet = edFeet.getText().toString();
                String inc = edIns.getText().toString();

                if (!kg.isEmpty() && !feet.isEmpty() && !inc.isEmpty()) {
                    float weight = Float.parseFloat(kg);
                    float efeet = Float.parseFloat(feet);
                    float eInc = Float.parseFloat(inc);

                    float height = (float) ((efeet * 12 + eInc) * 0.0254);

                    ConditionCheck bmi = Factory.getConditionObject("BMI", weight, height, 25, "Male");

                    if (bmi != null) {
                        textView.setText(String.valueOf(bmi.getResult()));
                    } else {
                        textView.setText("Failed to calculate BMI.");
                    }
                } else {
                    textView.setText("Please Input All Boxes.");
                }
            }
        });
    }
}
