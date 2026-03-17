package com.humphrey.echoapp;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;

public class InputActivity extends AppCompatActivity {

    private static final String TAG = "InputActivityLog";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input);

        Log.d(TAG, "onCreate: InputActivity has started.");

        EditText etMessage = findViewById(R.id.etMessage);
        Button btnSend = findViewById(R.id.btnSend);

        btnSend.setOnClickListener(v -> {
            String message = etMessage.getText().toString();
            Log.d(TAG, "Send button clicked. Message: " + message);

            Intent intent = new Intent(InputActivity.this, EchoActivity.class);
            intent.putExtra("USER_MESSAGE", message);
            startActivity(intent);
        });

    }
}
