package com.example.healthease.Doctor;

import android.content.Intent;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

public class DoctorCardViewAdapter {
    private final AppCompatActivity context;

    public DoctorCardViewAdapter(AppCompatActivity context) {
        this.context = context;
    }

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
