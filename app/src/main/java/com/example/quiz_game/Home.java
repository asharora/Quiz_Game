package com.example.quiz_game;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

public class Home extends AppCompatActivity  {

    CardView home_Countries, home_Sports, home_Music, home_GK, home_Movies;
    TextView home_username;
    static public String em;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Intent intent =getIntent();
        String email=intent.getStringExtra("email");
        em=(email.split("@"))[0];
        home_Countries = findViewById(R.id.home_Countries);
        home_GK = findViewById(R.id.home_GK);
        home_Movies = findViewById(R.id.home_Movies);
        home_Sports = findViewById(R.id.home_Sports);
        home_Music = findViewById(R.id.home_Music);
        home_username=findViewById(R.id.home_username);

        //////////////////////
        home_username.setText("Welcome " +em);
        //////////////////////

        home_Countries.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Home.this, Question.class);
                intent.putExtra("name", "Countries");
                startActivity(intent);
            }
        });
        home_GK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Home.this, Question.class);
                intent.putExtra("name", "G.K.");
                startActivity(intent);
            }
        });
        home_Movies.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Home.this, Question.class);
                intent.putExtra("name", "Movies");
                startActivity(intent);
            }
        });
        home_Sports.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Home.this, Question.class);
                intent.putExtra("name", "Sports");

                startActivity(intent);
            }
        });
        home_Music.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Home.this,Question.class);
                intent.putExtra("name", "music");
                startActivity(intent);
            }
        });
    }



}
