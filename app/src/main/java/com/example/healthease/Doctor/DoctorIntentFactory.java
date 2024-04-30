package com.example.healthease.Doctor;

import android.content.Intent;

import androidx.appcompat.app.AppCompatActivity;

import com.example.healthease.DoctorDetailsActivity;

public class DoctorIntentFactory {
    public static Intent createDoctorDetailsIntent(AppCompatActivity context, String title) {
        Intent intent = new Intent(context, DoctorDetailsActivity.class);
        intent.putExtra("title", title);
        return intent;
    }
}
