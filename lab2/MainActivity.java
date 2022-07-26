package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText a, b;
    TextView r;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        a = findViewById(R.id.numberA);
        b = findViewById(R.id.numberB);
        r = findViewById(R.id.result);

    }

    public void addMethod(View view) {
        Float n1 = Float.parseFloat(a.getText().toString());
        Float n2 = Float.parseFloat(b.getText().toString());
        Float result = n1 + n2;
        r.setText(""+result);
    }

    public void subMethod(View view) {
        Float n1 = Float.parseFloat(a.getText().toString());
        Float n2 = Float.parseFloat(b.getText().toString());
        Float result = n1 - n2;
        r.setText(""+result);
    }

    public void mulMethod(View view) {
        Float n1 = Float.parseFloat(a.getText().toString());
        Float n2 = Float.parseFloat(b.getText().toString());
        Float result = n1 * n2;
        r.setText(""+result);
    }

    public void divMethod(View view) {
        Float n1 = Float.parseFloat(a.getText().toString());
        Float n2 = Float.parseFloat(b.getText().toString());
        Float result = n1 / n2;
        r.setText(""+result);
    }
}


