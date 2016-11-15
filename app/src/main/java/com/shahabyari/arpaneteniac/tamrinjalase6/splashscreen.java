package com.shahabyari.arpaneteniac.tamrinjalase6;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by Administrator on 13/11/2016.
 */

public class splashscreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splashscreen);

        Thread splashtherad = new Thread() {

            public void run() {

                try {
                    sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                finally {
                    Intent newpage = new Intent(splashscreen.this,MainActivity.class);
                    startActivity(newpage);
                }

            }


        };

        splashtherad.start();

    }

    @Override
    protected void onPause() {
            super.onPause();
            finish();
    }
}
