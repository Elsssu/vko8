package com.elssu.olio;

import static java.lang.Math.round;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class MainActivity extends AppCompatActivity {

    private EditText inputText;
    private TextView outputText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        inputText = findViewById(R.id.EuroInput);
        outputText = findViewById(R.id.ResultText);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

    }
    public void transformToUSD(View view) {
        String input = inputText.getText().toString();
        BigDecimal euro = new BigDecimal(inputText.getText().toString());;
        BigDecimal USDRate = new BigDecimal("1.05");
        BigDecimal USD = euro.multiply(USDRate);
        BigDecimal USDRounded = USD.setScale(2, RoundingMode.HALF_UP);
        String output = String.valueOf(USD);
        outputText.setText(output);


    }
    public void transformToGDP(View view) {
        String input = inputText.getText().toString();
        BigDecimal euro = new BigDecimal(inputText.getText().toString());;
        BigDecimal GDPRate = new BigDecimal("0.83");
        BigDecimal GDP = euro.multiply(GDPRate);
        BigDecimal GDPRounded = GDP.setScale(2, RoundingMode.HALF_UP);
        String output = String.valueOf(GDP);
        outputText.setText(output);
    }
}