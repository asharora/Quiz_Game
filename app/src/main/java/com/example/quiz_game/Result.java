package com.example.quiz_game;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Result extends AppCompatActivity {

    static  ProgressBar pg;
    static TextView result_status,result_score;
    static Button playanother;
    int score;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result2);
        Intent intent=getIntent();

        score = intent.getIntExtra("score",0)*10;
        pg=findViewById(R.id.result_progressbar);
        result_status=findViewById(R.id.result_status);
        result_score=findViewById(R.id.result_score);
        playanother=findViewById(R.id.playanother);
        result_score.setText(score+"%");
        if(score<50)
        {
            result_status.setText("You Lose !!");
        }
        pg.setProgress(score);



        final FirebaseDatabase database=FirebaseDatabase.getInstance();
        DatabaseReference myRef=database.getReference().getRef();



       // Toast.makeText(getApplicationContext(),myRef+"\n"+Home.em,Toast.LENGTH_SHORT).show();
        DatabaseReference ch=myRef.child(Home.em);
        ch.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

         //       Log.d("helloworld",Integer.parseInt(dataSnapshot.child("High_Score").toString())+"");
//             if(score < Integer.parseInt(dataSnapshot.child("High_Score").toString()))
//             {
//                 score=Integer.parseInt(dataSnapshot.child("High_Score").toString());
//             }
           }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        ch.child("High_Score").setValue(score+"");


        playanother.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Result.this,Home.class);
                startActivity(intent);
            }
        });

    }
}
