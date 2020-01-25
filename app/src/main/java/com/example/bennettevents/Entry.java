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

public class Entry extends AppCompatActivity {
    EditText etAssignmentName;
    EditText etSubmissionDate;
    Button buEnter;
    Spinner spinner;
    String sub;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_entry);
        etAssignmentName=findViewById(R.id.etAssignmentName);
        etSubmissionDate=findViewById(R.id.etSubmissionDate);
        buEnter=findViewById(R.id.buEnter);
        spinner=findViewById(R.id.spinner);
        final List<String> subs=new ArrayList<String>();
        subs.add("ECSE204L: Operating System");
        subs.add("ECSE205L: Software Engineering");
        subs.add("ECSE208L: Computer Networks ");
        subs.add("ECSE210L: Design and Analysis of Algorithms ");
        subs.add("ECSE212P: Competitive Programming");
        ArrayAdapter<String> subsa=new ArrayAdapter<String>(this,android.R.layout.simple_dropdown_item_1line,subs);
        spinner.setAdapter(subsa);
        spinner.setPrompt("Subject");
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                sub=subs.get(position);
                //Toast.makeText(getApplicationContext(),sub,Toast.LENGTH_LONG).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    public void buEntryExit(View view) {
        finish();
    }

    public void buClickEnter(View view) {
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference records = database.getReference();
        records.child("Subjects").child(sub).child("Subject Name").setValue(sub);
        records.child("Subjects").child(sub).child("Assignment Name").child(etAssignmentName.getText().toString()).setValue(etAssignmentName.getText().toString());
        records.child("Subjects").child(sub).child("Submission Date").child(etAssignmentName.getText().toString()).setValue(etSubmissionDate.getText().toString());
    }

    public void bugotoView(View view) {
        Intent i = new Intent(Entry.this, ChooseSubjectToViewActivity.class);
        startActivity(i);
    }
}

