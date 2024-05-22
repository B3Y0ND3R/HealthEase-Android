package com.example.healthease.Doctor;

import android.content.Intent;

import androidx.appcompat.app.AppCompatActivity;

import com.example.healthease.DoctorDetailsActivity;
/**
 * Factory class for creating Intents to launch DoctorDetailsActivity.
 */
public class DoctorIntentFactory {
    /**
     * Creates an Intent to launch DoctorDetailsActivity with the given title.
     *
     * @param context The context from which the Intent is created, typically an AppCompatActivity
     * @param title   The title to be passed to the DoctorDetailsActivity
     * @return An Intent to start DoctorDetailsActivity with the provided title
     */
    public static Intent createDoctorDetailsIntent(AppCompatActivity context, String title) {
        Intent intent = new Intent(context, DoctorDetailsActivity.class);
        intent.putExtra("title", title);
        return intent;
    }
}
