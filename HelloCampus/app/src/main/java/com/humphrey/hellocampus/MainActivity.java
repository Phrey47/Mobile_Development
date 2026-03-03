package com.humphrey.hellocampus;

import androidx.appcompat.app.AppCompatActivity;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView messageText;
    Button greetButton;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Action Bar
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle("ID: 12345678");
        }

        //Part 1 - Hello Campus
        messageText = findViewById(R.id.messageText);
        greetButton = findViewById(R.id.greetButton);
        greetButton.setOnClickListener(v -> messageText.setText("Chairwoman: Wonder Woman"));

        //Part 2 - Open Counter Activity
        Button openCounterButton = findViewById(R.id.openCounterButton);
        openCounterButton.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, CounterActivity.class);
            startActivity(intent);
        });
    }
}