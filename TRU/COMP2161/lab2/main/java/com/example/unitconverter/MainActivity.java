/*
 * Name: Tanner Watmough
 * Student ID: T00712721
 * Date: October 11, 2022
 *
 * Android Studio Version: 2021.2.1 Patch 2 Chipmunk
 * Program Name: Unit Converter
 * Program Purpose: Converts user inputted numbers between Fahrenheit and Celsius (and vice versa)
 * Version 1.0
 *
 * References
 * https://www.youtube.com/watch?v=NWzbIIZ2Tno
 * https://stackoverflow.com/questions/24008347/two-spinners-in-one-activity-in-android
 * https://stackoverflow.com/questions/47130073/exponential-to-decimal-java-android
 * https://stackoverflow.com/questions/9133937/android-emulator-insert-negative-number#:~:text=Just%20press%20%27%2D%27%20before%20you,%3D%22numberDecimal%7CnumberSigned%22%20.
 *
 * This is the first program I've written at TRU so I wasn't sure of documentation requirements.
 * Please let me know if you need additional information documented in my future programs. For
 * testing, I've included a video of me doing a test run of the application in an Android emulator.
 */

// Packages and imported classes
package com.example.unitconverter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.text.DecimalFormat;
import java.util.ArrayList;

// Main
public class MainActivity extends AppCompatActivity {
    // Variables
    private EditText input_value;
    private TextView result;
    private Button convert;
    // Spinner Variables
    private Spinner temp1;
    private Spinner temp2;
    private ArrayList<String> tempChoice;
    private ArrayAdapter<String> adapter;
    private int userChoice1, userChoice2;
    // Edgecase Variables
    private String period = ".";
    private String negative = "-";
    private String negativePeriod = "-.";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Mapping widgets and app elements to variables
        input_value = (EditText) findViewById(R.id.editTextNumberDecimal2);
        result = (TextView) findViewById(R.id.textView5);
        convert = (Button) findViewById(R.id.button2);
        temp1 = findViewById(R.id.spinner3);
        temp2 = findViewById(R.id.spinner4);

        // Spinner drop down item creation
        tempChoice = new ArrayList<>();
        populateSpinner();

        // Spinner layout setup
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, tempChoice);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        temp1.setAdapter(adapter);
        temp2.setAdapter(adapter);
        // Spinner Listeners to determine which unit conversion is done
        // Spinner 1
        temp1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int i, long l) {
                userChoice1 = i;
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        // Spinner 2
        temp2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                userChoice2 = i;
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        // Convert button listener
        convert.setOnClickListener((view) -> {
            /*
             * This covers edgecases that crash the app including no number entered,
             *  entering just a decimal, a negative sign, or a negative and a decimal.
             * It will then show a toast message to please enter a number.
             */
            if (input_value.getText().toString().isEmpty() ||
                    input_value.getText().toString().equals(period) ||
                    input_value.getText().toString().equals(negative) ||
                    input_value.getText().toString().equals(negativePeriod)) {
                Toast.makeText(getBaseContext(), "Please enter a number!",
                        Toast.LENGTH_SHORT).show();
            } else {
                // Main Logic - Temperature Converter
                // Calculation variables
                double tempResult = 0;
                String tempUnit = " Null";
                Boolean sameUnit = false;

                // Gets entered value and converts it to a double.
                double userTemp = Double.valueOf(input_value.getText().toString());

                // Decimal formatters for small and large numbers.
                DecimalFormat df1 = new DecimalFormat("0.00");
                DecimalFormat df2 = new DecimalFormat("0.0000E0");

                // Checks what the spinner values are set as to determine which calculation to do
                if (userChoice1 == 0 && userChoice2 == 1) {
                    // Fahrenheit to Celsius conversion
                    tempResult = (userTemp - 32) * 5/9;
                    // Displays Celsius after the temperature in results
                    tempUnit = " Celsius";
                } else if (userChoice1 == 1 && userChoice2 == 0) {
                    // Celsius to Fahrenheit conversion
                    tempResult = (userTemp * 9/5) + 32;
                    // Displays Fahrenheit after the temperature in results
                    tempUnit = " Fahrenheit";
                } else {
                    /*
                     * Sets sameUnits to true if both spinners are set to the same value. This
                     * logic would need to be updated if you add more spinner conversion options
                     */

                    sameUnit = true;
                }
                // Display results
                if (sameUnit) {
                    // Same unit error message
                    Toast.makeText(getBaseContext(),
                            "The 'From' and 'To' Units Cannot Be The Same",
                            Toast.LENGTH_SHORT).show();
                    // Set text to null to mimic demo video
                    result.setText("Null");
                } else if (tempResult > 90000000) {
                    // Use large number decimal formatter to avoid unreadable conversions.
                    String output = df2.format(tempResult) + tempUnit;
                    result.setText(output);
                } else {
                    // Use normal decimal formatter for more realistic conversions.
                    String output = df1.format(tempResult) + tempUnit;
                    result.setText(output);
                }
            }
        });
    }
    // Spinner drop down item creator method
    public void populateSpinner() {
        tempChoice.add("Fahrenheit");
        tempChoice.add("Celsius");
    }
}