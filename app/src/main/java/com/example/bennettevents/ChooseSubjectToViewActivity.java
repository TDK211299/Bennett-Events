package com.example.bennettevents;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class ChooseSubjectToViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_subject_to_view);
    }

    public void buSEview(View view) {
        Intent i = new Intent(ChooseSubjectToViewActivity.this, ViewSubjectSEActivity.class);
        startActivity(i);
    }

    public void buCNview(View view) {
        Intent i = new Intent(ChooseSubjectToViewActivity.this, ViewSubjectCNActivity.class);
        startActivity(i);
    }

    public void buDAAview(View view) {
        Intent i = new Intent(ChooseSubjectToViewActivity.this, ViewSubjectDAAActivity.class);
        startActivity(i);
    }

    public void buCPview(View view) {
        Intent i = new Intent(ChooseSubjectToViewActivity.this, ViewSubjectCPActivity.class);
        startActivity(i);
    }

    public void buOSview(View view) {
        Intent i = new Intent(ChooseSubjectToViewActivity.this, ViewSubjectOSActivity.class);
        startActivity(i);
    }
}

