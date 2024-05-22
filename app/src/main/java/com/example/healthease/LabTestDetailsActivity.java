package com.example.healthease;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
/**
 * The {@code LabTestDetailsActivity} class displays the details of a selected lab test package.
 * Users can view the package name, total cost, and details, and add the package to their cart.
 * Author: Md. Sakibur Rahman
 */
public class LabTestDetailsActivity extends AppCompatActivity {

    TextView tvPackageName, tvTotalCost;
    EditText edDetails;
    AppCompatButton btnAddToCart, btnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab_test_details);

        tvPackageName = findViewById(R.id.textViewLDPackageName);
        tvTotalCost = findViewById(R.id.textViewLDTotalCost);
        edDetails = findViewById(R.id.editTestLDMultiLine);
        btnAddToCart = findViewById(R.id.buttonLDAddToCart);
        btnBack = findViewById(R.id.buttonLDBack);

        edDetails.setKeyListener(null);

        Intent intent = getIntent();
        tvPackageName.setText("Package Name: " + intent.getStringExtra("text1"));
        tvTotalCost.setText("Total Cost: " + intent.getStringExtra("text3") + "/- taka");
        edDetails.setText("Package Details: "+intent.getStringExtra("text2"));


        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LabTestDetailsActivity.this, LabTestActivity.class));
            }
        });

        btnAddToCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences sharedPreferences = getSharedPreferences("shared_prefs", Context.MODE_PRIVATE);
                String username = sharedPreferences.getString("username", "").toString();
                String product = tvPackageName.getText().toString();
                float price = Float.parseFloat(intent.getStringExtra("text3"));
                Database db = Database.getInstance(getApplicationContext(),null);
                if(db.checkCart(username,product)==1)
                {
                    Toast.makeText(LabTestDetailsActivity.this, "Product Already Added", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    db.addCart(username,product,price,"lab");
                    Toast.makeText(LabTestDetailsActivity.this, "Record Inserted to Cart", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(LabTestDetailsActivity.this, LabTestActivity.class));
                }
            }
        });


    }

}