package com.example.healthease.Doctor;

import android.content.Intent;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
/**
 * Adapter class for handling click events on CardView components in the context of a list of doctors.
 * This class provides a way to set click listeners on CardView elements to start an activity with doctor details.
 */
public class DoctorCardViewAdapter {
    private final AppCompatActivity context;
    /**
     * Constructs a new DoctorCardViewAdapter with the specified context.
     *
     * @param context the context of the current activity.
     */
    public DoctorCardViewAdapter(AppCompatActivity context) {
        this.context = context;
    }
    /**
     * Sets a click listener on the specified CardView.
     * When the CardView is clicked, an intent is created and the corresponding activity is started with the provided title.
     *
     * @param cardView the CardView to set the click listener on.
     * @param title the title used to create the intent.
     */
    public void setOnClickListenerAdapter(CardView cardView, final String title) {
        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = DoctorIntentFactory.createDoctorDetailsIntent(context, title);
                context.startActivity(intent);
            }
        });
    }

}
