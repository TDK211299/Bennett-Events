package com.example.bennettevents;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class ChooseEventToViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_event_to_view);
    }

    public void buSports(View view) {
        Intent i = new Intent(ChooseEventToViewActivity.this, ViewEventSports.class);
        startActivity(i);
    }

    public void buComp(View view) {
        Intent i = new Intent(ChooseEventToViewActivity.this, ViewEventCompetition.class);
        startActivity(i);
    }

    public void buGL(View view) {
        Intent i = new Intent(ChooseEventToViewActivity.this, ViewEventGL.class);
        startActivity(i);
    }

    public void buEd(View view) {
        Intent i = new Intent(ChooseEventToViewActivity.this, ViewEventWorkshop.class);
        startActivity(i);
    }
}
