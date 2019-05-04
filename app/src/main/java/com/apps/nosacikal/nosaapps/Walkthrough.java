package com.apps.nosacikal.nosaapps;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.apps.nosacikal.nosaapps.view.BottomNavigation;
import com.blogspot.atifsoftwares.animatoolib.Animatoo;
import com.hololo.tutorial.library.Step;
import com.hololo.tutorial.library.TutorialActivity;


/*
 * Selasa 23 April 2019
 * 10116062
 * Nosa Cikal Daputra
 * AKB-2
 * */

public class Walkthrough extends TutorialActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_walkthrough);

        addFragment(new Step.Builder().setTitle("Daily Activity")
                .setContent("Lihat kegiatan saya sehari-hari")
                .setBackgroundColor(Color.parseColor("#f1c40f"))
                .setDrawable(R.drawable.daily)
                .build());

        addFragment(new Step.Builder().setTitle("Gallery")
                .setContent("Kamu bisa lihat gallery foto saya")
                .setBackgroundColor(Color.parseColor("#9adcf4")) // int background color
                .setDrawable(R.drawable.mygallery)
                .build());

        addFragment(new Step.Builder().setTitle("Music & Video")
                .setContent("Lihat Music dan Video Favorite Saya")
                .setBackgroundColor(Color.parseColor("#b481c8")) // int background color
                .setDrawable(R.drawable.music_video)
                .build());

    }

    @Override
    public void finishTutorial() {
        // Your implementation
        Intent intent = new Intent(this, BottomNavigation.class);
        startActivity(intent);
    }

    @Override
    public void currentFragmentPosition(int position) {

    }
}
