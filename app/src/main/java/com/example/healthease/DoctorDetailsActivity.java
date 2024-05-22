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
import android.widget.Toast;

import com.example.healthease.Doctor.Cardiologist;
import com.example.healthease.Doctor.CardiologistOccurence;
import com.example.healthease.Doctor.DentistOccurrence;
import com.example.healthease.Doctor.Dentists;
import com.example.healthease.Doctor.DieticianOccurrence;
import com.example.healthease.Doctor.Dietisians;
import com.example.healthease.Doctor.DoctorDetails;
import com.example.healthease.Doctor.DoctorDetailsAdapter;
import com.example.healthease.Doctor.DoctorListViewFactory;
import com.example.healthease.Doctor.FamilyPhysicianOccurrence;
import com.example.healthease.Doctor.FamilyPhysicians;
import com.example.healthease.Doctor.SurgeonOccurrence;
import com.example.healthease.Doctor.Surgeons;
import com.example.healthease.Doctor.TotalAppointmentFactory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/**
 * The {@code DoctorDetailsActivity} class displays details of doctors based on their specialization.
 * It retrieves doctor details from various instances of doctor classes and adapts them for display.
 *   Author: Md. Sakibur Rahman
 */
public class DoctorDetailsActivity extends AppCompatActivity {


    // Doctor details stored in a 2D array

    private String[][] doctor_details1 = {
            // Cardiologist
            {"Specialist : Cardiologist", "Doctor Name : Aisha Khan", "Hospital Address : Dhanmondi", "Exp : 5yrs", "Mobile No: 01711234567", "1600"},
            {"Specialist : Cardiologist", "Doctor Name : Mohammad Ali", "Hospital Address : Gulshan", "Exp : 15yrs", "Mobile No: 01711234568", "1900"},
            {"Specialist : Cardiologist", "Doctor Name : Fatima Ahmed", "Hospital Address : Banani", "Exp : 8yrs", "Mobile No: 01711234569", "1300"},
            {"Specialist : Cardiologist", "Doctor Name : Yusuf Abdullah", "Hospital Address : Uttara", "Exp : 6yrs", "Mobile No: 01711234570", "1500"},
            {"Specialist : Cardiologist", "Doctor Name : Zara Hussain", "Hospital Address : Mirpur", "Exp : 7yrs", "Mobile No: 01711234571", "1800"},
            {"Specialist : Cardiologist", "Doctor Name : Rahima Begum", "Hospital Address : Bashundhara", "Exp : 10yrs", "Mobile No: 01711234572", "1700"},

            // Surgeon
            {"Specialist : Surgeon", "Doctor Name : Imran Hasan", "Hospital Address : Dhanmondi", "Exp : 12yrs", "Mobile No: 01711234573", "2000"},
            {"Specialist : Surgeon", "Doctor Name : Saira Anjum", "Hospital Address : Gulshan", "Exp : 14yrs", "Mobile No: 01711234574", "2200"},
            {"Specialist : Surgeon", "Doctor Name : Rashid Mahmud", "Hospital Address : Banani", "Exp : 10yrs", "Mobile No: 01711234575", "2100"},
            {"Specialist : Surgeon", "Doctor Name : Nusrat Jahan", "Hospital Address : Uttara", "Exp : 9yrs", "Mobile No: 01711234576", "2300"},
            {"Specialist : Surgeon", "Doctor Name : Fahim Rahman", "Hospital Address : Mirpur", "Exp : 11yrs", "Mobile No: 01711234577", "2400"},
            {"Specialist : Surgeon", "Doctor Name : Maisha Karim", "Hospital Address : Bashundhara", "Exp : 13yrs", "Mobile No: 01711234578", "2500"},

            // Dentist
            {"Specialist : Dentist", "Doctor Name : Afsana Islam", "Hospital Address : Dhanmondi", "Exp : 4yrs", "Mobile No: 01711234579", "900"},
            {"Specialist : Dentist", "Doctor Name : Jamal Uddin", "Hospital Address : Gulshan", "Exp : 6yrs", "Mobile No: 01711234580", "1000"},
            {"Specialist : Dentist", "Doctor Name : Anika Chowdhury", "Hospital Address : Banani", "Exp : 5yrs", "Mobile No: 01711234581", "1100"},
            {"Specialist : Dentist", "Doctor Name : Karim Mahmud", "Hospital Address : Uttara", "Exp : 8yrs", "Mobile No: 01711234582", "1200"},
            {"Specialist : Dentist", "Doctor Name : Shahina Begum", "Hospital Address : Mirpur", "Exp : 7yrs", "Mobile No: 01711234583", "1300"},
            {"Specialist : Dentist", "Doctor Name : Farhan Ahmed", "Hospital Address : Bashundhara", "Exp : 6yrs", "Mobile No: 01711234584", "1400"},

            // Dietician
            {"Specialist : Dietician", "Doctor Name : Leena Rahman", "Hospital Address : Dhanmondi", "Exp : 3yrs", "Mobile No: 01711234585", "800"},
            {"Specialist : Dietician", "Doctor Name : Tanvir Ahmed", "Hospital Address : Gulshan", "Exp : 5yrs", "Mobile No: 01711234586", "900"},
            {"Specialist : Dietician", "Doctor Name : Shirin Akter", "Hospital Address : Banani", "Exp : 4yrs", "Mobile No: 01711234587", "850"},
            {"Specialist : Dietician", "Doctor Name : Rezaul Karim", "Hospital Address : Uttara", "Exp : 6yrs", "Mobile No: 01711234588", "950"},
            {"Specialist : Dietician", "Doctor Name : Tania Islam", "Hospital Address : Mirpur", "Exp : 7yrs", "Mobile No: 01711234589", "1000"},
            {"Specialist : Dietician", "Doctor Name : Salman Hasan", "Hospital Address : Bashundhara", "Exp : 8yrs", "Mobile No: 01711234590", "1100"},

            // Family Physicians
            {"Specialist : Family Physician", "Doctor Name : Parveen Sultana", "Hospital Address : Dhanmondi", "Exp : 9yrs", "Mobile No: 01711234591", "1500"},
            {"Specialist : Family Physician", "Doctor Name : Tanvir Khan", "Hospital Address : Gulshan", "Exp : 10yrs", "Mobile No: 01711234592", "1600"},
            {"Specialist : Family Physician", "Doctor Name : Shafiqul Islam", "Hospital Address : Banani", "Exp : 8yrs", "Mobile No: 01711234593", "1400"},
            {"Specialist : Family Physician", "Doctor Name : Khaleda Zia", "Hospital Address : Uttara", "Exp : 12yrs", "Mobile No: 01711234594", "1700"},
            {"Specialist : Family Physician", "Doctor Name : Harun-ur-Rashid", "Hospital Address : Mirpur", "Exp : 11yrs", "Mobile No: 01711234595", "1800"},
            {"Specialist : Family Physician", "Doctor Name : Anwar Hossain", "Hospital Address : Bashundhara", "Exp : 13yrs", "Mobile No: 01711234596", "1900"}
    };


