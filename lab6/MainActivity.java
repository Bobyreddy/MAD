package com.example.parsingxmlandjson;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button btnxml, btnjson;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnxml = findViewById(R.id.btnxml);
        btnjson = findViewById(R.id.btnjson);
        btnjson.setOnClickListener(this);
        btnxml.setOnClickListener(this);
    }

    @Override
    public void onClick(View v){
        if(v.equals(btnjson)){
            Intent it = new Intent(this, ViewActivity.class);
            it.putExtra("mode", 1);
            startActivity(it);
        } else if(v.equals(btnxml)){
            Intent it = new Intent(this, ViewActivity.class);
            it.putExtra("mode", 2);
            startActivity(it);
        }
    }
}