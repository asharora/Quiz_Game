package com.example.quiz_game;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

public class Home extends AppCompatActivity implements View.OnClickListener {

    CardView home_Countries, home_Sports, home_Music, home_GK, home_Movies;
    TextView home_username;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);


        home_Countries = findViewById(R.id.home_Countries);
        home_GK = findViewById(R.id.home_GK);
        home_Movies = findViewById(R.id.home_Movies);
        home_Sports = findViewById(R.id.home_Sports);
        home_Music = findViewById(R.id.home_Music);
        home_username=findViewById(R.id.home_username);

        home_Countries.setOnClickListener(this);
        home_GK.setOnClickListener(this);
        home_Movies.setOnClickListener(this);
        home_Sports.setOnClickListener(this);
        home_Music.setOnClickListener(this);
    }


    @Override
    public void onClick(View view) {

        Intent intent;
        switch (view.getId()) {
            case R.id.home_Countries: {
                intent = new Intent(Home.this, Question.class);
                intent.putExtra("name", "Countries");
                startActivity(intent);
            }

            case R.id.home_GK: {
                intent = new Intent(Home.this, Question.class);
                intent.putExtra("name", "G.K.");
                startActivity(intent);
            }
            case R.id.home_Movies: {
                intent = new Intent(Home.this, Question.class);
                intent.putExtra("name", "Movies");
                startActivity(intent);
            }
            case R.id.home_Music: {
                intent = new Intent(Home.this, Question.class);
                intent.putExtra("name", "Music");
                startActivity(intent);
            }
            case R.id.home_Sports: {
                intent = new Intent(Home.this, Question.class);
                intent.putExtra("name", "Sports");
                startActivity(intent);
            }


        }

    }
}
