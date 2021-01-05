package com.learn.funfacts;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class FunFactsActivity extends AppCompatActivity {

    private TextView factTextView;
    private Button showFactButton;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fun_facts);

        factTextView = findViewById(R.id.factTextView);
        showFactButton = findViewById(R.id.showFactButton);

        showFactButton.setOnClickListener(button -> {
            final String funFact = new FactBook().getFact();
            factTextView.setText(funFact);
        });

    }
}