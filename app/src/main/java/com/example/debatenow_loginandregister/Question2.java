package com.example.debatenow_loginandregister;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.debatenow_loginandregister.R;

public class Question2 extends AppCompatActivity {
    private TextView questionText;
    private Button choice1;
    private Button choice2;
    private Button choice3;
    private Button choice4;
    private int numCorrect = 0;
    private TextView scoreText;

    private int correctChoice;

    Button submitbutton;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question2);
        scoreText = findViewById(R.id.score_text);

        // Retrieve the numCorrect value from the intent
        numCorrect = getIntent().getIntExtra("numCorrect", numCorrect);

        // Display the value in the TextView
        scoreText.setText("Your score: " + numCorrect);

        questionText = findViewById(R.id.question_text);
        choice1 = findViewById(R.id.answer_a);
        choice2 = findViewById(R.id.answer_b);
        choice3 = findViewById(R.id.answer_c);
        choice4 = findViewById(R.id.answer_d);

        questionText.setText("Which of the following is NOT a commonly used debate format??");
        choice1.setText("Lincoln-Douglas");
        choice2.setText("Oxford");
        choice3.setText("Parliamentary");
        choice4.setText("Flat Earth");
        correctChoice = 4; // Paris is the correct answer

        choice1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showConfirmationDialog(1);
            }
        });

        choice2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showConfirmationDialog(2);
            }
        });

        choice3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showConfirmationDialog(3);
            }
        });

        choice4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showConfirmationDialog(4);
            }
        });
    }

    private void showConfirmationDialog(final int selectedChoice) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Confirm Answer");
        builder.setMessage("Are you sure you want to select this answer?");
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                checkAnswer(selectedChoice);
            }
        });
        builder.setNegativeButton("No", null);
        builder.show();
    }

    private void checkAnswer(int selectedChoice) {
        if (selectedChoice == correctChoice) {
            setBackgroundColor(selectedChoice, Color.GREEN);
            numCorrect++; // increment counter for correct answer
        } else {
            setBackgroundColor(selectedChoice, Color.RED);
            setBackgroundColor(correctChoice, Color.GREEN);
            if (correctChoice == 1) {
                choice1.setBackgroundColor(Color.GREEN);
            } else if (correctChoice == 2) {
                choice2.setBackgroundColor(Color.GREEN);
            } else if (correctChoice == 3) {
                choice3.setBackgroundColor(Color.GREEN);
            } else {
                choice4.setBackgroundColor(Color.GREEN);
            }
        }
        // Create intent for next activity
        Intent intent = new Intent(Question2.this, Question3.class);

        // Pass numCorrect as an extra to the next activity
        intent.putExtra("numCorrect", numCorrect);

        // Start the next activity
        startActivity(intent);
    }


    private void setBackgroundColor(int choice, int color) {
        switch (choice) {
            case 1:
                choice1.setBackgroundColor(color);
                break;
            case 2:
                choice2.setBackgroundColor(color);
                break;
            case 3:
                choice3.setBackgroundColor(color);
                break;
            case 4:
                choice4.setBackgroundColor(color);
                break;
        }
    }
}
