package com.example.healthease;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import com.example.healthease.LabTest.LabTest;

import com.example.healthease.LabTest.TestAdapter;
import com.example.healthease.LabTest.TestOccurrence;

import java.util.ArrayList;
import java.util.HashMap;
/**
 * The {@code LabTestActivity} class displays a list of available lab tests along with their details and prices.
 * It provides functionality to view the details of each lab test and add them to the cart.
 * Author: Md. Sakibur Rahman
 */
public class LabTestActivity extends AppCompatActivity {


    private String[][] packages = {
            {"Full Body Checkup", "", "", "3500"},
            {"Blood Glucose Fasting", "", "", "400"},
            {"COVID-19 Antibody - IgG", "", "", "1500"},
            {"Thyroid Function Test", "", "", "800"},
            {"Liver Function Test", "", "", "1200"},
            {"Kidney Function Test", "", "", "1000"},
            {"Lipid Profile", "", "", "700"},
            {"Complete Blood Count (CBC)", "", "", "500"},
            {"Vitamin D Test", "", "", "1300"},
            {"Dengue NS1 Antigen", "", "", "900"}
    };

    private String[] package_details = {
            "Comprehensive health checkup including blood tests, urine tests, and imaging tests.",
            "Measures blood glucose levels after fasting to check for diabetes.",
            "Tests for antibodies indicating past infection with COVID-19.",
            "Checks levels of thyroid hormones to diagnose thyroid disorders.",
            "Assesses liver health by measuring levels of liver enzymes and proteins.",
            "Evaluates kidney function through blood tests and urine analysis.",
            "Measures cholesterol and triglyceride levels to assess heart health.",
            "Counts the different types of cells in the blood to diagnose various conditions.",
            "Measures the level of Vitamin D to check for deficiency.",
            "Detects the presence of dengue virus through antigen detection."
    };



    HashMap<String, String> item;
    ArrayList list;
    SimpleAdapter sa;
    AppCompatButton btnGoToCart, btnBack;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab_test);

        btnGoToCart=findViewById(R.id.buttonLTGoToCart);
        btnBack=findViewById(R.id.buttonLTBack);
        listView= findViewById(R.id.listViewLT);

     //   LabTestPackageFactory factory = LabTestPackageFactory.getInstance();
        ArrayList<TestOccurrence>  testOccurrences = TestAdapter.convert(packages, package_details);


        list = new ArrayList();
//        for (int i = 0; i < 5; i++) {
//            LabTestPackage pkg = factory.createPackage(i + 1);
//            item = new HashMap<String, String>();
//            item.put("line1", pkg.getName());
//            item.put("line2", "");
//            item.put("line3", "");
//            item.put("line4", String.valueOf(pkg.getCost()));
//            item.put("line5", "Total Cost : " + pkg.getCost() + "/-");
//            list.add(item);
//        }

        for (TestOccurrence testOccurrence : testOccurrences) {
            LabTest labTest = testOccurrence.getLabTest();
            item = new HashMap<>();
            item.put("line1", labTest.getName());
            item.put("line2", labTest.getDetails());
            item.put("line3", "Type : " + labTest.getType()  );
            item.put("line4","Branch :" + testOccurrence.getBranch() );
            item.put("line5", "Total Cost : " + labTest.getPrice() + "/-");
            list.add(item);
        }

        sa = new SimpleAdapter(this, list, R.layout.multi_lines, new String[] {"line1", "line2", "line3", "line4", "line5"},
                new int[] {R.id.line_a, R.id.line_b, R.id.line_c, R.id.line_d, R.id.line_e});
        listView.setAdapter(sa);

//        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int i, long id) {
//                LabTestPackage pkg = factory.createPackage(i + 1);
//                Intent it = new Intent(LabTestActivity.this, LabTestDetailsActivity.class);
//                it.putExtra("text1", pkg.getName());
//                it.putExtra("text2", pkg.getDetails());
//                it.putExtra("text3", String.valueOf(pkg.getCost()));
//                startActivity(it);
//            }
//        });

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int i, long id) {
                LabTest labTest = testOccurrences.get(i).getLabTest();
                Intent it = new Intent(LabTestActivity.this, LabTestDetailsActivity.class);
                it.putExtra("text1", labTest.getName()+ "(" + labTest.getType() +")" );
                it.putExtra("text2", labTest.getDetails());
                it.putExtra("text3", labTest.getPrice());
                startActivity(it);
            }
        });

        btnGoToCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LabTestActivity.this, CartLabActivity.class));
            }
        });

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LabTestActivity.this, HomeActivity.class));
            }
        });

    }
}