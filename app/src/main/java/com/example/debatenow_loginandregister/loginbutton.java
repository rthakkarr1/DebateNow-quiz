package com.example.debatenow_loginandregister;

        import androidx.appcompat.app.AppCompatActivity;

        import android.content.Intent;
        import android.os.Bundle;
        import android.text.TextUtils;
        import android.util.Patterns;
        import android.view.View;
        import android.widget.Button;

public class loginbutton extends AppCompatActivity {
    Button letsgo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loginbutton);
        Button letsgoButton = findViewById(R.id.letsgo);
        letsgoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    Intent registerIntent = new Intent(loginbutton.this, com.example.debatenow_loginandregister.Question1.class);
                    startActivity(registerIntent);
            }
        });
}
}
