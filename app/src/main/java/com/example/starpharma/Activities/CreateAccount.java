package com.example.starpharma.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.starpharma.R;

public class CreateAccount extends AppCompatActivity {

    Button btn_createaccount,btn_signin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_account);

        btn_createaccount = findViewById(R.id.btn_createaccount);
        btn_signin = findViewById(R.id.btn_signin);

        btn_createaccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CreateAccount.this,SignUp.class);
                startActivity(intent);
                finish();
            }
        });
        btn_signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CreateAccount.this,SignUp.class);
                startActivity(intent);
                finish();
            }
        });

    }
}