package com.humphrey.hellocampus;

import androidx.appcompat.app.AppCompatActivity;
import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class CounterActivity extends AppCompatActivity {

    int mCounter = 0;          //stores the count
    TextView myTextView;
    Button incrementButton;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_counter);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle("Interrupted Counter");
        }

        //Connect UI elements
        myTextView = findViewById(R.id.counterDisplay);
        incrementButton = findViewById(R.id.incrementButton);

        //Increment counter on button click
        incrementButton.setOnClickListener(v -> {
            mCounter++;
            myTextView.setText(String.valueOf(mCounter));
        });
    }

    //Called just before activity is destroyed
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("COUNT_KEY", mCounter);  //save counter
    }

    //Called just after activity is recreated
    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        mCounter = savedInstanceState.getInt("COUNT_KEY");  //restore counter
        myTextView.setText(String.valueOf(mCounter));       //update display
    }
}