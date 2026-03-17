package com.humphrey.echoapp;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class EchoActivity extends AppCompatActivity {

    private static final String TAG = "EchoActivityLog";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_echo);

        Log.d(TAG, "onCreate: EchoActivity has started.");

        Intent receivedIntent = getIntent();
        String message = receivedIntent.getStringExtra("USER_MESSAGE");

        TextView tvEcho = findViewById(R.id.tvEcho);

        if (message != null && !message.isEmpty()) {
            tvEcho.setText(message);
            Log.d(TAG, "Message received and displayed: " + message);
        } else {
            tvEcho.setText("No message received.");
            Log.d(TAG, "No message was passed to EchoActivity.");
        }
    }
}