    TextView tv;
    AppCompatButton btn;
    String[][] doctor_details = {} ;
   private List<HashMap<String,String>> list;
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

        Cardiologist cardiologist = Cardiologist.getInstance();
        FamilyPhysicians familyPhysicians = FamilyPhysicians.getInstance();
        Surgeons surgeons = Surgeons.getInstance();
        Dentists dentists = Dentists.getInstance();
        Dietisians dietisians = Dietisians.getInstance();




        DoctorDetailsAdapter.adapt(doctor_details1);



        list = new ArrayList<>();
       list.clear();

        Database db = Database.getInstance(getApplicationContext(), null);


        if(title.equalsIgnoreCase("cardiologist"))
        {
            ArrayList<CardiologistOccurence> cardiologistOccurences = cardiologist.getCardiologistOccurrences();

          //  list.removeAll(cardiologistOccurences);

            int a = Integer.parseInt(db.getTotal(title));
            TotalAppointmentFactory.updateAppointmentNumber(title, a);
            list.clear();
            for(CardiologistOccurence doctor : cardiologistOccurences) {


                item = new HashMap<String,String>();
                item.put("line1", doctor.getDoctorName());
                item.put("line2", doctor.getHospitalAddress());
                item.put("line3", doctor.getExperience()  );
                item.put("line4", doctor.getMobileNo() + "     \nTotal Appointment :  " +  doctor.getTotalAppointmentInThisCategory());
                item.put("line5", doctor.getConsultationFee()+"");
                list.add(item);
            }

        }
        else if(title.equalsIgnoreCase("family physician"))
        {
            ArrayList<FamilyPhysicianOccurrence> familyPhysicianOccurrences = familyPhysicians.getFamilyPhysicianOccurrences();
          //  list = new ArrayList<>();

            int a = Integer.parseInt(db.getTotal(title));
            TotalAppointmentFactory.updateAppointmentNumber(title, a);

            familyPhysicians.setTotalAppointment(a);

            for(FamilyPhysicianOccurrence doctor : familyPhysicianOccurrences) {


                item = new HashMap<String,String>();
                item.put("line1", doctor.getDoctorName());
                item.put("line2", doctor.getHospitalAddress());
                item.put("line3", doctor.getExperience()  );
                item.put("line4", doctor.getMobileNo() + "     \nTotal Appointment :  " +  doctor.getTotalAppointmentInThisCategory());
                item.put("line5", doctor.getConsultationFee()+"");
                list.add(item);
            }

        }
        else if(title.equalsIgnoreCase("dietician"))
        {

            int a = Integer.parseInt(db.getTotal(title));
            TotalAppointmentFactory.updateAppointmentNumber(title, a);

            dietisians.setTotalAppointment(a);
            ArrayList<DieticianOccurrence> dieticianOccurrences = dietisians.getDieticianOccurrences();
           // list = new ArrayList<>();
            for(DieticianOccurrence doctor : dieticianOccurrences) {


                item = new HashMap<String,String>();
                item.put("line1", doctor.getDoctorName());
                item.put("line2", doctor.getHospitalAddress());
                item.put("line3", doctor.getExperience()  );
                item.put("line4", doctor.getMobileNo() + "     \nTotal Appointment :  " +  doctor.getTotalAppointmentInThisCategory());
                item.put("line5", doctor.getConsultationFee()+"");
                list.add(item);
            }

        }
        else if(title.equalsIgnoreCase("dentist"))
        {

            int a = Integer.parseInt(db.getTotal(title));
            TotalAppointmentFactory.updateAppointmentNumber(title, a);

            dentists.setTotalAppointment(a);
            ArrayList<DentistOccurrence> dentistOccurrences = dentists.getDentistOccurrences();
          //  list = new ArrayList<>();
            for(DentistOccurrence doctor : dentistOccurrences) {


                item = new HashMap<String,String>();
                item.put("line1", doctor.getDoctorName());
                item.put("line2", doctor.getHospitalAddress());
                item.put("line3", doctor.getExperience()  );
                item.put("line4", doctor.getMobileNo() + "     \nTotal Appointment :  " +  doctor.getTotalAppointmentInThisCategory());
                item.put("line5", doctor.getConsultationFee()+"");
                list.add(item);
            }

        }
        else if(title.equalsIgnoreCase("surgeon"))
        {

            int a = Integer.parseInt(db.getTotal(title));
            TotalAppointmentFactory.updateAppointmentNumber(title, a);

            surgeons.setTotalAppointment(a);
            ArrayList<SurgeonOccurrence> surgeonOccurrences = surgeons.getSurgeonOccurrences();
           // list = new ArrayList<>();
            for(SurgeonOccurrence doctor : surgeonOccurrences) {


                item = new HashMap<String,String>();
                item.put("line1", doctor.getDoctorName());
                item.put("line2", doctor.getHospitalAddress());
                item.put("line3", doctor.getExperience()  );
                item.put("line4", doctor.getMobileNo() + "     \nTotal Appointment :  " +  doctor.getTotalAppointmentInThisCategory());
                item.put("line5", doctor.getConsultationFee()+"");
                list.add(item);
            }

        }








        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
               // startActivity(new Intent(DoctorDetailsActivity.this, FindDoctorActivity.class));
            }
        });




        sa = new SimpleAdapter(  this, list, R.layout.multi_lines,
                new String[]{"line1", "line2", "line3", "line4", "line5"},
                new int[]{R.id.line_a, R.id.line_b, R.id.line_c, R.id.line_d, R.id.line_e});

        ListView lst = findViewById(R.id.listViewDD);
        //lst.removeAllViews();
        lst.setAdapter(sa);

        lst.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                HashMap<String,String> map = list.get(i);


                Intent it = new Intent(  DoctorDetailsActivity.this, BookAppointmentActivity.class);
                it.putExtra(  "text1", title);
                it.putExtra(  "text2", map.get("line1"));
                it.putExtra(  "text3", map.get("line2"));
                it.putExtra(  "text4", map.get("line4"));
                it.putExtra(  "text5", map.get("line5"));
                startActivity(it);
            }
        });



    }
}