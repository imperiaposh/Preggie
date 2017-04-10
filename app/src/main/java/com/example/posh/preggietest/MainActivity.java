package com.example.posh.preggietest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button prisijungti = (Button) findViewById(R.id.prijungti);
        prisijungti.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                // TODO Auto-generated method stub
                Intent myIntent = new Intent(MainActivity.this, MeniuActivity.class);
                startActivity(myIntent);
            }
        });

        Button registracija = (Button) findViewById(R.id.registracija);
        registracija.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                // TODO Auto-generated method stub
                Intent myIntent = new Intent(MainActivity.this, RegActivity.class);
                startActivity(myIntent);
            }
        });

    }
}
