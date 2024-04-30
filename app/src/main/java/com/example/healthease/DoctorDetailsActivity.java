package com.example.healthease;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import com.example.healthease.Doctor.DoctorDetails;
import com.example.healthease.Doctor.DoctorDetailsFactory;

import java.util.ArrayList;
import java.util.HashMap;

public class DoctorDetailsActivity extends AppCompatActivity {

    private String[][] doctor_details1 = {
            {"Doctor Name : Aisha Khan", "Hospital Address : Pimpri", "Exp : 5yrs", "Mobile No: 9898989898", "1600"},
            {"Doctor Name : Mohammad Ali", "Hospital Address : Nigdi", "Exp : 15yrs", "Mobile No: 9898989898", "1900"},
            {"Doctor Name : Fatima Ahmed", "Hospital Address : Pune", "Exp : 8yrs", "Mobile No: 8899889898", "1300"},
            {"Doctor Name : Yusuf Abdullah", "Hospital Address : Chinchwad", "Exp : 6yrs", "Mobile No: 9898989898", "1500"},
            {"Doctor Name : Zara Hussain", "Hospital Address : Katraj", "Exp : 7yrs", "Mobile No: 7798989898", "1800"}
    };

    private String[][] doctor_details2 = {
            {"Doctor Name : Ahmed Khan", "Hospital Address : Aundh", "Exp : 10yrs", "Mobile No: 8898989898", "1700"},
            {"Doctor Name : Amira Malik", "Hospital Address : Hinjewadi", "Exp : 12yrs", "Mobile No: 7799889898", "2000"},
            {"Doctor Name : Yusuf Ali", "Hospital Address : Hadapsar", "Exp : 9yrs", "Mobile No: 9899779898", "1400"},
            {"Doctor Name : Safiya Ahmed", "Hospital Address : Koregaon Park", "Exp : 11yrs", "Mobile No: 8899779898", "1750"},
            {"Doctor Name : Ibrahim Khan", "Hospital Address : Kothrud", "Exp : 13yrs", "Mobile No: 7799779898", "1650"}
    };

    private String[][] doctor_details3 = {
            {"Doctor Name : Layla Abbas", "Hospital Address : Wakad", "Exp : 8yrs", "Mobile No: 7799669898", "1850"},
            {"Doctor Name : Omar Farooq", "Hospital Address : Kondhwa", "Exp : 11yrs", "Mobile No: 9899669898", "1700"},
            {"Doctor Name : Amina Khan", "Hospital Address : Magarpatta", "Exp : 9yrs", "Mobile No: 8899669898", "1950"},
            {"Doctor Name : Yusuf Khan", "Hospital Address : Warje", "Exp : 10yrs", "Mobile No: 7799669898", "1600"}
    };

    private String[][] doctor_details4 = {
            {"Doctor Name : Mariam Akhtar", "Hospital Address : Baner", "Exp : 7yrs", "Mobile No: 9899559898", "1750"},
            {"Doctor Name : Hassan Ali", "Hospital Address : Shivajinagar", "Exp : 13yrs", "Mobile No: 7799559898", "1800"},
            {"Doctor Name : Fatima Begum", "Hospital Address : Yerwada", "Exp : 6yrs", "Mobile No: 8899559898", "1650"},
            {"Doctor Name : Khalid Ahmed", "Hospital Address : Dhanori", "Exp : 12yrs", "Mobile No: 9899449898", "1900"}
    };

    private String[][] doctor_details5 = {
            {"Doctor Name : Ayesha Siddiqui", "Hospital Address : Kharadi", "Exp : 8yrs", "Mobile No: 7799449898", "1700"},
            {"Doctor Name : Abdul Rahman", "Hospital Address : Senapati Bapat Road", "Exp : 10yrs", "Mobile No: 9899449898", "1850"},
            {"Doctor Name : Safiya Khan", "Hospital Address : Dhayari", "Exp : 9yrs", "Mobile No: 8899449898", "1600"},
            {"Doctor Name : Amir Khan", "Hospital Address : Vishrantwadi", "Exp : 11yrs", "Mobile No: 7799339898", "1950"}
    };

    private String[][] doctor_details6 = {
            {"Doctor Name : Zahra Hashmi", "Hospital Address : Kalyani Nagar", "Exp : 7yrs", "Mobile No: 9899339898", "1800"},
            {"Doctor Name : Ali Khan", "Hospital Address : Bhosari", "Exp : 12yrs", "Mobile No: 7799229898", "1900"},
            {"Doctor Name : Zainab Khan", "Hospital Address : Lohegaon", "Exp : 8yrs", "Mobile No: 8899339898", "1700"},
            {"Doctor Name : Hamza Sheikh", "Hospital Address : Pimple Saudagar", "Exp : 11yrs", "Mobile No: 9899229898", "1850"}
    };



    TextView tv;
    AppCompatButton btn;
    String[][] doctor_details = {} ;
    ArrayList list;
    SimpleAdapter sa;

    HashMap<String,String> item;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_details);

        tv = findViewById(R.id.textViewDDTitle);
        btn = findViewById(R.id.buttonDDBack);

        Intent it = getIntent();
        String title = it.getStringExtra("title");
        tv.setText(title);

//        if (title.compareTo("Family Physicians")==0)
//            doctor_details = doctor_details1;
//        else if (title.compareTo("Dietician")==0)
//            doctor_details = doctor_details2;
//        else if (title.compareTo("Dentist")==0)
//            doctor_details = doctor_details3;
//        else if (title.compareTo("Surgeon")==0)
//            doctor_details = doctor_details4;
//        else
//            doctor_details = doctor_details5;

        DoctorDetailsFactory factory = new DoctorDetailsFactory();
        DoctorDetails doctorDetails = factory.createDoctorDetails(title);
        String[][] doctor_details = doctorDetails.getDoctorDetails();


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(DoctorDetailsActivity.this, FindDoctorActivity.class));
            }
        });

        list = new ArrayList<>();
        for(int i=0;i<doctor_details.length;i++) {
            item = new HashMap<String,String>();
            item.put("line1", doctor_details[i][0]);
            item.put("line2", doctor_details[i][1]);
            item.put("line3", doctor_details[i][2]);
            item.put("line4", doctor_details[i][3]);
            item.put("line5", "Cons Fees: "+doctor_details[i][4]+"/-");
            list.add(item);
        }

        sa = new SimpleAdapter(  this, list, R.layout.multi_lines,
                new String[]{"line1", "line2", "line3", "line4", "line5"},
                new int[]{R.id.line_a, R.id.line_b, R.id.line_c, R.id.line_d, R.id.line_e});

        ListView lst = findViewById(R.id.listViewDD);
        lst.setAdapter(sa);

        lst.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent it = new Intent(  DoctorDetailsActivity.this, BookAppointmentActivity.class);
                it.putExtra(  "text1", title);
                it.putExtra(  "text2", doctor_details[i][0]);
                it.putExtra(  "text3", doctor_details[i][1]);
                it.putExtra(  "text4", doctor_details[i][3]);
                it.putExtra(  "text5", doctor_details[i][4]);
                startActivity(it);
            }
        });



    }
}