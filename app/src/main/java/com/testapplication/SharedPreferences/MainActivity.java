package com.testapplication.SharedPreferences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    SharedPreferences pref;
    SharedPreferences.Editor editor;
    String readMobileNum ;
    String readAddress ;
    Intent RegisterActivity ;
    Intent testActivity;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        pref = getSharedPreferences("testSP",MODE_PRIVATE) ;
       /* editor = pref.edit() ;
        editor.putString("Phone", null) ;
        editor.putString("Address", null) ;
        editor.apply();*/
        readMobileNum = pref.getString("Phone", null) ;
        readAddress = pref.getString("Address", null) ;
        System.out.println(readMobileNum + " AND " +  readAddress);

        if(readMobileNum == null && readAddress == null)
        {
            RegisterActivity = new Intent(MainActivity.this , Register.class) ;
            startActivity(RegisterActivity);
        }else
        {
            testActivity = new Intent(MainActivity.this, test.class);
            startActivity(testActivity);
        }



    }


}