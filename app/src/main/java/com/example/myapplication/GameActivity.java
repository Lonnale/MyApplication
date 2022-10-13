package com.example.myapplication;

import static com.example.myapplication.R.layout;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class GameActivity extends AppCompatActivity {

    int randomNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layout.activity_game);


        final ImageButton imgbtn = findViewById(R.id.image_Button1);
        final ImageButton imgbtn2 = findViewById(R.id.image_Button2);
        final ImageButton imgbtn3 = findViewById(R.id.image_Button3);
        final ImageButton imgbtn4 = findViewById(R.id.image_Button4);


        Random random = new Random();
        int randomNumber = random.nextInt(3);



        imgbtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                if (randomNumber == 0) {
                    imgbtn.setVisibility(View.GONE);
                    imgbtn.setImageResource(R.drawable.diamond);
                    imgbtn.setVisibility(View.VISIBLE);
                }
                else{
                    imgbtn.setVisibility(View.INVISIBLE);
                }
            }
        });


        imgbtn2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                if (randomNumber == 1) {
                    imgbtn2.setVisibility(View.GONE);
                    imgbtn2.setImageResource(R.drawable.diamond);
                    imgbtn2.setVisibility(View.VISIBLE);
                }
                else{
                    imgbtn2.setVisibility(View.INVISIBLE);
                }
            }
        });

        imgbtn3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                if (randomNumber == 2) {
                    imgbtn3.setVisibility(View.GONE);
                    imgbtn3.setImageResource(R.drawable.diamond);
                    imgbtn3.setVisibility(View.VISIBLE);
                }
                else{
                    imgbtn3.setVisibility(View.INVISIBLE);
                }
            }
        });

        imgbtn4.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                if (randomNumber == 3) {
                    imgbtn4.setVisibility(View.GONE);
                    imgbtn4.setImageResource(R.drawable.diamond);
                    imgbtn4.setVisibility(View.VISIBLE);
                }
                else{
                    imgbtn4.setVisibility(View.INVISIBLE);
                }
            }
        });
    }
}












