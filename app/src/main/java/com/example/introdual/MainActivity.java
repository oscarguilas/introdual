package com.example.introdual;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    //Variables
    TextView questionText;
    Button buttonCorrect, buttonIncorrect;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        declareVars();


    }

    public void declareVars(){
        questionText = findViewById(R.id.textQuestion);
        buttonCorrect = findViewById(R.id.buttonCorrect);
        buttonIncorrect = findViewById(R.id.buttonIncorrect);
    }

    public void optionSelect(View view){
        int viewId = view.getId();
        if (viewId == buttonCorrect.getId()) {
            //Correcto, pasar a ResultsActivity
        } else if (viewId == buttonIncorrect.getId()) {
            //Incorrecto, pasar a ResultsActivity
        } else { /*error*/ }
    }

}
