package com.example.hp74tu.dragonballz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class contact extends AppCompatActivity implements View.OnClickListener {

    EditText etaddress,ettopic,etmail;
    Button   bsend;
    String  staddress,sttopic,stmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);

        init();
        bsend.setOnClickListener(this);

    }

    private void init() {

        etaddress = (EditText)findViewById(R.id.address);
        ettopic = (EditText)findViewById(R.id.topic);
        etmail = (EditText)findViewById(R.id.mail);
        bsend = (Button)findViewById(R.id.send);
    }

    @Override
    public void onClick(View v) {
        convert();
        String to[] = {"abhi.taker20pro@gmail.com"};
        Intent mailsend = new Intent(Intent.ACTION_SEND);
        mailsend.putExtra(Intent.EXTRA_EMAIL,to);
        mailsend.putExtra(Intent.EXTRA_SUBJECT,sttopic);
        mailsend.setType("plain/text");
        mailsend.putExtra(Intent.EXTRA_TEXT,stmail);
        startActivity(mailsend);

    }

    private void convert() {

        staddress = etaddress.getText().toString();
        sttopic = ettopic.getText().toString();
        stmail = etmail.getText().toString();
    }

    @Override
    protected void onPause() {
        super.onPause();
        finish();
    }
}
