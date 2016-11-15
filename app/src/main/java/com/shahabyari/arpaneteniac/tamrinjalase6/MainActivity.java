package com.shahabyari.arpaneteniac.tamrinjalase6;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void launchRingDialog(View view) {
        final ProgressDialog ringProgressDialog = ProgressDialog.show(MainActivity.this, "لطفا صبر کنید ....",	"در حال اتصال به سرور و لاگین ....", true);
        ringProgressDialog.setCancelable(true);
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    // Here you should write your time consuming task...
                    // Let the progress ring for 10 seconds...
                    Thread.sleep(5000);
                    Intent inte = new Intent(MainActivity.this,afterlogin.class);
                    startActivity(inte);
                } catch (Exception e) {

                }
                ringProgressDialog.dismiss();
            }
        }).start();
    }

    @Override
    protected void onStop() {
        super.onStop();
        finish();
    }
}
