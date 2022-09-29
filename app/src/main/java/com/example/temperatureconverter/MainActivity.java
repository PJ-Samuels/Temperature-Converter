package com.example.temperatureconverter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.SeekBar;
import android.widget.TextClock;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    SeekBar seekbar;
    TextView textview;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SeekBar sb1  = (SeekBar) findViewById(R.id.sb1);
        SeekBar sb2  = (SeekBar) findViewById(R.id.sb2);
        TextView cel = (TextView) findViewById(R.id.cel);
        TextView fahr = (TextView) findViewById(R.id.fahr);
        TextView message = (TextView) findViewById(R.id.message);

        sb1.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b)
            {
                if(i < 32){
                    i = 32;
                    sb1.setProgress(32);
                }

                fahr.setText("Fahrenheit: "+ String.valueOf(i));


                if(i < 70){
                    message.setText("I wish it were warmer");
                }
                else if(i > 90) {
                    message.setText("Wow its extremely Hot");
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                int c = sb1.getProgress();
                int conversion = (c-32)*5/9;
                sb2.setProgress(conversion);
            }
        });
        sb2.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                cel.setText("Celsius: "+ String.valueOf(i));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                int c = sb2.getProgress();
                int conversion = (c*9/5)+32;
                sb1.setProgress(conversion);
            }
        });
    }

}