package com.example.counter_app;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    TextView tvC;
    Button btnStrt, btnStp;
    int counter = 0;
    boolean running = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvC = findViewById(R.id.tvC);
        btnStrt = findViewById(R.id.btnStrt);
        btnStp = findViewById(R.id.btnStp);
        btnStrt.setOnClickListener(this);
        btnStp.setOnClickListener(this);
    }
    public  void onClick(View v){
        if (v.equals(btnStrt)){
            counter = 0;
            running = true;
            new Mycounter().start();
        } else if(v.equals(btnStp)){
            running = false;
        }
    }
    Handler handler = new Handler() {
        public void handleMessage(Message m){
            tvC.setText(String.valueOf(m.what));
        }
    };
    class  Mycounter extends Thread{
        public void run(){
            while (running){
                counter++;
                handler.sendEmptyMessage(counter);
                try {
                    Thread.sleep(1000);
                } catch (Exception e){}
            }
        }
    }
}