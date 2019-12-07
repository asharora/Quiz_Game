package com.example.quiz_game;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Login_Page extends AppCompatActivity {

    private FirebaseAuth mAuth;
    EditText login_email,login_password;
    Button login_signin,login_signup;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        login_email=findViewById(R.id.login_email);
        login_password=findViewById(R.id.login_password);
        login_signin=findViewById(R.id.login_signin);
        login_signup=findViewById(R.id.login_signup);


        mAuth = FirebaseAuth.getInstance();

        login_signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                mAuth.signInWithEmailAndPassword(login_email.getText().toString(), login_password.getText().toString())
                        .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    // Sign in success, update UI with the signed-in user's information
                                    Log.d("world", "signInWithEmail:success");
                                    Intent intent=new Intent(Login_Page.this,Home.class);
                                    intent.putExtra("email",login_email.getText().toString());
                                    startActivity(intent);

                                } else {
                                    // If sign in fails, display a message to the user.

                                    Toast.makeText(getApplicationContext(), "Authentication failed.",Toast.LENGTH_SHORT).show();

                                }

                                // ...
                            }
                        });
            }
        });
        login_signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Login_Page.this,Sign_Up.class);
                startActivity(intent);
            }
        });



    }

//    public void signin(String email,String password)
//    {
//        mAuth.signInWithEmailAndPassword(email, password)
//                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
//                    @Override
//                    public void onComplete(@NonNull Task<AuthResult> task) {
//                        if (task.isSuccessful()) {
//                            Log.w("hello","Welcome");
//                            Toast.makeText(getApplicationContext(), "WELCOME TO QUIZ", Toast.LENGTH_SHORT).show();
//                            Intent intent = new Intent(Login_Page.this, Home.class);
//                          startActivity(intent);
//                        } else {
//                            // If sign in fails, display a message to the user.
//                            Log.w("hello1","Welcome");
//
//                            Toast.makeText(getApplicationContext(), "Authentication failed.", Toast.LENGTH_SHORT).show();
//
//                        }
//                    }
//                });
//    }
}