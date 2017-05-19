package com.example.hp74tu.dragonballz;

import android.media.MediaPlayer;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ToggleButton;

public class home extends AppCompatActivity {

    MediaPlayer song;
    ToggleButton tb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        song = MediaPlayer.create(home.this,R.raw.dragonball);
        tb =(ToggleButton)findViewById(R.id.songcntrl) ;
        tb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(tb.isChecked())
                {
                    song.start();
                }
                else
                {
                    song.pause();
                }
            }
        });


    }

    @Override
    protected void onPause() {
        super.onPause();
        song.release();
    }
}
