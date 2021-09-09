package com.testapplication.SharedPreferences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;

public class getSharedPreferencesObject extends AppCompatActivity {
    private SharedPreferences   pref = getSharedPreferences("testSP",MODE_PRIVATE) ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }
}