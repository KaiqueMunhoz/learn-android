package com.learn.funfacts;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class FunFactsActivity extends AppCompatActivity {

    private TextView factTextView;
    private Button showFactButton;
    private RelativeLayout funFactRelativeLayout;

    final private FactBook factBook = new FactBook();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fun_facts);

        factTextView = findViewById(R.id.factTextView);
        showFactButton = findViewById(R.id.showFactButton);
        funFactRelativeLayout = findViewById(R.id.funFactRelativeLayout);

        showFactButton.setOnClickListener(button -> {
            final String funFact = factBook.getFact();
            final int color = BackgroundColor.getColor();
            factTextView.setText(funFact);
            funFactRelativeLayout.setBackgroundColor(color);
            showFactButton.setTextColor(color);
        });

    }
}