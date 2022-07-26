package com.example.signup_activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {
    EditText etu1, etp1;
    Button btnsignup1 ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etu1 = findViewById(R.id.et_user1);
        etp1 = findViewById(R.id.et_pswd1);
        btnsignup1 = findViewById(R.id.btn_signup);
        btnsignup1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = etu1.getText().toString();
                String password = etp1.getText().toString();
                if(validatePasswd(password)){
                    Toast.makeText(MainActivity.this, "SIGN UP SUCCESSFUL", Toast.LENGTH_LONG).show();
                    Intent intLogin = new Intent(MainActivity.this, LoginActivity2.class);
                    intLogin.putExtra("password", password);
                    intLogin.putExtra("username", username);
                    startActivity(intLogin);
                } else {
                    Toast.makeText(MainActivity.this, "SIGN UP NOT SUCCESSFUL", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private boolean validatePasswd(String password) {
        Pattern ptrn;
        Matcher mat;
        String pwdptrn= "^(?=.*[A-Z])(?=.*[a-z])(?=.*[0-9])(?=.*[!@#$%^&*]).{8,}$";
        ptrn = Pattern.compile(pwdptrn);
        mat = ptrn.matcher(password);
        return mat.matches();
    }
}