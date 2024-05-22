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
import com.example.healthease.HomeActivity;
import com.example.healthease.R;
/**
 * BuyMedicineBookActivity handles the booking process for medicines.
 * Users can enter their personal details and book their medicine orders.
 */
public class BuyMedicineBookActivity extends AppCompatActivity {

    EditText edname, edaddress, edcontact, edpincode;
    AppCompatButton btnBooking;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buy_medicine_book);

        edname=findViewById(R.id.editTextBMBFullName);
        edaddress=findViewById(R.id.editTextBMBAddress);
        edcontact=findViewById(R.id.editTextBMBContactNumber);
        edpincode=findViewById(R.id.editTextBMBPincode);
        btnBooking=findViewById(R.id.buttonBMBBook);

        Intent intent=getIntent();
//        String[] price = intent.getStringArrayExtra("price").toString().split(java.util.regex.Pattern.quote(":"));
        String price = intent.getStringExtra("price");
        String date = intent.getStringExtra("date");
        //String time = intent.getStringExtra("time");

        btnBooking.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences sharedPreferences= getSharedPreferences("shared_prefs", Context.MODE_PRIVATE);
                String username = sharedPreferences.getString("username", "").toString();

                Database db = Database.getInstance(getApplicationContext(),null);
                db.addOrder(username,edname.getText().toString(),edaddress.getText().toString(),edcontact.getText().toString(), Integer.parseInt(edpincode.getText().toString()), date.toString(),"", Float.parseFloat(price.toString()),"medicine");
                db.removeCart(username,"lab");
                Toast.makeText(BuyMedicineBookActivity.this, "Your booking is done successfully", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(BuyMedicineBookActivity.this, HomeActivity.class));
            }
        });
    }
}