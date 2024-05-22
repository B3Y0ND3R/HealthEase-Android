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

import com.example.healthease.Doctor.TotalAppointmentFactory;

import java.util.Calendar;
/**
 * Activity for booking an appointment with a doctor.
 *
 * This activity allows users to select a date and time for an appointment,
 * and then confirm the booking. It displays details such as the doctor's name,
 * address, contact number, and consultation fees.
 *
 * Author: Md. Sakibur Rahman
 */
public class BookAppointmentActivity extends AppCompatActivity {

    EditText ed1,ed2,ed3,ed4;
    TextView tv;
    private DatePickerDialog datePickerDialog;
    private TimePickerDialog timePickerDialog;
    private AppCompatButton dateButton, timeButton, btnbook, btnback;
    /**
     * Called when the activity is first created.
     *
     * @param savedInstanceState If the activity is being re-initialized after previously being shut down, this contains the most recent data supplied in onSaveInstanceState(Bundle).
     */
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


        initDatePicker();
        initTimePicker();


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



                Database db = Database.getInstance(getApplicationContext(), null);

                int a = Integer.parseInt(db.getTotal(title));

                TotalAppointmentFactory.updateAppointmentNumber(title, a+1);
                db.updateTotalAppointment(title,a+1);

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


            }
        });

    }
    /**
     * Initializes the DatePickerDialog and sets its minimum date to the next day.
     */
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
    /**
     * Initializes the TimePickerDialog.
     */
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