package com.apps.nosacikal.nosaapps;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import java.util.Timer;
import java.util.TimerTask;


/*
* Selasa 23 April 2019
* 10116062
* Nosa Cikal Daputra
* AKB-2
* */

public class Splashscreen extends AppCompatActivity {

    ImageView logo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splashscreen);

        logo = findViewById(R.id.img_splash);

        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                startActivity(new Intent(getApplicationContext(), Walkthrough.class));
            }
        }, 4000);

        Animation myanim = AnimationUtils.loadAnimation(this,R.anim.splashscreen_anim);
        logo.startAnimation(myanim);
    }

}
