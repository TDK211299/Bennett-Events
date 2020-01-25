package com.example.bennettevents;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

public class RegistrationActivity extends AppCompatActivity {
    private EditText etSignupEmail;
    private EditText etSignupPassword;
    private FirebaseAuth firebaseAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        etSignupEmail=findViewById(R.id.etSignupEmail);
        etSignupPassword=findViewById(R.id.etSignupPassword);
        firebaseAuth=firebaseAuth.getInstance();
    }

    public void buSignupClick(View view) {
        final ProgressDialog progressDialog=ProgressDialog.show(RegistrationActivity.this, "Please wait", "Working",true);
        (firebaseAuth.createUserWithEmailAndPassword(etSignupEmail.getText().toString(),etSignupPassword.getText().toString()))
                .addOnCompleteListener(new OnCompleteListener<com.google.firebase.auth.AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<com.google.firebase.auth.AuthResult> task) {
                        progressDialog.dismiss();
                        if (task.isSuccessful()) {
                            Toast.makeText(RegistrationActivity.this, "Registration successful", Toast.LENGTH_LONG).show();
                            Intent i = new Intent(RegistrationActivity.this, Login.class);
                            startActivity(i);
                        }
                        else
                        {
                            Log.e("ERROR", task.getException().toString());
                            Toast.makeText(RegistrationActivity.this, task.getException().getMessage(), Toast.LENGTH_LONG).show();
                        }

                    }
                });
    }
}
