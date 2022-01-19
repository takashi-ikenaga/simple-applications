package com.example.mybingo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Button;
import android.util.*;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private int maxNumber = 75;
    private int chanceNumber = 50;
    private ArrayList<String> history = new ArrayList<>();

    private EditText maxNumberEditText;

    private Button registerMaxNumberButton;

    private Button nextNumberButton;

    private TextView currentNumberTextView;

    private TextView luckyNumberTextView;

    private TextView historyTextView;

    private TextView luckyyouTextView;

    private  TextView thisluckyTextView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        maxNumberEditText = findViewById(R.id.max_number);
        registerMaxNumberButton = findViewById(R.id.register_max_number);
        maxNumberEditText.setText("" + maxNumber);
        nextNumberButton =findViewById(R.id.next_number);
        currentNumberTextView = findViewById(R.id.current_number);
        historyTextView = findViewById(R.id.history);
        luckyNumberTextView = findViewById(R.id.lucky_number);
        thisluckyTextView = findViewById(R.id.this_lucky);

        registerMaxNumberButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String maxNumberString = maxNumberEditText.getText().toString();

                maxNumber = Integer.valueOf(maxNumberString);
                int luckynumber = createRandomNumber();
                String luckyNumberStr = ""+ luckynumber;
                chanceNumber =Integer.valueOf(luckyNumberStr);
                luckyNumberTextView.setText(luckyNumberStr);

                Log.d("MainActivity", "maxNumber:" + maxNumber);
            }
        });
        nextNumberButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickNextNumber();
            }
        });
    }

    private void onClickNextNumber(){

        Log.d("MainActivity", "onClickNextNumber");

        int nextNumber = createRandomNumber();

        while(history.contains(""+nextNumber)){
            Log.d("MainActivity", "重複したので再生成します");
            nextNumber= createRandomNumber();
        }

        String nextNumberStr = ""+ nextNumber;
        currentNumberTextView.setText(nextNumberStr);
        history.add(nextNumberStr);
        historyTextView.setText(history.toString());

        if(nextNumber == chanceNumber){
            luckyyouTextView = findViewById(R.id.lucky_you);
            String luckyNumberStr = "you are lucky!!" ;
            luckyyouTextView.setText(luckyNumberStr);
        }
        else if(nextNumber != chanceNumber){
            luckyyouTextView = findViewById(R.id.lucky_you);
            String unluckyNumberStr = "";
            luckyyouTextView.setText(unluckyNumberStr);
        }
    }

    private int createRandomNumber(){
        double randomNumber = Math.random() *(maxNumber-1);
        return (int) randomNumber +1;
    }
}