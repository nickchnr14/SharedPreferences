package com.testapplication.SharedPreferences;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Register extends AppCompatActivity {

    Button registerBtn;
    EditText readMobileNo;
    EditText readAddress;
    TextView displayString;
    SharedPreferences pref;
    SharedPreferences.Editor editor;
    Intent testActivity ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        registerBtn = findViewById(R.id.RegisterBtn);
        readMobileNo = findViewById(R.id.mobileNumberEditText);
        readAddress = findViewById(R.id.addressEditText);

        pref = getSharedPreferences("testSP",MODE_PRIVATE) ;
        editor = pref.edit();


    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        moveTaskToBack(true);
        android.os.Process.killProcess(android.os.Process.myPid());
        System.exit(1);
    }

    public void addData() {
        editor.putString("Phone", readMobileNo.getText().toString());
        editor.putString("Address", readAddress.getText().toString());
        editor.apply();
    }

    public void registerUser(View view) {

        boolean isFieldEmpty = checkEmptyFields();


        if(isFieldEmpty)
        {
            addData() ;
            AlertDialog.Builder builder
                    = new AlertDialog
                    .Builder(Register.this);

            builder.setMessage("SUCCESSFULLY REGISTERED !");
            builder.setCancelable(false);
            builder.setNegativeButton("Ok", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.cancel();
                    testActivity = new Intent(Register.this, test.class) ;
                    startActivity(testActivity);

                }
            });
            AlertDialog alertDialog = builder.create();
           alertDialog.show();
        }

    }

    public boolean checkEmptyFields() {
        String tempMobileNo = readMobileNo.getText().toString();
        String tempAddress = readAddress.getText().toString();

        if (tempMobileNo.isEmpty() && tempAddress.isEmpty()) {
            Toast.makeText(this, "Enter all the fields", Toast.LENGTH_SHORT).show();
            return false;
        } else if (tempMobileNo.isEmpty()) {
            Toast.makeText(this, "Enter your Mobile Number", Toast.LENGTH_SHORT).show();
            return false;

        } else if (tempAddress.isEmpty()) {
            Toast.makeText(this, "Enter the address", Toast.LENGTH_SHORT).show();
            return false;

        }
        else if (tempMobileNo.length() < 10) {
            Toast.makeText(this, "Please Enter 10 Digit Mobile number", Toast.LENGTH_SHORT).show();
            readMobileNo.setText("");
            return false;
        }
        return true;


    }
}
