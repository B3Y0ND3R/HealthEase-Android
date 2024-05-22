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
import android.widget.ListView;
import android.widget.TextView;

import com.example.healthease.BuyMed.BuyMedicineAdapter;
import com.example.healthease.Database;
import com.example.healthease.R;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;

/**
 * CartBuyMedicineActivity handles the display of medicines added to the cart,
 * allows the user to select a delivery date, and proceed to checkout.
 */
public class CartBuyMedicineActivity extends AppCompatActivity {


    ArrayList<HashMap<String, String>> list;
    BuyMedicineAdapter sa;
    TextView tvTotal;
    private DatePickerDialog datePickerDialog;
    private TimePickerDialog timePickerDialog;
    ListView lst;
    AppCompatButton datebutton, btncheckout,btnback;
    private String[][] packages = {};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart_buy_medicine);

        datebutton=findViewById(R.id.buttonBMCartDatePicker);
        btncheckout=findViewById(R.id.buttonBMCartCheckout);
        btnback=findViewById(R.id.buttonBMCartBack);
        tvTotal=findViewById(R.id.textViewBMCartTotalCost);
        lst=findViewById(R.id.listViewBMCart);


        SharedPreferences sharedPreferences= getSharedPreferences("shared_prefs", Context.MODE_PRIVATE);
        String username = sharedPreferences.getString("username", "").toString();

        Database db = Database.getInstance(getApplicationContext(),null);

        float totalAmount=0;
        ArrayList dbData = db.getCartData(username, "medicine");
        //     Toast.makeText(getApplicationContext(),""+dbData, Toast.LENGTH_LONG).show();

        packages = new String[dbData.size()][];
        for(int i =0; i<packages.length; i++)
        {
            packages[i] = new String[5];
        }

        for(int i =0; i<dbData.size(); i++)
        {
            String arrData = dbData.get(i).toString();
            String[] strData = arrData.split(java.util.regex.Pattern.quote("Taka"));
            packages[i][0] = strData[0];
            packages[i][4] = "Cost : "+strData[1]+"/-";
            totalAmount=totalAmount+Float.parseFloat(strData[1]);
        }

        tvTotal.setText("Total Cost " + totalAmount);

        list = new ArrayList();
        for(int i=0;i<packages.length;i++){
            HashMap<String, String> item = new HashMap<>();
            item.put("line1", packages[i][0]);
            item.put("line2", packages[i][1]);
            item.put("line3", packages[i][2]);
            item.put("line4", packages[i][3]);
            item.put("line5", packages[i][4]);
            list.add(item);
        }

        //Adapter Design pattern
        sa = new BuyMedicineAdapter( this, list);
        lst.setAdapter(sa);


        btnback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(CartBuyMedicineActivity.this, BuyMedicineActivity.class));
            }
        });


        String totalamount = String.valueOf(totalAmount);

        btncheckout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(CartBuyMedicineActivity.this, BuyMedicineBookActivity.class);
                it.putExtra("price", totalamount);
                it.putExtra("date", datebutton.getText());
                startActivity(it);

            }
        });

        //datepicker
        initDatePicker();
        datebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                datePickerDialog.show();
            }
        });


    }
    /**
     * Initializes the date picker dialog to allow the user to select a delivery date.
     * Sets the minimum date to one day after the current date.
     */
    private void initDatePicker() {
        Calendar cal = Calendar.getInstance();
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH);
        int day = cal.get(Calendar.DAY_OF_MONTH);

        int style = AlertDialog.THEME_HOLO_DARK;
        datePickerDialog = new DatePickerDialog(CartBuyMedicineActivity.this, style, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                datebutton.setText(i2+"-"+(i1+1)+"-"+i);
            }
        }, year, month, day);
        datePickerDialog.getDatePicker().setMinDate(cal.getTimeInMillis() + 86400000);
    }
}