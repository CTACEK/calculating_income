package com.example.lesson2611;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, SeekBar.OnSeekBarChangeListener {
    private Button btn;
    private TextView TextView1;
    private TextView TextView2;
    private TextView TextView3;
    private int babosik;
    private int howlong;
    private int mounth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn = findViewById(R.id.button);
        btn.setOnClickListener(this);

        final SeekBar seekBar1 = (SeekBar) findViewById(R.id.seekBar1);
        seekBar1.setOnSeekBarChangeListener(this);

        TextView1 = (TextView) findViewById(R.id.textViewS1);
        TextView1.setText("0");

        final SeekBar seekBar2 = (SeekBar) findViewById(R.id.seekBar2);
        seekBar2.setOnSeekBarChangeListener(this);

        TextView2 = (TextView) findViewById(R.id.textViewS2);
        TextView2.setText("0");

        final SeekBar seekBar3 = (SeekBar) findViewById(R.id.seekBar3);
        seekBar3.setOnSeekBarChangeListener(this);

        TextView3 = (TextView) findViewById(R.id.textViewS3);
        TextView3.setText("0");


        seekBar1.setOnSeekBarChangeListener(seekBarChangeListener1);
        seekBar2.setOnSeekBarChangeListener(seekBarChangeListener2);
        seekBar3.setOnSeekBarChangeListener(seekBarChangeListener3);
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(this, InfoActivity.class);
        int[] array = {babosik, howlong, mounth};
//        intent.putExtra("c1", TextView1.getText().toString());
//        intent.putExtra("c2", TextView2.getText().toString());
//        intent.putExtra("c3", TextView3.getText().toString());
        intent.putExtra("arr", array);

        startActivity(intent);
    }

    private SeekBar.OnSeekBarChangeListener seekBarChangeListener1 = new SeekBar.OnSeekBarChangeListener() {
        @Override
        public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
            babosik = seekBar.getProgress() * 10000;
            TextView1.setText(String.valueOf(babosik));

        }

        @Override
        public void onStartTrackingTouch(SeekBar seekBar) {
        }

        @Override
        public void onStopTrackingTouch(SeekBar seekBar) {
        }
    };

    private SeekBar.OnSeekBarChangeListener seekBarChangeListener2 = new SeekBar.OnSeekBarChangeListener() {
        @Override
        public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
            howlong = seekBar.getProgress();
            TextView2.setText(String.valueOf(howlong));
        }

        @Override
        public void onStartTrackingTouch(SeekBar seekBar) {
        }

        @Override
        public void onStopTrackingTouch(SeekBar seekBar) {
        }
    };
    private SeekBar.OnSeekBarChangeListener seekBarChangeListener3 = new SeekBar.OnSeekBarChangeListener() {
        @Override
        public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
            mounth = seekBar.getProgress() * 1000;
            TextView3.setText(String.valueOf(mounth));
        }

        @Override
        public void onStartTrackingTouch(SeekBar seekBar) {
        }

        @Override
        public void onStopTrackingTouch(SeekBar seekBar) {
        }
    };

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {
    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {
    }


}