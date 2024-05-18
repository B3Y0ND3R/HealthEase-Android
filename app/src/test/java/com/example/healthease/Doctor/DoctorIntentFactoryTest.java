package com.example.healthease.Doctor;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;

import android.content.Intent;

import androidx.appcompat.app.AppCompatActivity;

import com.example.healthease.DoctorDetailsActivity;

import org.junit.Before;
import org.junit.Test;

public class
DoctorIntentFactoryTest {

    private AppCompatActivity mockContext;

    @Before
    public void setUp() {
        // Create a mock context using Mockito
        mockContext = mock(AppCompatActivity.class);
    }

    @Test
    public void testCreateDoctorDetailsIntent() {
        // Given a title for the intent
        String title = "Dr. Smith";

        // When calling the method to create the intent
        Intent intent = DoctorIntentFactory.createDoctorDetailsIntent(mockContext, title);

        // Then the intent should be created with the expected activity and title
        assertEquals(DoctorDetailsActivity.class.getName(), intent.getComponent().getClassName());
        assertEquals(title, intent.getStringExtra("title"));
    }

}