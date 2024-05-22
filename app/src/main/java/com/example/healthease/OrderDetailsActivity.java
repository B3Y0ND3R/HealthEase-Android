package com.example.healthease;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import com.example.healthease.Order.OrderAdapter;

import java.util.ArrayList;

/**
 * OrderDetailsActivity displays the order details for the logged-in user.
 */
public class OrderDetailsActivity extends AppCompatActivity {

    private ListView lst;
    private Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_details);

        btn = findViewById(R.id.buttonBack);
        lst = findViewById(R.id.listViewOD);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(OrderDetailsActivity.this, HomeActivity.class));
            }
        });

        SharedPreferences sharedpreferences = getSharedPreferences("shared_prefs", Context.MODE_PRIVATE);
        String username = sharedpreferences.getString("username", "");
        ArrayList<String> dbData = Database.getInstance(getApplicationContext(),null).getOrderData(username);

        // Create adapter and set it to ListView
        OrderAdapter adapter = new OrderAdapter(this, dbData);
        lst.setAdapter(adapter);
    }
}