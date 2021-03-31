package com.example.csc250_diceroller;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Calendar;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private TextView qtyTV;
    private TextView selectedDieTV;
    private String currentQtyText;
    private TextView outputTV;
    private TextView totalTV;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.qtyTV = this.findViewById(R.id.qtyTV);
        this.selectedDieTV = this.findViewById(R.id.selectedDieTV);
        this.qtyTV.setText("");
        this.currentQtyText = "";
        this.outputTV.setText("");
        this.totalTV.setText("");
    }

    private String extractNumberOfSides(String diceType)
    {
     String answer = "";
     for(int i = 1; i < diceType.length(); i++)
     {
         answer += diceType.charAt(i);
     }
     return answer;
    }
    public void onRollButtonPressed(View v)
    {
        int quantity = 1;
        if (this.qtyTV.getText().toString().length() > 0)
        {
            quantity = Integer.parseInt(this.qtyTV.getText().toString());
        }

        String typeOfDice = this.selectedDieTV.getText().toString();
        int numberOfSides = Integer.parseInt(typeOfDice.substring(1));
        String qtyString = this.qtyTV.getText().toString();
        int qtyInt = Integer.parseInt(qtyString);
        int[] theRolls = new int[qtyInt];
        int sum = 0;
        String outputString = "";
        String fullDiceString = this.selectedDieTV.getText().toString();
        String trimmedDiceString = this.extractNumberOfSides(fullDiceString);
        int numberOfSidesInt = Integer.parseInt(trimmedDiceString);
        Random r = new Random();
        for (int i = 0; i < theRolls.length; i++)
        {
            sum += theRolls[i];
            if(outputString.length() == 0)
            {
                outputString += theRolls[i];
            }
            else
            {
                outputString += "+ " + theRolls[i];
            }
        }
        this.outputTV.setText(outputString);
        this.totalTV.setText("" + sum);


    }

    public void diceButtonPressed(View v)
    {
        this.selectedDieTV.setText(v.getTag().toString());
    }

    public void clearButtonPressed(View v)
    {
        this.currentQtyText = "";
        this.qtyTV.setText(this.currentQtyText);
    }

    public void qtyButtonPressed(View v)
    {
        Button b = (Button)v;

        if(this.currentQtyText.length() == 0 && b.getText().equals("0"))
        {
            return;
        }
        this.currentQtyText += b.getText();
        this.qtyTV.setText(this.currentQtyText);

    }
}
