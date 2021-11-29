package com.example.lesson2611;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class InfoActivity extends AppCompatActivity {

    private TextView viewprocent;
    private TextView viewperyear;
    private TextView viewallmoney;
    private TextView viewyear;
    private Button btn3;
    private int allmoney;
    private int[] data;
    private static final double prosent = 0.03;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

        viewprocent = findViewById(R.id.textViewProsent);
        viewperyear = findViewById(R.id.textViewYear);
        viewallmoney = findViewById(R.id.textViewYearM);
        viewyear = findViewById(R.id.textViewMoney);

        btn3 = findViewById(R.id.button3);

        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            data = bundle.getIntArray("arr");
        }

        for (int i = 0; i < data[1]; i++) {
            allmoney += data[0] * prosent + data[2];
        }

        viewprocent.setText(Double.toString(prosent*100));
        viewperyear.setText(Double.toString(data[0] * prosent));
        viewallmoney.setText(Double.toString(allmoney));
        viewyear.setText(Integer.toString(data[1]));

// string builder
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish(); // завершаем работу активности
            }
        });
    }
}