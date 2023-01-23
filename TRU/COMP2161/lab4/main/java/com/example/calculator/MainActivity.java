/* App Name: Calculator
 * Purpose: Simple Calculator App
 * Class: Mobile Applications
 * Name: Tanner Watmough
 * Date: November 14, 2022
 */

package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.icu.text.NumberFormat;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;

import java.text.DecimalFormat;
import java.util.concurrent.TimeUnit;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    // Initalize textviews and buttons
    TextView resultScreen, solutionScreen;

    MaterialButton buttonC, buttonCE, buttonExponent, buttonDivision, buttonSeven, buttonEight,
            buttonNine, buttonMultiply, buttonFour, buttonFive, buttonSix, buttonSubtract, buttonOne,
            buttonTwo, buttonThree, buttonAdd, buttonPM, buttonZero, buttonDecimal, buttonEquals;

    String lastButton = "";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        resultScreen = findViewById(R.id.result_screen);
        solutionScreen = findViewById(R.id.solutions_screen);


        // creates buttons for screen
        buttonId(buttonC,R.id.button_c);
        buttonId(buttonCE,R.id.button_ce);
        buttonId(buttonExponent,R.id.button_exp2);
        buttonId(buttonDivision,R.id.button_division);
        buttonId(buttonSeven,R.id.button_seven);
        buttonId(buttonEight,R.id.button_eight);
        buttonId(buttonNine,R.id.button_nine);
        buttonId(buttonMultiply,R.id.button_multiply);
        buttonId(buttonFour,R.id.button_four);
        buttonId(buttonFive,R.id.button_five);
        buttonId(buttonSix,R.id.button_six);
        buttonId(buttonSubtract,R.id.button_subtract);
        buttonId(buttonOne,R.id.button_one);
        buttonId(buttonTwo,R.id.button_two);
        buttonId(buttonThree,R.id.button_three);
        buttonId(buttonAdd,R.id.button_addition);
        buttonId(buttonPM,R.id.button_plus_minus);
        buttonId(buttonZero,R.id.button_zero);
        buttonId(buttonDecimal,R.id.button_decimal);
        buttonId(buttonEquals,R.id.button_equals);


        // Flash welcome message
        Toast.makeText(getBaseContext(),"Welcome to Tanner's Calculator!", Toast.LENGTH_LONG).show();
    }

    void buttonId(MaterialButton btn, int id) {
        btn = findViewById(id);
        btn.setOnClickListener(this);
    }




    @Override
    public void onClick(View view) {

        MaterialButton button = (MaterialButton) view;
        String buttonText = button.getText().toString();
        String dataCalculation = resultScreen.getText().toString();


        // If CE or Clear Everything is pressed, or 0/0 is divided, reset app.
        if (buttonText.equals("CE") || lastButton.equals("Undefined")) {
            solutionScreen.setText("");
            resultScreen.setText("0");
            setLastButton("CE");
            return;
        }

        // If = is pressed, evaluates expression.
        if (buttonText.equals("=")) {
            if (solutionScreen.getText().equals("")) {
                resultScreen.setText(resultScreen.getText());
            }
            String prevResult = (String) resultScreen.getText();
            resultScreen.setText(solutionScreen.getText() + prevResult);
            String calculation = (String) resultScreen.getText();

            // Removes added spaces to better parse
            calculation = calculation.replace(" ", "");

            String parsedDbl = "";
            String operator = "";
            String result = "";
            double aggregate = 0;
            // Calculation loop
            for (int i = 0; i < calculation.length(); i++) {
                char c = calculation.charAt(i);
                if (Character.isDigit(c)) {
                    parsedDbl += c;
                }
                if (!Character.isDigit(c) || i == calculation.length() - 1) {
                    double parsed = Double.parseDouble(parsedDbl);
                    if (operator == "") {
                        aggregate = parsed;
                    } else {
                        // Addition
                        if (operator.equals("+")) {
                            aggregate += parsed;
                        } else if (operator.equals("-")) { // Subtraction
                            aggregate -= parsed;
                        } else if (operator.equals("x")) { // Multiplication
                            aggregate *= parsed;
                        } else if (operator.equals("/")) { // Division
                            if (parsed == 0) {             // If 0 is divided by 0
                                result = "Undefined";
                                resultScreen.setText(result);
                                setLastButton("Undefined");
                                return;
                            } else {
                                aggregate /= parsed;
                            }

                        } else if (operator.equals("^2")) { // power function
                            aggregate = Math.pow(parsed, 2);
                        }
                    }

                    parsedDbl = "";
                    operator = "" + c;
                }
            }
            // Set solution screen (top) to calculation with an =
            solutionScreen.setText(calculation + "=");


            // Test functions to see if calculation and evaluation working correctly
            System.out.println(calculation);
            System.out.println(aggregate);

            // Formats output to two decimal points
            result = String.format("%5.2f", aggregate);

            // Puts calculated expression into results screen (bottom area)
            resultScreen.setText(result);

            // Keeps track of the last button pressed
            setLastButton("=");

            return;
        }

        // The following will move resultScreen text to solutionScreen and add appropriate
        // expression symbol
        if (buttonText.equals("/")) {
            setLastButton(("/"));
            dataCalculation = dataCalculation + buttonText;
            String prevSolution = (String) solutionScreen.getText();
            solutionScreen.setText(prevSolution + resultScreen.getText() + " / ");
            resultScreen.setText("0");
            return;
        }

        if (buttonText.equals("x")) {
            setLastButton(("x"));
            dataCalculation = dataCalculation + buttonText;
            String prevSolution = (String) solutionScreen.getText();
            solutionScreen.setText(prevSolution + resultScreen.getText() + " x ");
            resultScreen.setText("0");
            return;
        }

        if (buttonText.equals("-")) {
            setLastButton(("-"));
            dataCalculation = dataCalculation + buttonText;
            String prevSolution = (String) solutionScreen.getText();
            solutionScreen.setText(prevSolution + resultScreen.getText() + " - ");
            resultScreen.setText("0");
            return;
        }

        if (buttonText.equals("+")) {
            setLastButton(("+"));
            dataCalculation = dataCalculation + buttonText;
            String prevSolution = (String) solutionScreen.getText();
            solutionScreen.setText(prevSolution + resultScreen.getText() + " + ");
            resultScreen.setText("0");
            return;
        }

        if (buttonText.equals("^2")) {
            setLastButton(("^2"));
            dataCalculation = dataCalculation + buttonText;
            String prevSolution = (String) solutionScreen.getText();
            solutionScreen.setText(prevSolution + resultScreen.getText() + "^2");
            resultScreen.setText("0");
            return;
        }

        // Backspace button essentially
        if (buttonText.equals("C")) {
            setLastButton(("C"));
            System.out.println("C pressed");
            if (dataCalculation.length() > 1) {
                dataCalculation = dataCalculation.substring(0, dataCalculation.length() - 1);
            } else if (dataCalculation.length() == 1) {
                dataCalculation = "0";
            }
        } else {
            if (resultScreen.length() <= 1) {
                dataCalculation = " " + buttonText;

            } else {
                dataCalculation = dataCalculation + buttonText;
            }
        }

        resultScreen.setText(dataCalculation);

        // If = was last button and next button pressed is a number, it will reset Solution and
        // Result screens
        if (buttonText.equals("0") || buttonText.equals("1")|| buttonText.equals("2") ||
                buttonText.equals("3") || buttonText.equals("4") || buttonText.equals("5") ||
                buttonText.equals("6") || buttonText.equals("7") || buttonText.equals("8") ||
                buttonText.equals("9") || buttonText.equals(".")){
            lastButton = getLastButton();

            if (lastButton.equals("=")) {
                dataCalculation = " " + buttonText;
                solutionScreen.setText("");
                resultScreen.setText(dataCalculation);
                setLastButton("");
                return;
            } else {
                resultScreen.setText(dataCalculation);
            }
        }

    }

    // Set and getter for lastButton
    private void setLastButton(String s) {
        lastButton = s;
    }

    private String getLastButton() {
        return lastButton;
    }

}