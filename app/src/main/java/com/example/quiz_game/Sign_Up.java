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
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

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
//                             FirebaseDatabase database = FirebaseDatabase.getInstance();
//                               Log.d("ppppp",FirebaseDatabase.getInstance("https://quiz-game-62f4e.firebaseio.com/")+"");
//                                 DatabaseReference myRef = database.getReference();
//                               Log.d("ppppp",myRef+"");
//                               DatabaseReference chref= myRef.child(signup_email.getText().toString());
////                               Log.d("database",chref+"");
////                               chref.setValue(10);

                               // Write a message to the database
                               FirebaseDatabase database = FirebaseDatabase.getInstance();
                               DatabaseReference myRef = database.getReference();
                               Log.d("email",signup_email.getText().toString());
                               String em=(signup_email.getText().toString().split("@"))[0];
                               DatabaseReference chif=myRef.child(em);
                               chif.child("High_Score").setValue(0);
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
