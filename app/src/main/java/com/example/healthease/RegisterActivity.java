package com.example.healthease;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {
    EditText edUsername,edEmail, edPassword, edConfirm;
    Button btn;
    TextView tv;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        edUsername=findViewById(R.id.editTextRegUsername);
        edPassword=findViewById(R.id.editTextRegPassword);
        edEmail=findViewById(R.id.editTextRegEmail);
        edConfirm=findViewById(R.id.editTextRegConfirmPassword);
        btn=findViewById(R.id.buttonRegister);
        tv=findViewById(R.id.textViewExistingUser);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = edUsername.getText().toString();
                String password = edPassword.getText().toString();
                String email = edEmail.getText().toString();
                String confirm = edConfirm.getText().toString();
                Database db = Database.getInstance(getApplicationContext(),null);
                if (username.length() == 0 || password.length() == 0 || email.length() == 0 || confirm.length() == 0) {
                    Toast.makeText(getApplicationContext(), "Please fill all details", Toast.LENGTH_SHORT).show();
                } else {
                    if (password.compareTo(confirm)==0){
                        if(isValid(password)){
                            db.register(username, email, password);
                            Toast.makeText(getApplicationContext(), "New User Registered", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(RegisterActivity.this, LoginActivity.class));
                        }
                        else{
                            Toast.makeText(getApplicationContext(), "8 characters", Toast.LENGTH_SHORT).show();
                        }

                    }
                    else{
                        Toast.makeText(getApplicationContext(), "Passwords mismatch", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(RegisterActivity.this, LoginActivity.class));
            }
        });
    }

    public static boolean isValid(String passwordhere){
        int f1=0, f2=0, f3=0;
        if(passwordhere.length()<8){
            return false;
        }
        else{
            for(int i=0;i<passwordhere.length();i++){
                if(Character.isLetter(passwordhere.charAt(i))){
                    f1=1;
                }
            }
            for(int i=0;i<passwordhere.length();i++){
                if(Character.isDigit(passwordhere.charAt(i))){
                    f2=1;
                }
            }
            for(int i=0;i<passwordhere.length();i++){
                char c=passwordhere.charAt(i);
                if(c>=33 && c<=46 ||c==64){
                    f3=1;
                }
            }
            if(f1==1 && f2==1 && f3==1){
                return true;
            }
            return false;
        }
    }


}