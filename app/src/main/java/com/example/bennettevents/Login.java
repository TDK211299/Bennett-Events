package com.example.bennettevents;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.app.ProgressDialog;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Login extends AppCompatActivity {
    private EditText etName;
    private EditText etPassword;
    private FirebaseAuth firebaseAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        etName=findViewById(R.id.etName);
        etPassword=findViewById(R.id.etPassword);
        firebaseAuth=firebaseAuth.getInstance();
    }
    public void buClickLogin(View view) {
        final ProgressDialog progressDialog=ProgressDialog.show(Login.this, "Please wait", "Working",true);
        firebaseAuth.signInWithEmailAndPassword(etName.getText().toString(),etPassword.getText().toString())
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        progressDialog.dismiss();
                        if(task.isSuccessful()){
                            Toast.makeText(Login.this, "Logged in", Toast.LENGTH_LONG).show();
                            Intent i = new Intent(Login.this, ChooseEntryOrAssignmentActivity.class);
                            startActivity(i);
                        }
                        else
                        {
                            Log.e("ERROR", task.getException().toString());
                            Toast.makeText(Login.this, task.getException().getMessage(), Toast.LENGTH_LONG).show();
                        }
                    }
                });
    }
}
