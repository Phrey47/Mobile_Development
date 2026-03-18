package com.humphrey.mycalculator;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

public class MainActivity extends AppCompatActivity {

    // ── Variables ──
    TextView tvDisplay;
    Button btn0, btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9;
    Button btnAdd, btnSub, btnMul, btnDiv;
    Button btnEquals, btnClear, btnDot, btnPlusMinus, btnCustom;
    ConstraintLayout mainLayout;
    ScrollView scrollHistory;
    LinearLayout historyContainer;

    double operandA = 0;
    double operandB = 0;
    String operator = "";
    boolean justCalculated = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // ── Link XML to Java ──
        tvDisplay        = findViewById(R.id.tvDisplay);
        mainLayout       = findViewById(R.id.mainLayout);
        scrollHistory    = findViewById(R.id.scrollHistory);
        historyContainer = findViewById(R.id.historyContainer);

        btn0         = findViewById(R.id.btn0);
        btn1         = findViewById(R.id.btn1);
        btn2         = findViewById(R.id.btn2);
        btn3         = findViewById(R.id.btn3);
        btn4         = findViewById(R.id.btn4);
        btn5         = findViewById(R.id.btn5);
        btn6         = findViewById(R.id.btn6);
        btn7         = findViewById(R.id.btn7);
        btn8         = findViewById(R.id.btn8);
        btn9         = findViewById(R.id.btn9);

        btnAdd       = findViewById(R.id.btnAdd);
        btnSub       = findViewById(R.id.btnSub);
        btnMul       = findViewById(R.id.btnMul);
        btnDiv       = findViewById(R.id.btnDiv);

        btnEquals    = findViewById(R.id.btnEquals);
        btnClear     = findViewById(R.id.btnClear);
        btnDot       = findViewById(R.id.btnDot);
        btnPlusMinus = findViewById(R.id.btnPlusMinus);
        btnCustom    = findViewById(R.id.btnCustom);

        // ── Restore state if app was backgrounded ──
//        if (savedInstanceState != null) {
//            operandA       = savedInstanceState.getDouble("operandA");
//            operandB       = savedInstanceState.getDouble("operandB");
//            operator       = savedInstanceState.getString("operator");
//            justCalculated = savedInstanceState.getBoolean("justCalculated");
//            tvDisplay.setText(savedInstanceState.getString("display"));
//        }

        // ── Number button listeners ──
        btn0.setOnClickListener(v -> appendToDisplay("0"));
        btn1.setOnClickListener(v -> appendToDisplay("1"));
        btn2.setOnClickListener(v -> appendToDisplay("2"));
        btn3.setOnClickListener(v -> appendToDisplay("3"));
        btn4.setOnClickListener(v -> appendToDisplay("4"));
        btn5.setOnClickListener(v -> appendToDisplay("5"));
        btn6.setOnClickListener(v -> appendToDisplay("6"));
        btn7.setOnClickListener(v -> appendToDisplay("7"));
        btn8.setOnClickListener(v -> appendToDisplay("8"));
        btn9.setOnClickListener(v -> appendToDisplay("9"));

        // ── Operator button listeners ──
        btnAdd.setOnClickListener(v -> setOperator("+"));
        btnSub.setOnClickListener(v -> setOperator("-"));
        btnMul.setOnClickListener(v -> setOperator("*"));
        btnDiv.setOnClickListener(v -> setOperator("/"));

