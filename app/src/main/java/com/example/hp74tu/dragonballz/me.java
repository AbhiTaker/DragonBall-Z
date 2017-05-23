package com.example.hp74tu.dragonballz;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

import java.io.IOException;
import java.io.InputStream;

import static android.provider.MediaStore.ACTION_IMAGE_CAPTURE;

public class me extends AppCompatActivity implements View.OnClickListener{

    ImageView ivsee,ivmain;
    ImageButton ib;
    Button b;
    Intent i;
   final static int cameradata=0;
    Bitmap bmp;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_me);

        init();
        InputStream is = getResources().openRawResource(R.drawable.all);
        bmp = BitmapFactory.decodeStream(is);
    }

    private void init() {
        ib = (ImageButton)findViewById(R.id.takepic);
        ivmain = (ImageView)findViewById(R.id.returnpic);
        ivsee = (ImageView)findViewById(R.id.seepic);
        b = (Button)findViewById(R.id.setwall);
        b.setOnClickListener(this);
        ib.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.takepic :
                i = new Intent(ACTION_IMAGE_CAPTURE);
                startActivityForResult(i,cameradata);


                break;
            case R.id.setwall:
                ivmain.setImageBitmap(bmp);
                break;
        }

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(resultCode == RESULT_OK)
        {
            Bundle extras =data.getExtras();
            bmp = (Bitmap) extras.get("data");
            ivsee.setImageBitmap(bmp);

        }
    }
}
