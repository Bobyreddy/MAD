package com.example.signup_activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity2 extends AppCompatActivity {
    EditText etu2, etp2;
    Button btnLogin;
    int counter = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login2);
        etu2 = findViewById(R.id.et_usr2);
        etp2 = findViewById(R.id.et_psw2);
        btnLogin = findViewById(R.id.btn_lgin2);
        String regUsr, regPswd;
        regUsr = getIntent().getStringExtra("username");
        regPswd = getIntent().getStringExtra("password");
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String uName = etu2.getText().toString();
                String pwd = etp2.getText().toString();
                if(uName.equals(regUsr) && pwd.equals(regPswd)){
                    Toast.makeText(LoginActivity2.this, "Login Successful", Toast.LENGTH_LONG).show();
                    Intent intSuccess = new Intent(LoginActivity2.this, SuccessActivity3.class);
                    startActivity(intSuccess);
                } else {
                    Toast.makeText(LoginActivity2.this, "Login Credentials Not Matching", Toast.LENGTH_LONG).show();
                    counter--;
                    if(counter==0){
                        Toast.makeText(LoginActivity2.this, "Reached Maximum Login Attempts", Toast.LENGTH_LONG).show();
                        btnLogin.setEnabled(false);
                    }
                }
            }
        });
    }
}