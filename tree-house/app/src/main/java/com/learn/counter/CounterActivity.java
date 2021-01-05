package com.learn.counter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class CounterActivity extends AppCompatActivity {

    final int oneIncrement = 1;

    private TextView counterText;
    private Button counterButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_counter);

        counterText = findViewById(R.id.counterText);
        counterButton = findViewById(R.id.counterButton);

        counterButton.setOnClickListener(button -> {
            final int currentNumber = getCurrentNumber();
            final String newCounterTextValue = convertNumberToString(currentNumber + oneIncrement);

            counterText.setText(newCounterTextValue);

        });
    }

    private int getCurrentNumber() {
        return Integer.parseInt(String.valueOf(counterText.getText()));
    }

    private String convertNumberToString(int number) {
        return String.valueOf(number);
    }
}