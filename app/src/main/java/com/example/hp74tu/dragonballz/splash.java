package com.example.hp74tu.dragonballz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class splash extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        sp first= new sp();

        first.start();
    }

    public class sp extends Thread{

        public  void run()
        {
            try{
                sleep(3000);
            }catch (Exception e){

            }
            finally {
                Intent gohome = new Intent(splash.this , menu.class);
                startActivity(gohome);

            }
        }
    }


    @Override
    protected void onPause() {
        super.onPause();
        finish();
    }
}
