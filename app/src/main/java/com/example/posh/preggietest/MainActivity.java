package com.example.posh.preggietest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {

    private EditText mUsernameView;
    private EditText mPasswordView;
    private String username;
    private String password;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mUsernameView = (EditText) findViewById(R.id.username);
        mPasswordView = (EditText) findViewById(R.id.password);

        mUsernameView.setError(null);
        mPasswordView.setError(null);

        Button prisijungti = (Button) findViewById(R.id.prijungti);
        prisijungti.setOnClickListener(new View.OnClickListener() {



                @Override
                    public void onClick(View arg0) {
                    username = mUsernameView.getText().toString();
                    password = mPasswordView.getText().toString();

                    boolean cancel = false;
                    View focusView = null;
                    if (!isValid(username)){
                        mUsernameView.setError("Neįvestas prisijungimo vardas");
                        focusView = mUsernameView;
                        cancel = true;
                    }
                    if (!isValid(password)){
                        mPasswordView.setError("Neįvestas slaptažodis");
                        focusView = mPasswordView;
                        cancel = true;
                    }
                    if (cancel){
                        focusView.requestFocus();
                    }
                    else {
                        Intent myIntent = new Intent(MainActivity.this, MeniuActivity.class);
                        startActivity(myIntent);
                    }
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
    private boolean isValid(String credentials) {
        final String CREDENTIALS_PATTERN = "^([0-9a-zA-z]{3,15})+$";
        Pattern pattern = Pattern.compile(CREDENTIALS_PATTERN);

        Matcher matcher = pattern.matcher(credentials);
        return matcher.matches();
    }
}
