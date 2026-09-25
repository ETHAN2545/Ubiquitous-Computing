package com.example.guessinggame;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    int secretNumber;
    int numberOfGuesses;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        startGame();
    }

    public void startGame() {
        Random random = new Random();
        secretNumber = random.nextInt(30) + 1;
        numberOfGuesses = 0;
    }

    public void guessButton_click(View view) {
        EditText editText = (EditText) findViewById(R.id.guess);
        TextView result = (TextView) findViewById(R.id.result);
        TextView guesses = (TextView) findViewById(R.id.numberOfGuesses);
        int guess = Integer.parseInt(editText.getText().toString());
        numberOfGuesses++;
        guesses.setText(("Number of guesses: " + numberOfGuesses));

        if (guess == secretNumber) {
            result.setText("Correct! You guessed the number!");
        } else if (guess < secretNumber) {
            result.setText("The number is higher!");
        } else {
            result.setText("The number is lower!");
        }
    }

    public void playAgain_click(View view) {
        startGame();
        EditText editText = (EditText) findViewById(R.id.guess);
        TextView result = (TextView) findViewById(R.id.result);
        TextView guesses = (TextView) findViewById(R.id.numberOfGuesses);
        editText.setText("");
        result.setText("Make a guess!");
        guesses.setText("Number of guesses: 0");
    }
}