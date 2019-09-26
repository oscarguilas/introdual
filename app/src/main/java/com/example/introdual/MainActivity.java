package com.example.introdual;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    //Variables
    TextView questionText;
    Button buttonTrue, buttonFalse;
    int[] shownQuestions;
    boolean correctAnswer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        declareVars();

        getNewQuestion(){

        }
    }

    public void declareVars(){
        questionText = findViewById(R.id.textQuestion);
        buttonTrue = findViewById(R.id.buttonTrue);
        buttonFalse = findViewById(R.id.buttonFalse);
    }

    public void optionSelect(View view){
        int viewId = view.getId();
        Intent intent = new Intent(this, ResultsActivity.class);
        if (viewId == buttonTrue.getId()) {
            //Correcto, pasar a ResultsActivity
            intent.putExtra("result", true);
            startActivity(intent);
        } else if (viewId == buttonFalse.getId()) {
            //Incorrecto, pasar a ResultsActivity
            intent.putExtra("result", false);
            startActivity(intent);
        } else { /*error*/ }
    }

    public void checkResult(boolean click){
        //Para expandir mas tarde
    }

    public void getNewQuestion(){
        Random rng = new Random();
        int i = rng.nextInt(10);

    }

    public boolean hasBeenShown(int check){ // Por acabar
        int i = 0;
        boolean feedback = false;
        while(i<shownQuestions.length){
            if(shownQuestions[i] == check) feedback = true;
            i++;
        }

        return feedback;

    }

}
