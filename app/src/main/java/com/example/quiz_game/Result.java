package com.example.quiz_game;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Result extends AppCompatActivity {

    static  ProgressBar pg;
    static TextView result_status,result_score;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result2);
        Intent intent=getIntent();
        int score;
        score = intent.getIntExtra("score",0)*10;
        pg=findViewById(R.id.result_progressbar);
        result_status=findViewById(R.id.result_status);
        result_score=findViewById(R.id.result_score);
        result_score.setText(score+"%");
        if(score<50)
        {
            result_status.setText("You Lose !!");
        }
        pg.setProgress(score);


        FirebaseDatabase database=FirebaseDatabase.getInstance();
        DatabaseReference myRef=database.getReference().getRef();

        Toast.makeText(getApplicationContext(),myRef+"\n"+Home.em,Toast.LENGTH_SHORT).show();
        DatabaseReference ch=myRef.child(Home.em);
        ch.child("High_Score").setValue(score+" ");
        ;
    }
}
