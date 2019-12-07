package com.example.quiz_game;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.DownloadManager;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Question extends AppCompatActivity {

    static TextView question_choice1,question_choice2,question_choice3,question_choice4,question_question,question_question_no;
    static int Total_Question=10;
   static  int count_Score=0;
   static Button question_confirm;
    static int idx=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question);

        question_choice1=findViewById(R.id.question_choice1);
        question_choice2=findViewById(R.id.question_choice2);
        question_choice3=findViewById(R.id.question_choice3);
        question_choice4=findViewById(R.id.question_choice4);
        question_question=findViewById(R.id.question_question);
        question_question_no=findViewById(R.id.question_question_no);
        question_confirm=findViewById(R.id.question_confirm);
         RequestQueue queue= Volley.newRequestQueue(this);
        String url = "https://api.myjson.com/bins/1a8ud2";

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest
                (Request.Method.GET, url, null, new Response.Listener<JSONObject>() {

                    @Override
                    public void onResponse(JSONObject response) {

                        Toast.makeText(getApplicationContext(),"Hello",Toast.LENGTH_SHORT).show();
                        Log.d("yy","API REGISTERED");
                        try {
                            final Application_Question[] questions=new Application_Question[10];
                            JSONArray obj=response.getJSONArray("results");
                            for(int i=0;i<obj.length();i++)
                            {
                                Application_Question n=new Application_Question();
                                String corr=obj.getJSONObject(i).getString("correct_answer");
                                n.setCorrectAnswer(corr);
                                List<String> ans=new ArrayList<>();
                                ans.add(obj.getJSONObject(i).getJSONArray("answers").getString(0));
                                ans.add(obj.getJSONObject(i).getJSONArray("answers").getString(1));
                                ans.add(obj.getJSONObject(i).getJSONArray("answers").getString(2));
                                ans.add(obj.getJSONObject(i).getJSONArray("answers").getString(3));
                                n.setAnswers(ans);
                               String ques=(obj.getJSONObject(i).getString("question"));
                               n.setQuestion(ques);
                               questions[i]=n;
                                 Log.d("qqqqqqq",n.getQuestion()+"\n"+n.getCorrectAnswer() +"\n"+n.getAnswers());

                            }

                            show_question(questions,0);
                            clear_answer();
                            idx++;
                            question_confirm.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    Log.d("ppppp",idx+"");
                                    show_question(questions, idx);
                                    clear_answer();
                                    idx++;
                                    if(idx>=10)
                                    {
                                        Intent intent=new Intent(Question.this,Result.class);
                                        intent.putExtra("score",count_Score);
                                        startActivity(intent);
                                    }



                                }
                            });

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }
                }, new Response.ErrorListener() {

                    @Override
                    public void onErrorResponse(VolleyError error) {
                        // TODO: Handle error
                        Log.d("nn","API UNREGISTERED");
                    }
                });



// Access the RequestQueue through your singleton class.
        queue.add(jsonObjectRequest);

    }


    public static void show_question(Application_Question[] questions, int id)
    {
        Application_Question question=questions[id];
        String ques=question.getQuestion();
        String ch1=question.getAnswers().get(0);
        String ch2=question.getAnswers().get(1);
        String ch3=question.getAnswers().get(2);
        String ch4=question.getAnswers().get(3);
        final String correct_ans=question.getCorrectAnswer();

        question_question.setText(ques);
        question_choice1.setText(ch1);
        question_choice2.setText(ch2);
        question_choice3.setText(ch3);
        question_choice4.setText(ch4);
        ///////////////////////////////
        question_choice1.setOnClickListener(new View.OnClickListener() {
                        @Override
            public void onClick(View view) {
                if(question_choice1.getText().toString().equals(correct_ans))
                {
                    question_choice1.setBackgroundColor(Color.parseColor("#7CFC00"));
                    count_Score++;
                    return;
                }
                else
                {
                    question_choice1.setBackgroundColor(Color.parseColor("#FF0000"));
                    return;
                }
            }
        });

        //////////////////////////////
        question_choice2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                if(question_choice2.getText().toString().equals(correct_ans))
                {
                    question_choice2.setBackgroundColor(Color.parseColor("#7CFC00"));
                    count_Score++;
                    return;

                }
                else
                {
                    question_choice2.setBackgroundColor(Color.parseColor("#FF0000"));
                    count_Score++;
                    return;
                }
            }
        });

        ///////////////////
        question_choice3.setOnClickListener(new View.OnClickListener() {
                     @Override
            public void onClick(View view) {
                if(question_choice3.getText().toString().equals(correct_ans))
                {
                    question_choice3.setBackgroundColor(Color.parseColor("#7CFC00"));
                    count_Score++;
                    return;
                }
                else
                {
                    question_choice3.setBackgroundColor(Color.parseColor("#FF0000"));
                    return;
                }
            }
        });

        ////////////////////////
        question_choice4.setOnClickListener(new View.OnClickListener() {
                      @Override
            public void onClick(View view) {
                if(question_choice4.getText().toString().equals(correct_ans))
                {
                    question_choice4.setBackgroundColor(Color.parseColor("#7CFC00"));
                    count_Score++;
                    return;
                }
                else
                {
                    question_choice4.setBackgroundColor(Color.parseColor("#FF0000"));
                    return;
                }
            }
        });
        //////////////////////////
    }


    public static void clear_answer()
    {

        question_choice1.setBackgroundColor(Color.parseColor("#FFFFFF"));
        question_choice2.setBackgroundColor(Color.parseColor("#FFFFFF"));
        question_choice3.setBackgroundColor(Color.parseColor("#FFFFFF"));
        question_choice4.setBackgroundColor(Color.parseColor("#FFFFFF"));

    }
}
