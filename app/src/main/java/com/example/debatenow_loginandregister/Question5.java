package com.example.debatenow_loginandregister;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Question5 extends AppCompatActivity {

    private TextView questionText;
    private CheckBox choice1;
    private CheckBox choice2;
    private CheckBox choice3;
    private CheckBox choice4;
    private Button submitButton;
    private int numCorrect = 0;
    private TextView scoreText;

    private List<Integer> correctChoices; // Store multiple correct choices

    @SuppressLint({"WrongViewCast", "MissingInflatedId"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question5);

        questionText = findViewById(R.id.question_text);
        choice1 = findViewById(R.id.answer_a);
        choice2 = findViewById(R.id.answer_b);
        choice3 = findViewById(R.id.answer_c);
        choice4 = findViewById(R.id.answer_d);
        submitButton = findViewById(R.id.submit_button);

        questionText.setText("Which of the following are common debate techniques? (Select all that apply)");
        choice1.setText("Ad hominem attacks");
        choice2.setText("Appeal to authority");
        choice3.setText("Slippery slope fallacy");
        choice4.setText("Addressing counterarguments");

        // Set multiple correct choices
        correctChoices = new ArrayList<>();
        correctChoices.add(2); // Appeal to authority
        correctChoices.add(4); // Addressing counterarguments

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer();
            }
        });
    }

    private void checkAnswer() {
        numCorrect = 0;

        // Check each answer and update the score
        if (choice1.isChecked()) {
            setBackgroundColor(1, Color.RED);
        }

        if (choice2.isChecked()) {
            setBackgroundColor(2, correctChoices.contains(2) ? Color.GREEN : Color.RED);
            if (correctChoices.contains(2)) {
                numCorrect++;
            }
        }

        if (choice3.isChecked()) {
            setBackgroundColor(3, Color.RED);
        }

        if (choice4.isChecked()) {
            setBackgroundColor(4, correctChoices.contains(4) ? Color.GREEN : Color.RED);
            if (correctChoices.contains(4)) {
                numCorrect++;
            }
        }

        // Display the score
        scoreText = findViewById(R.id.score_text);
        scoreText.setText("Your score: " + numCorrect);

        // Disable the checkboxes and submit button
        choice1.setEnabled(false);
        choice2.setEnabled(false);
        choice3.setEnabled(false);
        choice4.setEnabled(false);
        submitButton.setEnabled(false);

        // Add an intent to go to the Score activity
        Intent intent = new Intent(Question5.this, score.class);
        intent.putExtra("numCorrect", numCorrect); // Pass the score to the Score activity
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
