package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {


    public static final String TAG = "MyAppMessage";


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.i(TAG, "Informational Messages");
        Log.v(TAG, "Verbose Messages");
        Log.d(TAG, "Debug Messages");
        Log.w(TAG, "Warning Messages");
        Log.e(TAG, "Error Messages");

        final Button button = findViewById(R.id.about_button);
        final View someText1 = findViewById(R.id.textView2);

        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (someText1.getVisibility() == View.VISIBLE) {
                    someText1.setVisibility(View.INVISIBLE);
                } else {
                    someText1.setVisibility(View.VISIBLE);
                }
            }
        });

         final Button button1 = findViewById(R.id.game_button);

        button1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), GameActivity.class);
                startActivity(i);
            }
        });
    }


}

