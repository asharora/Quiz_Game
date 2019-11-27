package com.example.quiz_game;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Sign_Up extends AppCompatActivity {

    TextView signup_email,signup_password,signup_confirmpassword;
    Button signup_signup;
    private FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign__up);

        signup_email=findViewById(R.id.signup_email);
        signup_password=findViewById(R.id.signup_password);
        signup_confirmpassword=findViewById(R.id.signup_Confirm_password);
        signup_signup=findViewById(R.id.signup_signup);

        mAuth = FirebaseAuth.getInstance();

        signup_signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

               if(signup_password.getText().toString().equals(signup_confirmpassword.getText().toString()))
               {
                   mAuth.createUserWithEmailAndPassword(signup_email.getText().toString(),signup_password.getText().toString()).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                       @Override
                       public void onComplete(@NonNull Task<AuthResult> task) {

                           if(task.isSuccessful())
                           {
                              Toast.makeText(getApplicationContext(),"REGISTERED SUCCESSFULLY",Toast.LENGTH_SHORT).show();
                              finish();
                           }
                           else
                           {
                               Toast.makeText(getApplicationContext(),"REGISTERATION FAILED",Toast.LENGTH_SHORT).show();
                           }
                       }
                   });
               }
               else
               {
                   Toast.makeText(getApplicationContext(),"PASSWORD NOT MATCH",Toast.LENGTH_SHORT).show();
               }
            }
        });


    }
}
