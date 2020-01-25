package com.example.bennettevents;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.content.Intent;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
    public void buSignup(View view) {
        Intent jump=new Intent(MainActivity.this, RegistrationActivity.class);
        startActivity(jump);
    }

    public void buLogin(View view) {
        Intent jump=new Intent(MainActivity.this, Login.class);
        startActivity(jump);
    }


    public void buAlarmClicked(View view) {
        Intent launchIntent = getPackageManager().getLaunchIntentForPackage("com.google.android.deskclock");//Alarm package ID
        if (launchIntent != null) {
            startActivity(launchIntent);//null pointer check in case package name was not found
        }
        else{
            Toast.makeText(getApplication().getBaseContext(), "install alarm module",
                    Toast.LENGTH_LONG).show();
        }
    }

    public void buCalendarClick(View view) {
        Intent launchIntent = getPackageManager().getLaunchIntentForPackage("com.google.android.calendar");//Calendar package ID
        if (launchIntent != null) {
            startActivity(launchIntent);//null pointer check in case package name was not found
        }
        else{
            Toast.makeText(getApplication().getBaseContext(), "install calendar module",
                    Toast.LENGTH_LONG).show();
        }
    }
}
