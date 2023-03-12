package com.example.debatenow_loginandregister;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class LoginActivity extends AppCompatActivity {
    private EditText emailID, password;
    Button loginButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        emailID = findViewById(R.id.email);
        password = findViewById(R.id.pass);
        Button loginButton = findViewById(R.id.login);
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (TextUtils.isEmpty(emailID.getText().toString().trim()) || !Patterns.EMAIL_ADDRESS.matcher(emailID.getText().toString().trim()).matches()) {
                    emailID.setError("Enter a valid email address");
                } else if (TextUtils.isEmpty(password.getText().toString().trim())) {
                    password.setError("Enter a valid password");
                } else {
                    Intent registerIntent = new Intent(LoginActivity.this, loginbutton.class);
                    startActivity(registerIntent);
                }
            }
        });
    }
}
