package com.example.truefalse;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    ArrayList<Quizz> questions = new ArrayList<>();
    int questionCursor = 0;
    Button falseButton;
    Button trueButton;
    Button prButton;
    Button nxButton;
    TextView questionText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        questions.add(new Quizz("Chicote is a football player from Spain.",false));
        questions.add(new Quizz("Cristiano Ronaldo is the best football player.",false));
        questions.add(new Quizz("COVID-19 doesn't infect with hot weather.",false));
        questions.add(new Quizz("Border Collie is a dog.",true));
        questions.add(new Quizz("Queen Gambit is a Netflix's production.",true));

        questionText = findViewById(R.id.txtQuestion);
        questionText.setText(questions.get(0).getQuestion());
        falseButton = findViewById(R.id.falseButton);
        trueButton = findViewById(R.id.trueButton);
        prButton = findViewById(R.id.prButton);

        nxButton = findViewById(R.id.nxButton);

        falseButton.setOnClickListener(this);
        trueButton.setOnClickListener(this);
        prButton.setOnClickListener(this);
        nxButton.setOnClickListener(this);

    }

    public void questionView(int cursor){
        int nextQuestion = questionCursor+cursor;
        if(nextQuestion >=0 && nextQuestion < questions.size()){
            questionText.setText(questions.get(nextQuestion).getQuestion());
            questionCursor=nextQuestion;
        }
        if(questionCursor==0){prButton.setVisibility(View.GONE);}
        else if(questionCursor==questions.size()-1){nxButton.setVisibility(View.GONE);}
        else{prButton.setVisibility(View.VISIBLE);
        nxButton.setVisibility(View.VISIBLE);}

    }


    public void onClick(View v){
        if (falseButton.equals(v)) {
            check(false);
        } else if (trueButton.equals(v)) {
            check(true);
        } else if (nxButton.equals(v)) {
            questionView(1);
        } else if (prButton.equals(v)) {
            questionView(-1);
        }
    }

    public void check(boolean answer){
        String result;
        if(questions.get(questionCursor).answer()==answer){
            result="YOU'RE RIGHT";
            Toast pop = Toast.makeText(this, result, Toast.LENGTH_LONG/3);
            pop.show();
            questionView(1);
        }
        else{
            result="YOU'RE WRONG";
            Toast pop = Toast.makeText(this,result,Toast.LENGTH_LONG/3);
            pop.show();
        }
    }

}