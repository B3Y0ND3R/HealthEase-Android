package com.example.healthease;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import com.example.healthease.Database;

import java.util.Calendar;

public class BookAppointmentActivity extends AppCompatActivity {

    EditText ed1,ed2,ed3,ed4;
    TextView tv;
    private DatePickerDialog datePickerDialog;
    private TimePickerDialog timePickerDialog;
    private AppCompatButton dateButton, timeButton, btnbook, btnback;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_appointment);
        tv = findViewById(R.id.textViewAPPTitle);

        ed1 = findViewById(R.id.editTextAppFullName);
        ed2 = findViewById(R.id.editTextAppAddress);
        ed3 = findViewById(R.id.editTextAppContactNumber);
        ed4 = findViewById(R.id.editTextAppFees);
        dateButton=findViewById(R.id.buttonAppDate);
        timeButton=findViewById(R.id.buttonAppTime);
        btnbook = findViewById(R.id.buttonBookAppointment);
        btnback = findViewById(R.id.buttonBack);

        ed1.setKeyListener(null);
        ed2.setKeyListener(null);
        ed3.setKeyListener(null);
        ed4.setKeyListener(null);

        Intent it = getIntent();
        String title = it.getStringExtra("text1");
        String fullName = it.getStringExtra("text2");
        String address = it.getStringExtra("text3");
        String contact = it.getStringExtra("text4");
        String fees = it.getStringExtra("text5");

        tv.setText(title);
        ed1.setText(fullName);
        ed2.setText(address);
        ed3.setText(contact);
        ed4.setText("Cons Fees: " + fees +"/-");

        // Initialize date and time pickers
        initDatePicker();
        initTimePicker();

        // Set click listeners for date and time buttons
        dateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                datePickerDialog.show();
            }
        });

        timeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                timePickerDialog.show();
            }
        });

        btnback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(BookAppointmentActivity.this, FindDoctorActivity.class));
            }
        });

        btnbook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Database db = new Database(getApplicationContext(), "healthcare", null, 2);
                SharedPreferences sharedPreferences= getSharedPreferences("shared_prefs", Context.MODE_PRIVATE);
                String username = sharedPreferences.getString("username", "").toString();
                int x = db.checkAppointmentExists(username, title+ " => "+fullName,address,contact,dateButton.getText().toString(), timeButton.getText().toString());
                if(x==1)
                {
                    Toast.makeText(BookAppointmentActivity.this, "Appointment already booked", Toast.LENGTH_SHORT).show();

                }
                else
                {
                    db.addOrder(username, title+ " => "+fullName,address,contact,0,dateButton.getText().toString(), timeButton.getText().toString(), Float.parseFloat(fees), "appointment");
                    Toast.makeText(BookAppointmentActivity.this, "Your appointment is done successfully", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(BookAppointmentActivity.this, FindDoctorActivity.class));
                }


//                SharedPreferences sharedPreferences = getSharedPreferences("shared_prefs", Context.MODE_PRIVATE);
//                String username = sharedPreferences.getString("username", "");
//
//                Database db = new Database(getApplicationContext(), "healthcare", null, 1);
//
//                try {
//                    String docName = ed1.getText().toString();
//                    String address = ed2.getText().toString();
//                    String contact = ed3.getText().toString();
//                    String date = dateButton.getText().toString();
//                    String time = timeButton.getText().toString();
//                    String priceString = ed4.getText().toString();
//
//                    float price = Float.parseFloat(fees);
//
//                    db.addAppointment(username, docName, address, contact, date, time, price, "appoint");
//
//                    //    db.removeCart(username, "lab");
//
//                    Toast.makeText(BookAppointmentActivity.this, "Your appointment was successfully booked!", Toast.LENGTH_SHORT).show();
//
//                    Intent homeIntent = new Intent(BookAppointmentActivity.this, HomeActivity.class);
//                    startActivity(homeIntent);
//                } catch (NumberFormatException e) {
//                    Toast.makeText(BookAppointmentActivity.this, "Invalid input for price", Toast.LENGTH_SHORT).show();
//                } catch (Exception e) {
//                    Toast.makeText(BookAppointmentActivity.this, "An error occurred: " + e.getMessage(), Toast.LENGTH_SHORT).show();
//                }

            }
        });

    }

    private void initDatePicker() {
        Calendar cal = Calendar.getInstance();
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH);
        int day = cal.get(Calendar.DAY_OF_MONTH);

        int style = AlertDialog.THEME_HOLO_DARK;
        datePickerDialog = new DatePickerDialog(BookAppointmentActivity.this, style, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                dateButton.setText(i2+"-"+(i1+1)+"-"+i);
            }
        }, year, month, day);
        datePickerDialog.getDatePicker().setMinDate(cal.getTimeInMillis() + 86400000);
    }

    private void initTimePicker() {
        Calendar cal = Calendar.getInstance();
        int hrs = cal.get(Calendar.HOUR_OF_DAY);
        int mins = cal.get(Calendar.MINUTE);

        int style = AlertDialog.THEME_HOLO_DARK;
        timePickerDialog = new TimePickerDialog(BookAppointmentActivity.this, style, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker timePicker, int i, int i1) {
                timeButton.setText(String.format("%02d:%02d", i, i1));
            }
        }, hrs, mins, true);
    }

}