        // ── Action button listeners ──
        btnEquals.setOnClickListener(v    -> computeResult());
        btnClear.setOnClickListener(v     -> clearDisplay());
        btnDot.setOnClickListener(v       -> appendDot());
        btnPlusMinus.setOnClickListener(v -> toggleSign());
        btnCustom.setOnClickListener(v    -> applyCustomOperator());
    }

    // ════════════════════════════════════════
    //  HELPER METHODS
    // ════════════════════════════════════════

    private void appendToDisplay(String value) {
        String current = tvDisplay.getText().toString();
        if (justCalculated) {
            tvDisplay.setText(value);
            justCalculated = false;
            return;
        }
        if (current.equals("0")) {
            tvDisplay.setText(value);
        } else {
            tvDisplay.setText(current + value);
        }
    }

    private void appendDot() {
        String current = tvDisplay.getText().toString();
        if (!current.contains(".")) {
            tvDisplay.setText(current + ".");
        }
    }

    private void toggleSign() {
        String current = tvDisplay.getText().toString();
        try {
            double value = Double.parseDouble(current);
            value = value * -1;
            tvDisplay.setText(formatResult(value));
        } catch (NumberFormatException e) {
            // do nothing if display shows an error
        }
    }

    private void setOperator(String op) {
        try {
            operandA = Double.parseDouble(tvDisplay.getText().toString());
            operator = op;
            justCalculated = false;
            tvDisplay.setText("0");
        } catch (NumberFormatException e) {
            tvDisplay.setText("Error");
        }
    }

    private void computeResult() {
        if (operator.isEmpty()) return;

        try {
            operandB = Double.parseDouble(tvDisplay.getText().toString());
        } catch (NumberFormatException e) {
            tvDisplay.setText("Error");
            return;
        }

        double result = 0;

        switch (operator) {
            case "+": result = operandA + operandB; break;
            case "-": result = operandA - operandB; break;
            case "*": result = operandA * operandB; break;
            case "/":
                if (operandB == 0) {
                    tvDisplay.setText("Error");
                    operator = "";
                    return;
                }
                result = operandA / operandB;
                break;
        }

        // ── Log to history ──
        String operatorSymbol;
        switch (operator) {
            case "+": operatorSymbol = "+"; break;
            case "-": operatorSymbol = "−"; break;
            case "*": operatorSymbol = "×"; break;
            case "/": operatorSymbol = "÷"; break;
            default:  operatorSymbol = operator;
        }
        addToHistory(formatResult(operandA) + " " + operatorSymbol + " " + formatResult(operandB) + " = " + formatResult(result));

        tvDisplay.setText(formatResult(result));
        operator = "";
        justCalculated = true;
    }

    private void clearDisplay() {
        tvDisplay.setText("0");
        operandA = 0;
        operandB = 0;
        operator = "";
        justCalculated = false;
    }

    private void applyCustomOperator() {
        // First 3 digits of Student ID added to input
        // Example: ID starts with 230 → adds 230 to current number
        try {
            double current = Double.parseDouble(tvDisplay.getText().toString());
            double idValue = 230; // ← replace 303 with YOUR first 3 digits
            double result = current + idValue;
            addToHistory(formatResult(current) + " + ID(" + (int)idValue + ") = " + formatResult(result));
            tvDisplay.setText(formatResult(result));
        } catch (NumberFormatException e) {
            tvDisplay.setText("Error");
        }
    }

    private void addToHistory(String entry) {
        TextView historyEntry = new TextView(this);
        historyEntry.setText(entry);
        historyEntry.setTextColor(Color.parseColor("#FFD6A5"));
        historyEntry.setTextSize(18f);
        historyEntry.setGravity(android.view.Gravity.END);
        historyEntry.setPadding(0, 4, 8, 4);
        historyContainer.addView(historyEntry);
        scrollHistory.post(() -> scrollHistory.fullScroll(ScrollView.FOCUS_DOWN));
    }

    private String formatResult(double value) {
        if (value == (long) value) {
            return String.valueOf((long) value);
        } else {
            return String.valueOf(value);
        }
    }

    // ════════════════════════════════════════
    //  STATE PRESERVATION (Milestone 3)
    // ════════════════════════════════════════

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putDouble("operandA", operandA);
        outState.putDouble("operandB", operandB);
        outState.putString("operator", operator);
        outState.putBoolean("justCalculated", justCalculated);
        outState.putString("display", tvDisplay.getText().toString());
    }

    @Override
    public void onConfigurationChanged(android.content.res.Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        // activity is NOT recreated on rotation
        // display stays as-is automatically
    }

} // ── end of class ──