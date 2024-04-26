package com.example.healthease;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;

public class BuyMedicineActivity extends AppCompatActivity {
    private String[][] packages={
        {"Napa Paracetamol","","","","50"},
        {"HealthVit Chromium Picolinate 200mcg Capsule","","","","305"},
        {"Vitamin B Complex Capsules","","","","448"},
        {"Inlife Vitamin E Wheat Germ Oil Capsule","","","","539"},
        {"Dolo 650 Capsule","","","","30"},
        {"Crocin 650 Advanced Tablet","","","","50"},
        {"Streciles Medicated Lozens for Sore Throat","","","","40"},
        {"Calbo D Capsule","","","","30"},
        {"Feronia -XT Tablet","","","","130"},
    };

    private String[] package_details={
            "Napa Paracetamol is a common pain reliever and fever reducer. It's used to treat minor aches and pains, colds, and fevers.",
            "HealthVit Chromium Picolinate 200mcg Capsule is a supplement that provides a source of chromium, which is essential for proper cellular function and metabolism.",
            "Vitamin B Complex Capsules are a combination of B vitamins that are essential for energy production, brain function, and the formation of red blood cells.",
            "Inlife Vitamin E Wheat Germ Oil Capsule is a supplement that provides a source of Vitamin E, which is important for skin health, immune function, and antioxidant activity.",
            "Dolo 650 Capsule is a common pain reliever and fever reducer. It's used to treat minor aches and pains, colds, and fevers.",
            "Crocin 650 Advanced Tablet is a common pain reliever and fever reducer. It's used to treat minor aches and pains, colds, and fevers.",
            "Streciles Medicated Lozens for Sore Throat are designed to provide relief from sore throats caused by various conditions, including colds and flu.",
            "Calbo D Capsule is a common pain reliever and fever reducer. It's used to treat minor aches and pains, colds, and fevers.",
            "Feronia -XT Tablet is a common pain reliever and fever reducer. It's used to treat minor aches and pains, colds, and fevers."
    };

    HashMap<String,String> item;
    ArrayList list;
    SimpleAdapter sa;
    ListView lst;
    Button btnBack,btnGoToCart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buy_medicine);

        Button btnBack=findViewById(R.id.buttonBMBack);
        Button btnGoToCart=findViewById(R.id.buttonBMGoToCart);
        lst=findViewById(R.id.listViewBM);

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(BuyMedicineActivity.this, HomeActivity.class));
            }
        });

        btnGoToCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(BuyMedicineActivity.this, CartBuyMedicineActivity.class));
            }
        });


        list = new ArrayList();
        for (int i=0;i<packages.length;i++){
            item=new HashMap<String, String>();
            item.put( "line1", packages[i][0]);
            item.put( "line2", packages[i][1]);
            item.put( "line3", packages[i][2]);
            item.put( "line4", packages[i][3]);
            item.put( "line5", packages[i][4]);
            list.add(item);
        }

        sa=new SimpleAdapter(this,list,R.layout.multi_lines, new String[]{"line1","line2","line3","line4","line5"},new int[] {R.id.line_a,R.id.line_b,R.id.line_c,R.id.line_d,R.id.line_e});
        lst.setAdapter(sa);


        lst.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent it = new Intent(BuyMedicineActivity.this, BuyMedicineDetailsActivity.class);
                it.putExtra("text1", packages[i][0]);
                it.putExtra("text2", package_details[i]);
                it.putExtra("text3", packages[i][4]);
                startActivity(it);
                ;
            }
        });
    }
}