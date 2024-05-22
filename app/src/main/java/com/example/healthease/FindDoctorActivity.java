package com.example.healthease;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.healthease.Doctor.DoctorCardViewAdapter;
/**
 * The {@code FindDoctorActivity} class displays options to find doctors based on their specialization.
 * It provides clickable CardViews for different types of doctors and handles their click events.
 * Author: Md. Sakibur Rahman
 */
public class FindDoctorActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_doctor);

        // For exit CardView
        CardView exit = findViewById(R.id.cardFDBack);
        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(FindDoctorActivity.this, HomeActivity.class));
            }
        });

        DoctorCardViewAdapter doctorCardViewAdapter = new DoctorCardViewAdapter(this);

        doctorCardViewAdapter.setOnClickListenerAdapter(findViewById(R.id.cardFDFamilyPhysician), "Family Physician");
        doctorCardViewAdapter.setOnClickListenerAdapter(findViewById(R.id.cardFDDietician), "Dietician");
        doctorCardViewAdapter.setOnClickListenerAdapter(findViewById(R.id.cardFDDentist), "Dentist");
        doctorCardViewAdapter.setOnClickListenerAdapter(findViewById(R.id.cardFDSurgeon), "Surgeon");
        doctorCardViewAdapter.setOnClickListenerAdapter(findViewById(R.id.cardFDCardioloist), "Cardiologist");


//// For family physician CardView
//        CardView familyPhysician = findViewById(R.id.cardFDFamilyPhysician);
//        familyPhysician.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent it = new Intent(FindDoctorActivity.this, DoctorDetailsActivity.class);
//                it.putExtra("title", "Family Physicians");
//                startActivity(it);
//            }
//        });
//
//// For dietician CardView
//        CardView dietician = findViewById(R.id.cardFDDietician);
//        dietician.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent it = new Intent(FindDoctorActivity.this, DoctorDetailsActivity.class);
//                it.putExtra("title", "Dietician");
//                startActivity(it);
//            }
//        });
//
//        CardView dentist = findViewById(R.id.cardFDDentist);
//        dentist.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent it = new Intent(FindDoctorActivity.this, DoctorDetailsActivity.class);
//                it.putExtra("title", "Dentist");
//                startActivity(it);
//            }
//        });
//
//        CardView surgeon = findViewById(R.id.cardFDSurgeon);
//        surgeon.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent it = new Intent(FindDoctorActivity.this, DoctorDetailsActivity.class);
//                it.putExtra("title", "Surgeon");
//                startActivity(it);
//            }
//        });
//
//        CardView cardiologists = findViewById(R.id.cardFDCardioloist);
//        cardiologists.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent it = new Intent(FindDoctorActivity.this, DoctorDetailsActivity.class);
//                it.putExtra("title", "Cardiologist");
//                startActivity(it);
//            }
//        });

    }
}