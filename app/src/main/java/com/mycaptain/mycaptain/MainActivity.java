package com.mycaptain.mycaptain;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import android.widget.Toast;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText etEmail, etPassword;
    Button btnSignin, btnFacebook;

    String hardCodedUsername = "mycaptain";
    String hardCodedPassword = "qwerty";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SharedPreferences sharedPreferences = getSharedPreferences("settings", MODE_PRIVATE);
        boolean isLoggedIn = sharedPreferences.getBoolean("is_already_logged_in",false);
        if(isLoggedIn) {

            Intent newActivtyIntent = new Intent(MainActivity.this, HomeActivity.class);
            newActivtyIntent.putExtra("image_url", "http://goo.gl/gEgYUd");
            startActivity(newActivtyIntent);

        } else {

            etEmail = findViewById(R.id.et_email);
            etPassword = findViewById(R.id.et_password);
            btnSignin = findViewById(R.id.btn_sign_in);
            btnFacebook = findViewById(R.id.btn_facebook_login);

            btnSignin.setOnClickListener(this);
            btnFacebook.setOnClickListener(this);

        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("RISHABH", "ACTIVITY IS IN PAUSED STATE");
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_sign_in:


                this.finish();
                   String userInputUsername = etEmail.getText().toString();
                   String userInputPassword = etPassword.getText().toString();
                   if(userInputUsername.isEmpty()) {
                       Toast.makeText(getApplicationContext(), "Please enter username", Toast.LENGTH_SHORT).show();
                   } else {
                       if (userInputUsername.equals(hardCodedUsername)) {
                           if (userInputPassword.equals(hardCodedPassword)) {
                               Toast.makeText(getApplicationContext(), "Authorized User", Toast.LENGTH_SHORT).show();
                               Intent newActivtyIntent = new Intent(MainActivity.this, HomeActivity.class);
                               newActivtyIntent.putExtra("image_url", "http://goo.gl/gEgYUd");
                               startActivity(newActivtyIntent);
                           } else {
                               Toast.makeText(getApplicationContext(), "Wrong Password", Toast.LENGTH_SHORT).show();
                           }
                       } else {
                           Toast.makeText(getApplicationContext(), "Wrong Username", Toast.LENGTH_SHORT).show();
                       }
                   }
                break;

            case R.id.btn_facebook_login:
                    Log.d("RISHABH", "SIGN IN With FACEBOOK CLICKED");
                break;
        }

    }



    /*public void changeColor(View view) {
    }*/
}

/*ivColorBox = findViewById(R.id.image_view);
        btnRed = findViewById(R.id.btn_red);*/
        /*btnRed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ivColorBox.setImageResource(R.color.colorAccent);
            }
        });*/


/*
    int number = 10;
    int remainder = number % 2;
        if(remainder == 0) {
                Log.d("MYCAPTAIN", "its an even number");
                } else {
                Log.d("MYCAPTAIN", "its an odd number");
                }


                for(int i = 0; i < 10 ; i++ ) {
        Log.d("RISHABH", String.valueOf(i));
        }
        Log.d("RISHABH", "Execution Completed");

        int i = 10;
        while(i > 0) {
        Log.d("Login", String.valueOf(i));
        i--;
        }
*/

/*

    Intent i = new Intent(Intent.ACTION_SEND);

                i.setType("plain/text");
                        i.putExtra(Intent.EXTRA_EMAIL, new String[]{"random@gmail.com"});
                        i.putExtra(Intent.EXTRA_SUBJECT, "Request");
                        i.putExtra(Intent.EXTRA_TEXT, "Your message here...");
                        try {
                        startActivity(Intent.createChooser(i, "Send message to"));
                        } catch (Exception ex) {
                        ex.printStackTrace();
                        Toast.makeText(getApplicationContext(), "There are no email clients installed.", Toast.LENGTH_SHORT).show();
                        }*/
