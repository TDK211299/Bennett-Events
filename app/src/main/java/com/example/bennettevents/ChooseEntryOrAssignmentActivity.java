package com.example.bennettevents;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class ChooseEntryOrAssignmentActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_entry_or_assignment);
    }

    public void buAssEnt(View view) {
        Intent i = new Intent(ChooseEntryOrAssignmentActivity.this, Entry.class);
        startActivity(i);
    }

    public void buEntry(View view) {
        Intent i = new Intent(ChooseEntryOrAssignmentActivity.this, EventEntryActivity.class);
        startActivity(i);
    }

    public void buSup(View view) {
        Intent i = new Intent(ChooseEntryOrAssignmentActivity.this, RegistrationActivity.class);
        startActivity(i);
    }
}
