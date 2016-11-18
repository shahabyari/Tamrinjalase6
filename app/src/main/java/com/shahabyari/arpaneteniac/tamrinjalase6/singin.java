package com.shahabyari.arpaneteniac.tamrinjalase6;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;

/**
 * Created by Administrator on 17/11/2016.
 */

public class singin extends AppCompatActivity {

    private DatePicker datePicker;
    private Calendar calendar;
    private TextView dateView;
    private int year, month, day;
    private boolean flagage = false;
    private boolean flagtext = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signinform);

        dateView = (TextView) findViewById(R.id.textviewdate);
        calendar = Calendar.getInstance();
        year = calendar.get(Calendar.YEAR);

        month = calendar.get(Calendar.MONTH);
        day = calendar.get(Calendar.DAY_OF_MONTH);
        showDate(year, month + 1, day);

    }

    @SuppressWarnings("deprecation")
    public void setDate(View view) {
        showDialog(999);
        //Toast.makeText(getApplicationContext(), "انتخاب تاریخ", Toast.LENGTH_SHORT).show();
    }

    //ساخت دیالوگ نمایش تقویم
    @Override
    protected Dialog onCreateDialog(int id) {
// TODO Auto-generated method stub
        if (id == 999) {
            return new DatePickerDialog(this, myDateListener, year, month, day);
        }
        return null;
    }

    private DatePickerDialog.OnDateSetListener myDateListener = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker arg0, int arg1, int arg2, int arg3) {
// TODO Auto-generated method stub
// arg1 = year //سال
// arg2 = month // ماه
// arg3 = day // روز
            Calendar c = Calendar.getInstance();
            int YCURRENT = c.get(Calendar.YEAR);
            TextView txdate = (TextView) findViewById(R.id.Lableviewdate);

            if ((YCURRENT - arg1) < 20) {
                txdate.setText("سن شما" + (YCURRENT - arg1) + "میباشد.زیر سن قانونی هستید");
                txdate.setTextColor(getResources().getColor(R.color.Red));
                flagage = false;
            } else {
                txdate.setText("سن شما" + (YCURRENT - arg1) + "میباشد . سن شما قانونی است");
                txdate.setTextColor(getResources().getColor(R.color.Green));
                flagage = true;
            }
            showDate(arg1, arg2 + 1, arg3);

        }
    };

    // دریافت اطلاعات از تقویم و نمایش مقدار دریافتی در تکست ویو
    private void showDate(int year, int month, int day) {

        dateView.setText(new StringBuilder().append(day).append("/")
                .append(month).append("/").append(year));


    }

    public void launchRingDialog(View view) {
        final ProgressDialog ringProgressDialog = ProgressDialog.show(singin.this, "لطفا صبر کنید ....", "در حال اتصال به سرور و لاگین ....", true);
        ringProgressDialog.setCancelable(true);
        EditText txtusername = (EditText) findViewById(R.id.txtusername);
        EditText txtEmail = (EditText) findViewById(R.id.txtEmail);
        EditText txtPass = (EditText) findViewById(R.id.txtpass);
        EditText txtPassrep = (EditText) findViewById(R.id.txtpassrep);
        EditText txtphone = (EditText) findViewById(R.id.txtmobile);

        if (txtusername.getText().toString().equals(""))
            txtusername.setBackgroundResource(R.drawable.errortxtedittxt);
         if (txtEmail.getText().toString().equals(""))
            txtEmail.setBackgroundResource(R.drawable.errortxtedittxt);
         if (txtPass.getText().toString().equals(""))
            txtPass.setBackgroundResource(R.drawable.errortxtedittxt);
       if (txtPassrep.getText().toString().equals(""))
            txtPassrep.setBackgroundResource(R.drawable.errortxtedittxt);
         if (txtphone.getText().toString().equals(""))
            txtphone.setBackgroundResource(R.drawable.errortxtedittxt);

        if (!txtphone.getText().toString().equals("") && !txtPassrep.getText().toString().equals("") && !txtPass.getText().toString().equals("")
                && !txtEmail.getText().toString().equals("") && !txtusername.getText().toString().equals("")) {
            flagtext = true;
        }
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {

                    if (flagage && flagtext) {
                        // Here you should write your time consuming task...
                        // Let the progress ring for 10 seconds...
                        Thread.sleep(5000);
                        EditText txtusername = (EditText) findViewById(R.id.txtusername);
                        EditText txtEmail = (EditText) findViewById(R.id.txtEmail);
                        EditText txtPass = (EditText) findViewById(R.id.txtpass);
                        EditText txtPassrep = (EditText) findViewById(R.id.txtpassrep);
                        EditText txtphone = (EditText) findViewById(R.id.txtmobile);
                        Intent inte = new Intent(singin.this, afterlogin.class);
                        inte.putExtra("Username",txtusername.getText().toString());
                        inte.putExtra("txtEmail",txtEmail.getText().toString());
                        inte.putExtra("txtPass",txtPass.getText().toString());
                        inte.putExtra("txtPassrep",txtPassrep.getText().toString());
                        inte.putExtra("txtphone",txtphone.getText().toString());
                        startActivity(inte);
                    } else {
                        Toast.makeText(singin.this, "لطفا تمامی فیلد ها را پر کنید", Toast.LENGTH_LONG).show();
                    }
                } catch (Exception e) {

                }
                ringProgressDialog.dismiss();
            }
        }).start();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
// Inflate the menu; this adds items to the action bar if it is present.
        //   getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
}