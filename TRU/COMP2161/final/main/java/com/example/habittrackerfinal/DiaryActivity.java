package com.example.habittrackerfinal;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import java.sql.Array;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class DiaryActivity extends AppCompatActivity {
    // Variables
    private Button addDiaryBtn, diarySaveBtn, diaryDelBtn, diaryEditBtn, editSaveBtn;
    private TextView diaryEditText;
    private LinearLayout editDiaryLayout;
    private ListView diaryList;
    private ArrayList<String> arrayList;
    private ArrayAdapter<String> adapter;
    private Set<String> arraySet;

    protected SharedPreferences sp, sp1;
    private boolean darkmode;
    private String name;

    private boolean viewToggle = false, editToggle;

    private static final String DIARY_ENTRIES = "diary_key";
    private static final String DEL_BTN = "delete_key";
    private static final String EDIT_BTN = "edit_key";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_diary);


        // Finds View Objects
        editDiaryLayout = (LinearLayout) findViewById(R.id.diaryEditText_layout);

        diaryList = (ListView) findViewById(R.id.diaryListView);

        diaryEditText = (TextView) findViewById(R.id.addDiaryEditTextView);

        addDiaryBtn = (Button) findViewById(R.id.addDiaryBtn);
        diarySaveBtn = (Button) findViewById(R.id.saveEntryBtn);
        diaryEditBtn = (Button) findViewById(R.id.editDiaryBtn);
        diaryDelBtn = (Button) findViewById(R.id.delDiaryBtn);
        editSaveBtn = (Button) findViewById(R.id.editSaveBtn);

        // Opens SharedPreferences and gets darkmode value and name.

        sp1 = getApplicationContext().getSharedPreferences("NamePref", Context.MODE_PRIVATE);
        darkmode = sp1.getBoolean("darkmode", false);
        name = sp1.getString("name", "");

        /*
          If name is empty, AKA guest, it creates a new ArrayList each time that is empty,
          effectively making it so the diary entries are cleared. If the name equals "admin"
          it will create a new array list but put in the string set which will restore previous
          entries.
         */
        if (name.equals("")) {
            arrayList = new ArrayList<>();
        } else if (name.equals("admin")) {
            arrayList = new ArrayList<>();
            arraySet = sp1.getStringSet("string_set", null);
            arrayList.addAll(arraySet);
        }


        // If darkmode is true, sets list items to use the custom darkmode_list_layout.xml
        if (darkmode) {
            adapter = new ArrayAdapter<String>(getApplicationContext(),
                    R.layout.darkmode_list_layout, arrayList);
        } else {
            // Uses standard adapter for list items otherwise.
            adapter = new ArrayAdapter<>(getApplicationContext(),
                    android.R.layout.simple_expandable_list_item_1, arrayList);
        }

        // Sets ListView to use one of the adapters above.
        diaryList.setAdapter(adapter);

        // Calls setToggle() when add task button pressed and clears EditText field.
        addDiaryBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setToggle();
                diaryEditText.setText("");
            }
        });

        // Diary Save Button Click
        diarySaveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Gets text in edit field and stores it
                String diaryText = diaryEditText.getText().toString();

                // Gets system service for soft keyboard.
                InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);

                // Gets local date if SDK version is 26 or above.
                LocalDate date = null;
                if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
                    date = LocalDate.now();
                }

