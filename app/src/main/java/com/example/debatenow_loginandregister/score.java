package com.example.debatenow_loginandregister;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class score extends AppCompatActivity {

    private TextView scoreText;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);

        // Retrieve the numCorrect value from the intent
        int numCorrect = getIntent().getIntExtra("numCorrect", 0);

        // Display the value in the TextView
        scoreText = findViewById(R.id.score_text);
        scoreText.setText("Your score: " + numCorrect);
    }
}