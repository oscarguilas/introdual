package com.example.introdual;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    //Variables
    TextView questionText;
    Button buttonTrue, buttonFalse;
    ArrayList<Integer> shownQuestions = new ArrayList<Integer>();
    boolean correctAnswer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        declareVars();

        getNewQuestion();
    }

    @Override
    protected void onResume() {
        super.onResume();

        getNewQuestion();
    }

    public void declareVars(){
        questionText = findViewById(R.id.textQuestion);
        buttonTrue = findViewById(R.id.buttonTrue);
        buttonFalse = findViewById(R.id.buttonFalse);
    }

    public void optionSelect(View view){
        int viewId = view.getId();
        if (viewId == buttonTrue.getId()) {
            checkResult(true);
        } else if (viewId == buttonFalse.getId()) {
            checkResult(false);
        } else  /*error*/ Log.i("optionSelect", "Error: viewId doesnt correspond to any button");
    }

    public void checkResult(boolean click){
        Intent intent = new Intent(this, ResultsActivity.class);

        if(click ==  correctAnswer){
            intent.putExtra("result", true);
            startActivity(intent);
        } else {
            intent.putExtra("result", false);
            startActivity(intent);
        }
    }

    public void getNewQuestion(){
        Random rng = new Random();
        int i = rng.nextInt(10);
        if(shownQuestions != null) {
            if (shownQuestions.size() < 10) {
                while (hasBeenShown(i)) {
                    i = rng.nextInt(10);
                }
                shownQuestions.add(i);

                questionText.setText(getResources().getStringArray(R.array.questions)[i]);
                correctAnswer = Boolean.valueOf(getResources().getStringArray(R.array.answers)[i]);
            } else {
                Log.i("getNewQuestion", "All questions have already been shown");
            }
        } else {
            shownQuestions.add(i);

            questionText.setText(getResources().getStringArray(R.array.questions)[i]);
            correctAnswer = Boolean.valueOf(getResources().getStringArray(R.array.answers)[i]);
        }



    }

    public boolean hasBeenShown(int check){ // Por acabar
        int i = 0;
        boolean feedback = false;
        while(i<shownQuestions.size()){
            if(shownQuestions.get(i) == check) feedback = true;
            i++;
        }

        return feedback;

    }

}
