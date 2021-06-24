package com.girls.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText editText;
    boolean isNewOp = true;
    String op = "+";
    String oldNumber = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.editText);
    }

    public void numberClick(View view) {
        if (isNewOp) {
            editText.setText("");
        }
        isNewOp = false;

        String number = editText.getText().toString();
        switch (view.getId()) {
            case R.id.btn1:
                number += "1";
                break;
            case R.id.btn2:
                number += "2";
                break;
            case R.id.btn3:
                number += "3";
                break;
            case R.id.btn4:
                number += "4";
                break;
            case R.id.btn5:
                number += "5";
                break;
            case R.id.btn6:
                number += "6";
                break;
            case R.id.btn7:
                number += "7";
                break;
            case R.id.btn8:
                number += "8";
                break;
            case R.id.btn9:
                number += "9";
                break;
            case R.id.btn0:
                number += "0";
                break;
            case R.id.btnDot:
                number += ".";
                break;
            case R.id.btnPlusMinus:
                number = "-" + number;
                break;
        }
        editText.setText(number);
    }

    public void operatorClick(View view) {
        isNewOp = true;
        oldNumber = editText.getText().toString();
        switch (view.getId()) {
            case R.id.btnDivide:
                op = "/";
                break;
            case R.id.btnMultiply:
                op = "*";
                break;
            case R.id.btnPlus:
                op = "+";
                break;
            case R.id.btnMinus:
                op = "-";
                break;
        }
    }

    public void equalClick(View view) {
        String newNumber = editText.getText().toString();
        double result = 0.0;

        switch(op) {
            case "+":
                result = Double.parseDouble(oldNumber) + Double.parseDouble(newNumber);
                break;
            case "-":
                result = Double.parseDouble(oldNumber) - Double.parseDouble(newNumber);
                break;
            case "*":
                result = Double.parseDouble(oldNumber) * Double.parseDouble(newNumber);
                break;
            case "/":
                result = Double.parseDouble(oldNumber) / Double.parseDouble(newNumber);
                break;
        }

        editText.setText(result+"");
    }

    public void percentClick(View view) {
        double no = Double.parseDouble(editText.getText().toString())/100;
        editText.setText(no+"");
        isNewOp = true;
    }

    public void ACClick(View view) {
        editText.setText("0");
        isNewOp = true;
    }
}