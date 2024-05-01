package com.example.healthease.Doctor;

public class Dieticians implements DoctorDetails{
    @Override
    public String[][] getDoctorDetails() {
        return new String[][]
                {
                        {"Doctor Name : Ahmed Khan", "Hospital Address : Aundh", "Exp : 10yrs", "Mobile No: 8898989898", "1700"},
                        {"Doctor Name : Amira Malik", "Hospital Address : Hinjewadi", "Exp : 12yrs", "Mobile No: 7799889898", "2000"},
                        {"Doctor Name : Yusuf Ali", "Hospital Address : Hadapsar", "Exp : 9yrs", "Mobile No: 9899779898", "1400"},
                        {"Doctor Name : Safiya Ahmed", "Hospital Address : Koregaon Park", "Exp : 11yrs", "Mobile No: 8899779898", "1750"},
                        {"Doctor Name : Ibrahim Khan", "Hospital Address : Kothrud", "Exp : 13yrs", "Mobile No: 7799779898", "1650"}
                };
    }
}
