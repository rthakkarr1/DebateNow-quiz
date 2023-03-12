package com.example.debatenow_loginandregister;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class Register extends AppCompatActivity {

    private EditText firstName, familyName, dateOfBirth, emailID, password;
    Button registerButton;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        firstName = findViewById(R.id.fn);
        familyName = findViewById(R.id.family);
        dateOfBirth = findViewById(R.id.dob);
        emailID = findViewById(R.id.email);
        password = findViewById(R.id.pwd);
        Button registerButton = findViewById(R.id.reg);
//data validation
        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (TextUtils.isEmpty(firstName.getText().toString().trim()) || firstName.getText().toString().trim().length() < 3 || firstName.getText().toString().trim().length() > 30) {
                    firstName.setError("Enter a valid first name (3-30 characters)");
                } else if (TextUtils.isEmpty(familyName.getText().toString().trim())) {
                    familyName.setError("Enter a valid last name");
                } else if (TextUtils.isEmpty(dateOfBirth.getText().toString().trim()) || !dateOfBirth.getText().toString().trim().matches("^(0[1-9]|1[0-2])/(0[1-9]|[12]\\d|3[01])/\\d{4}$")) {
                    dateOfBirth.setError("Enter a valid date of birth. Use MM/DD/YYYY.");
                } else if (TextUtils.isEmpty(emailID.getText().toString().trim()) || !Patterns.EMAIL_ADDRESS.matcher(emailID.getText().toString().trim()).matches()) {
                    emailID.setError("Enter a valid email address");
                } else if (TextUtils.isEmpty(password.getText().toString().trim())) {
                    password.setError("Enter a valid password");
                } else {
                    Intent registerIntent = new Intent(Register.this, LoginActivity.class);
                    startActivity(registerIntent);
                }
            }
        });

    }
    @Override
    public String toString() {
        return "Register{" +
                "firstName=" + firstName.getText().toString().trim() +
                ", familyName=" + familyName.getText().toString().trim() +
                ", dateOfBirth=" + dateOfBirth.getText().toString().trim() +
                ", emailID=" + emailID.getText().toString().trim() +
                ", password=" + password.getText().toString().trim() +
                '}';

    }
}