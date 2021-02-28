package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.github.ayaanqui.expressionresolver.Resolver;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    //Calculator Buttons
    Button buttonDot;
    Button button0;
    Button buttonPi;
    Button buttonPlus;
    Button buttonEqual;
    Button button1;
    Button button2;
    Button button3;
    Button buttonMinus;
    Button buttonClear;
    Button button4;
    Button button5;
    Button button6;
    Button buttonMultiply;
    Button buttonParentheses;
    Button button7;
    Button button8;
    Button button9;
    Button buttonDivide;
    Button buttonLn;
    Button buttonSqrt;
    Button buttonExponent;
    Button buttonFactorial;
    Button buttonSin;
    Button buttonCos;

    //Calculator textViews
    TextView equation;
    TextView result;
    ImageButton buttonBackspace;

    //Variables of equation
    String display;
    double problem;
    DecimalFormat decimalFormat = new DecimalFormat("0.00");

    //Resolver for equation
    Resolver resolver;

    //backPress Timer
    long backPressedTime;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Initialize buttons
        buttonDot = findViewById(R.id.buttonDot);
        button0 = findViewById(R.id.button0);
        buttonPi = findViewById(R.id.buttonPi);
        buttonPlus = findViewById(R.id.buttonPlus);
        buttonEqual = findViewById(R.id.buttonEqual);
        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);
        buttonMinus = findViewById(R.id.buttonMinus);
        buttonClear = findViewById(R.id.buttonClear);
        button4 = findViewById(R.id.button4);
        button5 = findViewById(R.id.button5);
        button6 = findViewById(R.id.button6);
        buttonMultiply = findViewById(R.id.buttonMultiply);
        buttonParentheses = findViewById(R.id.buttonParentheses);
        button7 = findViewById(R.id.button7);
        button8 = findViewById(R.id.button8);
        button9 = findViewById(R.id.button9);
        buttonDivide = findViewById(R.id.buttonDivide);
        buttonSqrt = findViewById(R.id.buttonSqrt);
        buttonExponent = findViewById(R.id.buttonExponent);
        buttonFactorial = findViewById(R.id.buttonFactorial);
        buttonLn = findViewById(R.id.buttonLn);
        buttonSin = findViewById(R.id.buttonSin);
        buttonCos = findViewById(R.id.buttonCos);
        buttonBackspace = findViewById(R.id.buttonBackspace);

        //Initialize textViews
        equation = findViewById(R.id.textViewEquation);
        result = findViewById(R.id.textViewResult);

        //Initialize variables
        display = "";
        problem = 0;

        //Initialize resolver
        resolver = new Resolver();

        //OnClickMethods of buttons
        onClickMethods();

    }

    @SuppressLint("SetTextI18n")
    private void onClickMethods() {

        buttonDot.setOnClickListener(v -> {
            display += ".";
            equation.setText(display);
            result.setText(null);
        });

        button0.setOnClickListener(v -> {
            display += "0";
            equation.setText(display);
            result.setText(null);
        });

        buttonPi.setOnClickListener(v -> {
            display += "pi";
            equation.setText(display);
            result.setText(null);
        });

        buttonPlus.setOnClickListener(v -> {
            display += "+";
            equation.setText(display);
            result.setText(null);
        });

        buttonEqual.setOnClickListener(v -> {
            problem = resolver.setExpression(display.replace("÷", "/")).solveExpression().result;
            if ((problem == Math.floor(problem)) && !Double.isInfinite(problem))
                result.setText(String.valueOf((int) Math.round(problem)));
            else
                result.setText(Double.toString(Double.parseDouble(decimalFormat.format(problem))));
        });

        button1.setOnClickListener(v -> {
            display += "1";
            equation.setText(display);
            result.setText(null);
        });

        button2.setOnClickListener(v -> {
            display += "2";
            equation.setText(display);
            result.setText(null);
        });

        button3.setOnClickListener(v -> {
            display += "3";
            equation.setText(display);
            result.setText(null);
        });

        buttonMinus.setOnClickListener(v -> {
            display += "-";
            equation.setText(display);
            result.setText(null);
        });
        buttonClear.setOnClickListener(v -> {
            display = "";
            equation.setText(display);
            result.setText(display);
        });

        button4.setOnClickListener(v -> {
            display += "4";
            equation.setText(display);
            result.setText(null);
        });

        button5.setOnClickListener(v -> {
            display += "5";
            equation.setText(display);
            result.setText(null);
        });
        button6.setOnClickListener(v -> {
            display += "6";
            equation.setText(display);
            result.setText(null);
        });

        buttonMultiply.setOnClickListener(v -> {
            display += "*";
            equation.setText(display);
            result.setText(null);
        });

        buttonParentheses.setOnClickListener(v -> {
            int open = 0;
            int closed = 0;

            for (int i = 0; i < display.length(); i++) {
                if (display.startsWith("(", i)) open++;
                if (display.startsWith(")", i)) closed++;
            }
            System.out.println("Open: " + open);
            System.out.println("Close: " + closed);

            if (open == closed || display.endsWith("("))
                display += "(";
            else if (open > closed && !display.substring(display.length() - 1).equals(""))
                display += ")";

            equation.setText(display);
            result.setText(null);
        });

        button7.setOnClickListener(v -> {
            display += "7";
            equation.setText(display);
            result.setText(null);
        });

        button8.setOnClickListener(v -> {
            display += "8";
            equation.setText(display);
            result.setText(null);
        });

        button9.setOnClickListener(v -> {
            display += "9";
            equation.setText(display);
            result.setText(null);
        });

        buttonDivide.setOnClickListener(v -> {
            display += "÷";
            equation.setText(display);
            result.setText(null);
        });

        buttonLn.setOnClickListener(v -> {
            display += "ln(";
            equation.setText(display);
            result.setText(null);
        });

        buttonSqrt.setOnClickListener(v -> {
            display += "sqrt(";
            equation.setText(display);
            result.setText(null);
        });

        buttonExponent.setOnClickListener(v -> {
            display += "^";
            equation.setText(display);
            result.setText(null);
        });

        buttonFactorial.setOnClickListener(v -> {
            display += "fact(";
            equation.setText(display);
            result.setText(null);
        });

        buttonSin.setOnClickListener(v -> {
            display += "sin(";
            equation.setText(display);
            result.setText(null);
        });

        buttonCos.setOnClickListener(v -> {
            display += "cos(";
            equation.setText(display);
            result.setText(null);
        });

        buttonBackspace.setOnClickListener(v -> {
            if (display.length() != 0) {
                display = display.substring(0, display.length() - 1);
                equation.setText(display);
                result.setText(null);
            }
        });

    }

    //If user tries to go back, those operations start
    @Override
    public void onBackPressed() {
        //If user presses backPress again in 2 seconds, application will be closed
        if (backPressedTime + 2000 > System.currentTimeMillis()) {
            super.onBackPressed();
            return;
        }
        //If user presses backPress again after 2 seconds, application will not be closed
        else {
            Toast.makeText(getBaseContext(), "Press back again to exit", Toast.LENGTH_SHORT).show();
        }
        backPressedTime = System.currentTimeMillis();
    }
}