//                // Performance Test Loop for x diary entries
//                for (int x = 1; x < 1000000; x++) {
//                    arrayList.add(date + "\n" + diaryText);
//                }

                // Adds list item with diary Text and date and a line break so text is on new line.
                arrayList.add(date + "\n" + diaryText);

                // Resets edit text box
                diaryEditText.setText("");
                setToggle();
                // Hides software keyboard so it doesn't stay open on save.
                imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
            }
        });

        // On ListView Item Clicked
        diaryList.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                // Finds which item was selected and sets the delete and edit button to visible
                String arrayItem = arrayList.get(i);
                diaryDelBtn.setVisibility(View.VISIBLE);
                diaryEditBtn.setVisibility(View.VISIBLE);

                /*
                   If delete button pressed, removes the item, resets the adapter, and gets rid of
                   the delete and edit buttons. If the EditDiaryLayout (holds the editText field)
                   is visible, then we will make it not visible anymore, as if you press delete
                   while you previously clicked the edit button, it will cause the field to remain
                   open. It then calls the toggle so it isn't in the wrong spot and clears the edit
                   text field.
                 */
                diaryDelBtn.setOnClickListener(new View.OnClickListener() {

                    @Override
                    public void onClick(View view) {
                        arrayList.remove(arrayItem);
                        diaryList.setAdapter(adapter);
                        diaryDelBtn.setVisibility(View.GONE);
                        diaryEditBtn.setVisibility(View.GONE);
                        if (editDiaryLayout.getVisibility() == View.VISIBLE) {
                            editSaveBtn.setVisibility(View.GONE);
                            diarySaveBtn.setVisibility(View.VISIBLE);
                            setToggle();
                            diaryEditText.setText("");
                        }

                        // Hides the software keyboard after button is pressed.
                        InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                        imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
                    }
                });

                // If Edit button is pressed
                diaryEditBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        setEditToggle();
                        // Sets edit text field to the text of the selected array item
                        diaryEditText.setText(arrayItem);

                        /*
                           A new save button seamlessly replaces the original save button. There
                           were issues where, since the original save button appends to the end of
                           the list, it would keep overriding the same list item.
                         */
                        editSaveBtn.setOnClickListener(new View.OnClickListener() {

                            @Override
                            public void onClick(View view) {
                                // Gets the new text in the edit text field
                                String diaryText = diaryEditText.getText().toString();

                                // Hides the software keyboard
                                InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                                imm.hideSoftInputFromWindow(view.getWindowToken(), 0);

                                // Sets the current selected list item to the new text.
                                arrayList.set(i, diaryText);

                                // Hides the edit layout and resets the edit textfield to be blank
                                diaryEditText.setText("");
                                setEditToggle();

                                // Gets rid of the delete and edit button
                                diaryDelBtn.setVisibility(View.GONE);
                                diaryEditBtn.setVisibility(View.GONE);
                            }
                        });

                    }
                });

            }
        });

        /*
          If there is a savedInstanceState, it will restore the correct adapter for the list view
          as well as the current diary entries in the list view.
        */
        if (savedInstanceState != null) {
            arrayList = savedInstanceState.getStringArrayList("list");
            if (darkmode) {
                adapter = new ArrayAdapter<String>(getApplicationContext(),
                        R.layout.darkmode_list_layout, arrayList);
            } else {
                adapter = new ArrayAdapter<>(getApplicationContext(),
                        android.R.layout.simple_expandable_list_item_1, arrayList);
            }
            diaryList.setAdapter(adapter);
        }

    }
    // Toggles visibility of the add diary entry layout.
    public boolean setToggle() {
        if (!viewToggle) {
            editDiaryLayout.setVisibility(View.VISIBLE);
            diarySaveBtn.setVisibility(View.VISIBLE);
            editSaveBtn.setVisibility(View.GONE);
            viewToggle = true;
        } else {
            editDiaryLayout.setVisibility(View.GONE);
            diarySaveBtn.setVisibility(View.GONE);
            editSaveBtn.setVisibility(View.VISIBLE);
            viewToggle = false;
        }

        return viewToggle;
    }

    // Toggles visiblity of the edit diary entry layout.
    public boolean setEditToggle() {
        if (!editToggle) {
            editDiaryLayout.setVisibility(View.VISIBLE);
            editSaveBtn.setVisibility(View.VISIBLE);
            diarySaveBtn.setVisibility(View.GONE);
            editToggle = true;
        } else {
            editDiaryLayout.setVisibility(View.GONE);
            editSaveBtn.setVisibility(View.GONE);
            diarySaveBtn.setVisibility(View.VISIBLE);
            editToggle = false;
        }

        return editToggle;
    }

    // Saves the arrayList so it can be restored on orientation change.
    @Override
    protected void onSaveInstanceState(Bundle savedInstanceState) {
        savedInstanceState.putStringArrayList("list", arrayList);

        super.onSaveInstanceState(savedInstanceState);
    }

    @Override
    protected void onPause() {
        super.onPause();

        // Saves the diary entries but only if the user is equal to admin.
        name = sp1.getString("name", "");

        if (name.equals("admin")) {
            SharedPreferences.Editor editor = sp1.edit();

            arraySet = new HashSet<>();
            arraySet.addAll(arrayList);
            editor.putStringSet("string_set", arraySet);
            editor.commit();
        }
    }

}