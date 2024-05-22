package com.example.healthease;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.healthease.Database;

public class LabTestBookActivity extends AppCompatActivity {

    EditText edname, edaddress, edcontact, edpincode;
    AppCompatButton btnBooking;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab_test_book);

        edname=findViewById(R.id.editTextLTBFullName);
        edaddress=findViewById(R.id.editTextLTBAddress);
        edcontact=findViewById(R.id.editTextLTBContactNumber);
        edpincode=findViewById(R.id.editTextLTBContactNumber);
        btnBooking=findViewById(R.id.buttonLTBBook);

        Intent intent=getIntent();
//        String[] price = intent.getStringArrayExtra("price").toString().split(java.util.regex.Pattern.quote(":"));
        String price = intent.getStringExtra("price");
        String date = intent.getStringExtra("date");
        String time = intent.getStringExtra("time");

        btnBooking.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences sharedPreferences= getSharedPreferences("shared_prefs", Context.MODE_PRIVATE);
                String username = sharedPreferences.getString("username", "").toString();

                Database db = Database.getInstance(getApplicationContext(),null);
                db.addOrder(username,edname.getText().toString(),edaddress.getText().toString(),edcontact.getText().toString(), Integer.parseInt(edpincode.getText().toString()), date.toString(), time.toString(), Float.parseFloat(price.toString()),"lab");
                db.removeCart(username,"lab");
                Toast.makeText(LabTestBookActivity.this, "Your booking is done successfully", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(LabTestBookActivity.this, HomeActivity.class));
            }
        });


    }
}