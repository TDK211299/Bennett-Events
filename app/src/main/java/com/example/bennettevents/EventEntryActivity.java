package com.example.bennettevents;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;

public class EventEntryActivity extends AppCompatActivity {
    EditText etEventName;
    EditText etDate;
    Button buEnter;
    Spinner spinner;
    String ev;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_entry);
        etEventName=findViewById(R.id.etEventName);
        etDate=findViewById(R.id.etDate);
        buEnter=findViewById(R.id.buEnter);
        spinner=findViewById(R.id.spinner);
        final List<String> subs=new ArrayList<String>();
        subs.add("Educational Workshop");
        subs.add("Sports");
        subs.add("Competition");
        subs.add("Guest Lecture");
        ArrayAdapter<String> subsa=new ArrayAdapter<String>(this,android.R.layout.simple_dropdown_item_1line,subs);
        spinner.setAdapter(subsa);
        spinner.setPrompt("Event Type");
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                ev=subs.get(position);
                //Toast.makeText(getApplicationContext(),sub,Toast.LENGTH_LONG).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    public void buEnter(View view) {
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference records = database.getReference();
        records.child("Events").child(ev).child("Event Name").setValue(ev);
        records.child("Events").child(ev).child("Event Name").child(etEventName.getText().toString()).setValue(etEventName.getText().toString());
        records.child("Events").child(ev).child("Date").child(etEventName.getText().toString()).setValue(etDate.getText().toString());

    }

    public void buViewEvent(View view) {
        Intent i = new Intent(EventEntryActivity.this, ChooseEventToViewActivity.class);
        startActivity(i);
    }


    public void buEntryExit(View view) {
        finish();
    }
}
