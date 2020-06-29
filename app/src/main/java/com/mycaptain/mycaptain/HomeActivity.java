package com.mycaptain.mycaptain;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;

public class HomeActivity extends AppCompatActivity {
    ImageView ivUserImage;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        String s = getIntent().getExtras().getString("image_url");
        setContentView(R.layout.home_activity);

        SharedPreferences sharedPreferences = getSharedPreferences("settings", MODE_PRIVATE);
        SharedPreferences.Editor sharedPrefsEditor = sharedPreferences.edit();
        sharedPrefsEditor.putBoolean("is_already_logged_in", true);
        sharedPrefsEditor.apply();




        ivUserImage = findViewById(R.id.iv_user_profile);

        Glide.with(this).load(s).into(ivUserImage);

    }
}

    /*SharedPreferences sa = this.getSharedPreferences("text", MODE_PRIVATE);
    SharedPreferences.Editor ed = sa.edit();*/