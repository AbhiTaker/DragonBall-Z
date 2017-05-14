package com.example.hp74tu.dragonballz;

import android.media.MediaPlayer;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class home extends AppCompatActivity {

    MediaPlayer song;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        song = MediaPlayer.create(home.this,R.raw.dragonball);
        song.start();
    }

    @Override
    protected void onPause() {
        super.onPause();
        song.release();
    }
}
