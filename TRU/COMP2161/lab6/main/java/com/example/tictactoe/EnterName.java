package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

// Emter Name Activity
public class EnterName extends AppCompatActivity {
    // Variables
    private TextView name1TxtView, name2TxtView;
    private EditText name1EditText, name2EditText;
    private Button saveButton;
    protected SharedPreferences sharedPreferences;
    private static final String KEY_NAME1 = "name1_key";
    private static final String KEY_NAME2 = "name2_key";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enter_name);

        // Gets the two name text fields and two edit fields
        name1TxtView = (TextView) findViewById(R.id.enterNameTxtView);
        name2TxtView = (TextView) findViewById(R.id.enterName2TxtView);
        name1EditText = (EditText) findViewById(R.id.enterName1EditText);
        name2EditText = (EditText) findViewById(R.id.enterName2EditText);

        // Finds saveButton and creates sharedPreferences
        saveButton = (Button) findViewById(R.id.saveBtn);
        sharedPreferences = getSharedPreferences("NamePrefs", MODE_PRIVATE);

        // When Save is pressed, it sets the text views to what was in edit text and runs saveData();
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                name1TxtView.setText(name1EditText.getText().toString());
                name2TxtView.setText(name2EditText.getText().toString());
                saveData();
            }
        });

        // If there is a save state get the saved instance string and set text view
        if (savedInstanceState != null) {
            String savedName1 = savedInstanceState.getString(KEY_NAME1);
            name1TxtView.setText(savedName1);

            String savedName2 = savedInstanceState.getString(KEY_NAME2);
            name2TxtView.setText(savedName2);
        } else {
            // If there is no save state, add a new entry
            Toast.makeText(this, "New entry", Toast.LENGTH_SHORT).show();
        }
    }

    // Opens SharedPreferences ediot to put in the two name strings in and commits them.
    public void saveData() {
        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putString("name1", name1TxtView.getText().toString());
        editor.putString("name2", name2TxtView.getText().toString());
        editor.commit();
        Toast.makeText(this, "Information Saved", Toast.LENGTH_SHORT).show();

        // Clears Edit Text fields
        name1EditText.setText("");
        name2EditText.setText("");
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        // Ensures names don't disappear when changing orientation
        savedInstanceState.putString(KEY_NAME1, name1TxtView.getText().toString());
        savedInstanceState.putString(KEY_NAME2, name2TxtView.getText().toString());

        super.onSaveInstanceState(savedInstanceState);
    }
}