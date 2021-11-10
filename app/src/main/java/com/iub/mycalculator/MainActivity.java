package com.iub.mycalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    String firstNumber = "0";
    String secondNumber = "0";
    String operator = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void numberOnClick(View view) {
        TextView resultTextView = findViewById(R.id.resultTextView);

        String current = resultTextView.getText().toString();
        String number = "";
        number += current;
        Button button = (Button) view;

        if (number.startsWith("0")) {
            number = button.getText().toString();
        } else {
            number += button.getText().toString();
        }

        resultTextView.setText(number);
    }

    public void operatorOnClick(View view) {
        TextView resultTextView = findViewById(R.id.resultTextView);
        Button button = (Button) view;
        operator = button.getText().toString();
        firstNumber = resultTextView.getText().toString();
        switch (operator) {
            case "+":
                operator = "+";
                break;
            case "-":
                operator = "-";
                break;
            case "X":
                operator = "x";
                break;
            case "/":
                operator = "/";
                break;
        }
        resultTextView.setText("");
    }

    public void equalOnClick(View view) {
        TextView resultTextView = findViewById(R.id.resultTextView);
        secondNumber = resultTextView.getText().toString();
        int number1 = Integer.parseInt(firstNumber);
        int number2 = Integer.parseInt(secondNumber);
        int number3;
        String resultText;
        if (operator.isEmpty()) {
            String emptyOperatorText = resultTextView.getText().toString();
            resultTextView.setText(emptyOperatorText);
        } else if (operator.equals("+")) {
            number3 = number1 + number2;
            resultText = Integer.toString(number3);
            resultTextView.setText(resultText);
        } else if (operator.equals("-")) {
            number3 = number1 - number2;
            resultText = Integer.toString(number3);
            resultTextView.setText(resultText);
        } else if (operator.equals("x")) {
            number3 = number1 * number2;
            resultText = Integer.toString(number3);
            resultTextView.setText(resultText);
        } else if (operator.equals("/")) {
            try {
                number3 = number1 / number2;
            } catch (ArithmeticException e) {
                number3 = 0;
                Toast toast = Toast.makeText(this, "Cannot divide by zero!", Toast.LENGTH_SHORT);
                toast.show();
            }
            resultText = Integer.toString(number3);
            resultTextView.setText(resultText);
        }
    }

    public void clearOnClick(View view) {
        TextView resultTextView = findViewById(R.id.resultTextView);
        resultTextView.setText("0");
        firstNumber = "0";
        secondNumber = "0";
        operator = "";
    }
}