package com.example.toss;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button toss = this.findViewById(R.id.tossButton);
        Button resetResult = this.findViewById(R.id.resetResult);
        TextView result = this.findViewById(R.id.result);
        ImageView resultImage = this.findViewById(R.id.resultImage);

        Handler h = new Handler();

        Runnable showTail = () -> {
            result.setText("Tail");
            resultImage.setImageResource(R.drawable.tail);
        };
        Runnable showHead = () -> {
            resultImage.setImageResource(R.drawable.head);
            result.setText("Head");
        };

        Runnable showResult = () -> {
            Random randomNumber = new Random();
            int random = randomNumber.nextInt(2);
            result.setTextColor(Color.parseColor("#00ff00"));
            if (random % 2 == 1) {
                result.setText("Head Won the Toss");
                resultImage.setImageResource(R.drawable.head);
            }
            else {
                result.setText("Tail Won the Toss");
                resultImage.setImageResource(R.drawable.tail);
            }
        };

        Runnable mainShow = () -> {
            h.postDelayed(showTail,0);
            h.postDelayed(showHead,200);
            h.postDelayed(showTail,400);
            h.postDelayed(showHead,600);
            h.postDelayed(showTail,800);
            h.postDelayed(showHead,1000);
            h.postDelayed(showTail,1200);
            h.postDelayed(showHead,1400);
            h.postDelayed(showTail,1600);
            h.postDelayed(showHead,1800);
            h.postDelayed(showTail,2000);
            h.postDelayed(showHead,2200);
            h.postDelayed(showResult, 2500);
        };

        toss.setOnClickListener(v -> {
            result.setTextColor(Color.parseColor("#ffffff"));
            h.postDelayed(mainShow, 1000);
        });

        resetResult.setOnClickListener(v ->
            {
                result.setText("Result will be displayed here");
                resultImage.setImageResource(R.drawable.tossing);
                result.setTextColor(Color.parseColor("#ffffff"));
            });

    }
}