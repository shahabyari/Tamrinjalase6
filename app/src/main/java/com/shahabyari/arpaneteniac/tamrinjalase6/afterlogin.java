package com.shahabyari.arpaneteniac.tamrinjalase6;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

/**
 * Created by Administrator on 15/11/2016.
 */

public class afterlogin extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.afterlogin);
        Intent inte = getIntent();
        String stusername= inte.getStringExtra("Username").toString();
        String sttxtEmail= inte.getStringExtra("txtEmail").toString();
        String sttxtPass = inte.getStringExtra("txtPass").toString();
        String sttxtPassrep = inte.getStringExtra("txtPassrep").toString();
        String sttxtphone = inte.getStringExtra("txtphone").toString();
        TextView username = (TextView) findViewById(R.id.username);
        TextView Email = (TextView) findViewById(R.id.txtEmail);
        username.setText(stusername.toString());
        Email.setText(sttxtEmail.toString());

    }
}

