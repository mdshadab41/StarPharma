package com.example.starpharma.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.starpharma.R;

public class SignUp extends AppCompatActivity {

    EditText ed_firstname,ed_lastname,ed_email,ed_mobilenumber,ed_password;
    TextView ed_signin;
    Button ed_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        ed_firstname = findViewById(R.id.ed_firstname);
        ed_lastname = findViewById(R.id.ed_lastname);
        ed_email = findViewById(R.id.ed_email);
        ed_mobilenumber = findViewById(R.id.ed_mobilenumber);
        ed_password = findViewById(R.id.ed_password);
        ed_signin = findViewById(R.id.tv_signin);

        ed_btn = findViewById(R.id.ed_btn);

        ed_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SignUp.this, LoginActivity.class);
            }
        });

        ed_signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SignUp.this, LoginActivity.class);
            }
        });







    }
}