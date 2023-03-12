package com.example.debatenow_loginandregister;

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

public class Question1 extends AppCompatActivity {
    private TextView questionText;
    private Button choice1;
    private Button choice2;
    private Button choice3;
    private Button choice4;
    private int numCorrect = 0;

    private int correctChoice;

    Button submitbutton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question1);

        questionText = findViewById(R.id.question_text);
        choice1 = findViewById(R.id.answer_a);
        choice2 = findViewById(R.id.answer_b);
        choice3 = findViewById(R.id.answer_c);
        choice4 = findViewById(R.id.answer_d);

        questionText.setText("What is the term used to describe a debate where the opposing sides do not actually address each other's arguments?");
        choice1.setText("Crossfire");
        choice2.setText("Straw man");
        choice3.setText("Ad hominem");
        choice4.setText("Red herring");
        correctChoice = 2; // Paris is the correct answer

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
        Intent intent = new Intent(Question1.this, Question2.class);

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
