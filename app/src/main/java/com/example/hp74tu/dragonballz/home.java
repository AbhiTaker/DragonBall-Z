package com.example.hp74tu.dragonballz;

import android.media.MediaPlayer;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ToggleButton;

public class home extends AppCompatActivity implements View.OnClickListener {

    MediaPlayer song;
    ToggleButton tb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        song = MediaPlayer.create(home.this,R.raw.dragonball);
        tb =(ToggleButton)findViewById(R.id.songcntrl) ;
        tb.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        switch (v.getId())
        {
            case R.id.songcntrl :
                if(tb.isChecked())
                {
                    song.start();
                }
                else
                {
                    song.pause();
                }
                break;




        }

    }

    @Override
    protected void onPause() {
        super.onPause();
        song.release();
    }


}
