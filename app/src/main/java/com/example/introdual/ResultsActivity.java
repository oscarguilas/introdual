package com.example.introdual;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class ResultsActivity extends AppCompatActivity {
    TextView resultsText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);

        resultsText = findViewById(R.id.resultsText);
        Intent formerIntent = getIntent();

        setResultText(formerIntent);
    }

    private void setResultText(Intent intent){
        if(intent.getExtras().getBoolean("result")){
            resultsText.setText(getString(R.string.resultCorrect));
        } else if (!intent.getExtras().getBoolean("result")){
            resultsText.setText(getString(R.string.resultIncorrect));
        }
    }
}
