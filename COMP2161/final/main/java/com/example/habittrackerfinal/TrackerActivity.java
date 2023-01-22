package com.example.habittrackerfinal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.HashSet;

public class TrackerActivity extends AppCompatActivity {
    // Layouts and Views
    private LinearLayout editViewLay, task1Lay, task2Lay, task3Lay, task4Lay, task5Lay, task6Lay,
            task7Lay, prog1Lay, prog2Lay, prog3Lay, prog4Lay, prog5Lay, prog6Lay, prog7Lay;
    private TextView task1View, task2View, task3View, task4View, task5View, task6View, task7View,
            editView, task1Counter, task2Counter, task3Counter, task4Counter, task5Counter,
            task6Counter, task7Counter;
    private Button addTaskBtn, settingsBtn, saveBtn, diaryBtn1, diaryBtn2, diaryBtn3, diaryBtn4,
            diaryBtn5, diaryBtn6, diaryBtn7, deleteBtn1, deleteBtn2, deleteBtn3, deleteBtn4,
            deleteBtn5, deleteBtn6,deleteBtn7;
    private Button task1incr, task2incr, task3incr, task4incr, task5incr, task6incr, task7incr,
            task1decr, task2decr, task3decr, task4decr, task5decr, task6decr, task7decr;
    private ProgressBar progBar1, progBar2, progBar3, progBar4, progBar5, progBar6, progBar7;

    // Variables

    private boolean viewToggle = false;

    protected SharedPreferences sp, sp2;

    private String name;

    // Keys

    private static final String TASK_NAME = "name_key";
    private static final String TASK_ONE = "task1_key";
    private static final String TASK_TWO = "task2_key";
    private static final String TASK_THREE = "task3_key";
    private static final String TASK_FOUR = "task4_key";
    private static final String TASK_FIVE = "task5_key";
    private static final String TASK_SIX = "task6_key";
    private static final String TASK_SEVEN = "task7_key";

    private static final String TASK1_VIEW = "task1_view";
    private static final String TASK2_VIEW = "task2_view";
    private static final String TASK3_VIEW = "task3_view";
    private static final String TASK4_VIEW = "task4_view";
    private static final String TASK5_VIEW = "task5_view";
    private static final String TASK6_VIEW = "task6_view";
    private static final String TASK7_VIEW = "task7_view";

    private static final String TASK1_PROG_LAYOUT = "task1_prog_layout";
    private static final String TASK2_PROG_LAYOUT = "task2_prog_layout";
    private static final String TASK3_PROG_LAYOUT = "task3_prog_layout";
    private static final String TASK4_PROG_LAYOUT = "task4_prog_layout";
    private static final String TASK5_PROG_LAYOUT = "task5_prog_layout";
    private static final String TASK6_PROG_LAYOUT = "task6_prog_layout";
    private static final String TASK7_PROG_LAYOUT = "task7_prog_layout";

    private static final String COUNTER_ONE = "counter_one";
    private static final String COUNTER_TWO = "counter_two";
    private static final String COUNTER_THREE = "counter_three";
    private static final String COUNTER_FOUR = "counter_four";
    private static final String COUNTER_FIVE = "counter_five";
    private static final String COUNTER_SIX = "counter_six";
    private static final String COUNTER_SEVEN = "counter_seven";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tracker);

        // Finds Layouts
        editViewLay = (LinearLayout) findViewById(R.id.editText_layout);
        task1Lay = (LinearLayout) findViewById(R.id.task1_layout);
        task2Lay = (LinearLayout) findViewById(R.id.task2_layout);
        task3Lay = (LinearLayout) findViewById(R.id.task3_layout);
        task4Lay = (LinearLayout) findViewById(R.id.task4_layout);
        task5Lay = (LinearLayout) findViewById(R.id.task5_layout);
        task6Lay = (LinearLayout) findViewById(R.id.task6_layout);
        task7Lay = (LinearLayout) findViewById(R.id.task7_layout);
        prog1Lay = (LinearLayout) findViewById(R.id.progress1_layout);
        prog2Lay = (LinearLayout) findViewById(R.id.progress2_layout);
        prog3Lay = (LinearLayout) findViewById(R.id.progress3_layout);
        prog4Lay = (LinearLayout) findViewById(R.id.progress4_layout);
        prog5Lay = (LinearLayout) findViewById(R.id.progress5_layout);
        prog6Lay = (LinearLayout) findViewById(R.id.progress6_layout);
        prog7Lay = (LinearLayout) findViewById(R.id.progress7_layout);

        // Finds edit text view
        editView = (TextView) findViewById(R.id.addTaskEditTextView);

        // Finds Task TextViews
        task1View = (TextView) findViewById(R.id.task1View);
        task2View = (TextView) findViewById(R.id.task2View);
        task3View = (TextView) findViewById(R.id.task3View);
        task4View = (TextView) findViewById(R.id.task4View);
        task5View = (TextView) findViewById(R.id.task5View);
        task6View = (TextView) findViewById(R.id.task6View);
        task7View = (TextView) findViewById(R.id.task7View);

        // Finds Progress Bar Elements
        progBar1 = (ProgressBar) findViewById(R.id.progressBar1);
        progBar2 = (ProgressBar) findViewById(R.id.progressBar2);
        progBar3 = (ProgressBar) findViewById(R.id.progressBar3);
        progBar4 = (ProgressBar) findViewById(R.id.progressBar4);
        progBar5 = (ProgressBar) findViewById(R.id.progressBar5);
        progBar6 = (ProgressBar) findViewById(R.id.progressBar6);
        progBar7 = (ProgressBar) findViewById(R.id.progressBar7);

        // Finds Counter TextViews
        task1Counter = (TextView) findViewById(R.id.task1WeekCounter);
        task2Counter = (TextView) findViewById(R.id.task2WeekCounter);
        task3Counter = (TextView) findViewById(R.id.task3WeekCounter);
        task4Counter = (TextView) findViewById(R.id.task4WeekCounter);
        task5Counter = (TextView) findViewById(R.id.task5WeekCounter);
        task6Counter = (TextView) findViewById(R.id.task6WeekCounter);
        task7Counter = (TextView) findViewById(R.id.task7WeekCounter);

        // Finds increment buttons
        task1incr = (Button) findViewById(R.id.incremenet1Btn);
        task2incr = (Button) findViewById(R.id.increment2Btn);
        task3incr = (Button) findViewById(R.id.increment3Btn);
        task4incr = (Button) findViewById(R.id.increment4Btn);
        task5incr = (Button) findViewById(R.id.increment5Btn);
        task6incr = (Button) findViewById(R.id.increment6Btn);
        task7incr = (Button) findViewById(R.id.increment7Btn);

        // Finds decrement buttons
        task1decr = (Button) findViewById(R.id.decrement1Btn);
        task2decr = (Button) findViewById(R.id.decrement2Btn);
        task3decr = (Button) findViewById(R.id.decrement3Btn);
        task4decr = (Button) findViewById(R.id.decrement4Btn);
        task5decr = (Button) findViewById(R.id.decrement5Btn);
        task6decr = (Button) findViewById(R.id.decrement6Btn);
        task7decr = (Button) findViewById(R.id.decrement7Btn);

        // Finds add, settings, and save buttons.
        addTaskBtn = (Button) findViewById(R.id.addTaskBtn);
        settingsBtn = (Button) findViewById(R.id.settingBtn);
        saveBtn = (Button) findViewById(R.id.saveBtn);

        // Finds Diary Buttons
        diaryBtn1 = (Button) findViewById(R.id.diary1Btn);
        diaryBtn2 = (Button) findViewById(R.id.diary2Btn);
        diaryBtn3 = (Button) findViewById(R.id.diary3Btn);
        diaryBtn4 = (Button) findViewById(R.id.diary4Btn);
        diaryBtn5 = (Button) findViewById(R.id.diary5Btn);
        diaryBtn6 = (Button) findViewById(R.id.diary6Btn);
        diaryBtn7 = (Button) findViewById(R.id.diary7Btn);

        // Finds Delete Buttons
        deleteBtn1 = (Button) findViewById(R.id.delTask1Btn);
        deleteBtn2 = (Button) findViewById(R.id.delTask2Btn);
        deleteBtn3 = (Button) findViewById(R.id.delTask3Btn);
        deleteBtn4 = (Button) findViewById(R.id.delTask4Btn);
        deleteBtn5 = (Button) findViewById(R.id.delTask5Btn);
        deleteBtn6 = (Button) findViewById(R.id.delTask6Btn);
        deleteBtn7 = (Button) findViewById(R.id.delTask7Btn);

        // Resets task layout and progress layout visibilities to gone by default.
        editViewLay.setVisibility(View.GONE);
        task1Lay.setVisibility(View.GONE);
        task2Lay.setVisibility(View.GONE);
        task3Lay.setVisibility(View.GONE);
        task4Lay.setVisibility(View.GONE);
        task5Lay.setVisibility(View.GONE);
        task6Lay.setVisibility(View.GONE);
        task7Lay.setVisibility(View.GONE);

        prog1Lay.setVisibility(View.GONE);
        prog2Lay.setVisibility(View.GONE);
        prog3Lay.setVisibility(View.GONE);
        prog4Lay.setVisibility(View.GONE);
        prog5Lay.setVisibility(View.GONE);
        prog6Lay.setVisibility(View.GONE);
        prog7Lay.setVisibility(View.GONE);

        // Loads SharedPreferences for TrackerPrefs and compares if name == admin
        sp2 = getApplicationContext().getSharedPreferences("TrackerPrefs", MODE_PRIVATE);
        sp = getApplicationContext().getSharedPreferences("NamePref", Context.MODE_PRIVATE);
        name = sp.getString("name", "");

        if (name.equals("admin")) {
            /*
              Uses saved visibilities to set task and progress layout visibility. If none saved,
              it sets the visibility to 8 which is the int value for GONE.
            */
            task1Lay.setVisibility(sp2.getInt("lay1View", 8));
            task2Lay.setVisibility(sp2.getInt("lay2View", 8));
            task3Lay.setVisibility(sp2.getInt("lay3View", 8));
            task4Lay.setVisibility(sp2.getInt("lay4View", 8));
            task5Lay.setVisibility(sp2.getInt("lay5View", 8));
            task6Lay.setVisibility(sp2.getInt("lay6View", 8));
            task7Lay.setVisibility(sp2.getInt("lay7View", 8));

            prog1Lay.setVisibility(sp2.getInt("prog1_lay", 8));
            prog2Lay.setVisibility(sp2.getInt("prog2_lay", 8));
            prog3Lay.setVisibility(sp2.getInt("prog3_lay", 8));
            prog4Lay.setVisibility(sp2.getInt("prog4_lay", 8));
            prog5Lay.setVisibility(sp2.getInt("prog5_lay", 8));
            prog6Lay.setVisibility(sp2.getInt("prog6_lay", 8));
            prog7Lay.setVisibility(sp2.getInt("prog7_lay", 8));

            // Sets task text to saved values or a blank string
            task1View.setText(sp2.getString("task1View", ""));
            task2View.setText(sp2.getString("task2View", ""));
            task3View.setText(sp2.getString("task3View", ""));
            task4View.setText(sp2.getString("task4View", ""));
            task5View.setText(sp2.getString("task5View", ""));
            task6View.setText(sp2.getString("task6View", ""));
            task7View.setText(sp2.getString("task7View", ""));

            // Sets progress bar progression to saved value or 0.
            progBar1.setProgress(sp2.getInt("prog1_key", 0));
            progBar2.setProgress(sp2.getInt("prog2_key", 0));
            progBar3.setProgress(sp2.getInt("prog3_key", 0));
            progBar4.setProgress(sp2.getInt("prog4_key", 0));
            progBar5.setProgress(sp2.getInt("prog5_key", 0));
            progBar6.setProgress(sp2.getInt("prog6_key", 0));
            progBar7.setProgress(sp2.getInt("prog7_key", 0));

            // Sets counter text view to saved value or 0.
            task1Counter.setText(sp2.getString("counter1", "0"));
            task2Counter.setText(sp2.getString("counter2", "0"));
            task3Counter.setText(sp2.getString("counter3", "0"));
            task4Counter.setText(sp2.getString("counter4", "0"));
            task5Counter.setText(sp2.getString("counter5", "0"));
            task6Counter.setText(sp2.getString("counter6", "0"));
            task7Counter.setText(sp2.getString("counter7", "0"));

        }

        // Calls setToggle() when add task button pressed
        addTaskBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setToggle();
            }
        });

        // Open Settings Activity
        settingsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent msg = new Intent(TrackerActivity.this, SettingsActivity.class);
                startActivity(msg);
            }
        });


        // Saves task and adds it to list of habits
        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String taskText = editView.getText().toString();

                // Gets system service for soft keyboard.
                InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);

                // Only adds task in spot if it's currently gone from display
                if (task1Lay.getVisibility() == View.GONE) {
                    task1View.setText(taskText);
                    task1Lay.setVisibility(View.VISIBLE);
                    prog1Lay.setVisibility(View.VISIBLE);
                    task1Counter.setText("0");
                } else if (task2Lay.getVisibility() == View.GONE) {
                    task2View.setText(taskText);
                    task2Lay.setVisibility(View.VISIBLE);
                    prog2Lay.setVisibility(View.VISIBLE);
                    task2Counter.setText("0");
                } else if (task3Lay.getVisibility() == View.GONE) {
                    task3View.setText(taskText);
                    task3Lay.setVisibility(View.VISIBLE);
                    prog3Lay.setVisibility(View.VISIBLE);
                    task3Counter.setText("0");
                } else if (task4Lay.getVisibility() == View.GONE) {
                    task4View.setText(taskText);
                    task4Lay.setVisibility(View.VISIBLE);
                    prog4Lay.setVisibility(View.VISIBLE);
                    task4Counter.setText("0");
                } else if (task5Lay.getVisibility() == View.GONE) {
                    task5View.setText(taskText);
                    task5Lay.setVisibility(View.VISIBLE);
                    prog5Lay.setVisibility(View.VISIBLE);
                    task5Counter.setText("0");
                } else if (task6Lay.getVisibility() == View.GONE) {
                    task6View.setText(taskText);
                    task6Lay.setVisibility(View.VISIBLE);
                    prog6Lay.setVisibility(View.VISIBLE);
                    task6Counter.setText("0");
                } else if (task7Lay.getVisibility() == View.GONE) {
                    task7View.setText(taskText);
                    task7Lay.setVisibility(View.VISIBLE);
                    prog7Lay.setVisibility(View.VISIBLE);
                    task7Counter.setText("0");
                } else {
                    // If all task spots are full, display toast message.
                    Toast.makeText(TrackerActivity.this,
                            "This app only supports 7 tasks. Please delete one to add a new one.",
                            Toast.LENGTH_SHORT).show();
                }

                // Resets edit text box
                editView.setText("");
                setToggle();
                // Hides software keyboard so it doesn't stay open on save.
                imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
            }
        });

        // Diary Function which opens Diary Activity
        diaryBtn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openDiary();
            }
        });

        diaryBtn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openDiary();
            }
        });

        diaryBtn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openDiary();
            }
        });

        diaryBtn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openDiary();
            }
        });

        diaryBtn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openDiary();
            }
        });

        diaryBtn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openDiary();
            }
        });

        diaryBtn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openDiary();
            }
        });

        diaryBtn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openDiary();
            }
        });

        /*
           Delete Function which deletes a task by resetting its editText, progress bar,
           and setting the layout visibilities to gone.
        */
        deleteBtn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                task1View.setText("");
                task1Lay.setVisibility(View.GONE);
                prog1Lay.setVisibility(View.GONE);
                progBar1.setProgress(1);
            }

        });

        deleteBtn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                task2View.setText("");
                task2Lay.setVisibility(View.GONE);
                prog2Lay.setVisibility(View.GONE);
                progBar2.setProgress(1);
            }

        });

        deleteBtn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                task3View.setText("");
                task3Lay.setVisibility(View.GONE);
                prog3Lay.setVisibility(View.GONE);
                progBar3.setProgress(1);
            }

        });

        deleteBtn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                task4View.setText("");
                task4Lay.setVisibility(View.GONE);
                prog4Lay.setVisibility(View.GONE);
                progBar4.setProgress(1);
            }

        });

        deleteBtn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                task5View.setText("");
                task5Lay.setVisibility(View.GONE);
                prog5Lay.setVisibility(View.GONE);
                progBar5.setProgress(1);
            }

        });

        deleteBtn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                task6View.setText("");
                task6Lay.setVisibility(View.GONE);
                prog6Lay.setVisibility(View.GONE);
                progBar6.setProgress(1);
            }

        });

        deleteBtn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                task7View.setText("");
                task7Lay.setVisibility(View.GONE);
                prog7Lay.setVisibility(View.GONE);
                progBar7.setProgress(1);
            }

        });

        // Progress Bar Increment and Decrement Buttons
        task1incr.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                // Gets the int value of the text view and increments it
                int counter = Integer.parseInt(task1Counter.getText().toString());
                counter++;
                // Converts counter to string and puts that text in the counter textview.
                String counterStr = Integer.toString(counter);
                task1Counter.setText(counterStr);

                /*
                  If progress is less than 98, increment by 14. Otherwise, reset progress to 14.
                  100 / 7 tasks is where the 14 comes from.
                 */
                if (progBar1.getProgress() < 98) {
                    int increment = progBar1.getProgress() + 14;
                    progBar1.setProgress(increment);
                } else {
                    progBar1.setProgress(14);
                }
            }
        });

        task1decr.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                // Gets int value from the counter text view and, if not 0, decrements it
                int counter = Integer.parseInt(task1Counter.getText().toString());
                if (counter > 0) {
                    counter--;
                }
                // Converts counter to string and puts it in counter TextView.
                String counterStr = Integer.toString(counter);
                task1Counter.setText(counterStr);

                // If progress greater than 14, decrement progress bar by 14.
                if (progBar1.getProgress() > 14) {
                    int decrement = progBar1.getProgress() - 14;
                    progBar1.setProgress(decrement);
                } else if (counter != 0) {
                    // If counter is not zero, set the progress bar back to 100.
                    progBar1.setProgress(100);
                } else {
                    // If 0, set progress to 0.
                    progBar1.setProgress(0);
                }

            }
        });

        task2incr.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                int counter = Integer.parseInt(task2Counter.getText().toString());
                counter++;
                String counterStr = Integer.toString(counter);
                task2Counter.setText(counterStr);

                if (progBar2.getProgress() < 98) {
                    int increment = progBar2.getProgress() + 14;
                    progBar2.setProgress(increment);
                } else {
                    progBar2.setProgress(14);
                }
            }
        });

        task2decr.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                int counter = Integer.parseInt(task2Counter.getText().toString());
                if (counter > 0) {
                    counter--;
                }
                String counterStr = Integer.toString(counter);
                task2Counter.setText(counterStr);

                if (progBar2.getProgress() > 14) {
                    int decrement = progBar2.getProgress() - 14;
                    progBar2.setProgress(decrement);
                } else if (counter != 0) {
                    progBar2.setProgress(100);
                } else {
                    progBar2.setProgress(0);
                }

            }
        });

        task3incr.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                int counter = Integer.parseInt(task3Counter.getText().toString());
                counter++;
                String counterStr = Integer.toString(counter);
                task3Counter.setText(counterStr);

                if (progBar3.getProgress() < 98) {
                    int increment = progBar3.getProgress() + 14;
                    progBar3.setProgress(increment);
                } else {
                    progBar3.setProgress(14);
                }
            }
        });

        task3decr.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                int counter = Integer.parseInt(task3Counter.getText().toString());
                if (counter > 0) {
                    counter--;
                }
                String counterStr = Integer.toString(counter);
                task3Counter.setText(counterStr);

                if (progBar3.getProgress() > 14) {
                    int decrement = progBar3.getProgress() - 14;
                    progBar3.setProgress(decrement);
                } else if (counter != 0) {
                    progBar3.setProgress(100);
                } else {
                    progBar3.setProgress(0);
                }

            }
        });

        task4incr.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                int counter = Integer.parseInt(task4Counter.getText().toString());
                counter++;
                String counterStr = Integer.toString(counter);
                task4Counter.setText(counterStr);

                if (progBar4.getProgress() < 98) {
                    int increment = progBar4.getProgress() + 14;
                    progBar4.setProgress(increment);
                } else {
                    progBar4.setProgress(14);
                }
            }
        });

        task4decr.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                int counter = Integer.parseInt(task4Counter.getText().toString());
                if (counter > 0) {
                    counter--;
                }
                String counterStr = Integer.toString(counter);
                task4Counter.setText(counterStr);

                if (progBar4.getProgress() > 14) {
                    int decrement = progBar4.getProgress() - 14;
                    progBar4.setProgress(decrement);
                } else if (counter != 0) {
                    progBar4.setProgress(100);
                } else {
                    progBar4.setProgress(0);
                }

            }
        });

        task5incr.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                int counter = Integer.parseInt(task5Counter.getText().toString());
                counter++;
                String counterStr = Integer.toString(counter);
                task5Counter.setText(counterStr);

                if (progBar5.getProgress() < 98) {
                    int increment = progBar5.getProgress() + 14;
                    progBar5.setProgress(increment);
                } else {
                    progBar5.setProgress(14);
                }
            }
        });

        task5decr.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                int counter = Integer.parseInt(task5Counter.getText().toString());
                if (counter > 0) {
                    counter--;
                }
                String counterStr = Integer.toString(counter);
                task5Counter.setText(counterStr);

                if (progBar5.getProgress() > 14) {
                    int decrement = progBar5.getProgress() - 14;
                    progBar5.setProgress(decrement);
                } else if (counter != 0) {
                    progBar5.setProgress(100);
                } else {
                    progBar5.setProgress(0);
                }

            }
        });

        task6incr.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                int counter = Integer.parseInt(task6Counter.getText().toString());
                counter++;
                String counterStr = Integer.toString(counter);
                task6Counter.setText(counterStr);

                if (progBar6.getProgress() < 98) {
                    int increment = progBar6.getProgress() + 14;
                    progBar6.setProgress(increment);
                } else {
                    progBar6.setProgress(14);
                }
            }
        });

        task6decr.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                int counter = Integer.parseInt(task6Counter.getText().toString());
                if (counter > 0) {
                    counter--;
                }
                String counterStr = Integer.toString(counter);
                task6Counter.setText(counterStr);

                if (progBar6.getProgress() > 14) {
                    int decrement = progBar6.getProgress() - 14;
                    progBar6.setProgress(decrement);
                } else if (counter != 0) {
                    progBar6.setProgress(100);
                } else {
                    progBar6.setProgress(0);
                }

            }
        });

        task7incr.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                int counter = Integer.parseInt(task7Counter.getText().toString());
                counter++;
                String counterStr = Integer.toString(counter);
                task7Counter.setText(counterStr);

                if (progBar7.getProgress() < 98) {
                    int increment = progBar7.getProgress() + 14;
                    progBar7.setProgress(increment);
                } else {
                    progBar7.setProgress(14);
                }
            }
        });

        task7decr.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                int counter = Integer.parseInt(task7Counter.getText().toString());
                if (counter > 0) {
                    counter--;
                }
                String counterStr = Integer.toString(counter);
                task7Counter.setText(counterStr);

                if (progBar7.getProgress() > 14) {
                    int decrement = progBar7.getProgress() - 14;
                    progBar7.setProgress(decrement);
                } else if (counter != 0) {
                    progBar7.setProgress(100);
                } else {
                    progBar7.setProgress(0);
                }

            }
        });

        // Restores savedInstanceState if there is one.
        if (savedInstanceState != null) {
            String savedEditTask = savedInstanceState.getString(TASK_NAME);
            /*
              Restores saved task names, counters, layout views. Progress bar attribute not needed
              as it is based on the counter value.
             */
            editView.setText(savedEditTask);

            String savedTask1 = savedInstanceState.getString(TASK_ONE);
            String savedTask2 = savedInstanceState.getString(TASK_TWO);
            String savedTask3 = savedInstanceState.getString(TASK_THREE);
            String savedTask4 = savedInstanceState.getString(TASK_FOUR);
            String savedTask5 = savedInstanceState.getString(TASK_FIVE);
            String savedTask6 = savedInstanceState.getString(TASK_SIX);
            String savedTask7 = savedInstanceState.getString(TASK_SEVEN);

            task1View.setText(savedTask1);
            task2View.setText(savedTask2);
            task3View.setText(savedTask3);
            task4View.setText(savedTask4);
            task5View.setText(savedTask5);
            task6View.setText(savedTask6);


            String savedCounter1 = savedInstanceState.getString(COUNTER_ONE);
            String savedCounter2 = savedInstanceState.getString(COUNTER_TWO);
            String savedCounter3 = savedInstanceState.getString(COUNTER_THREE);
            String savedCounter4 = savedInstanceState.getString(COUNTER_FOUR);
            String savedCounter5 = savedInstanceState.getString(COUNTER_FIVE);
            String savedCounter6 = savedInstanceState.getString(COUNTER_SIX);
            String savedCounter7 = savedInstanceState.getString(COUNTER_SEVEN);

            task1Counter.setText(savedCounter1);
            task2Counter.setText(savedCounter2);
            task3Counter.setText(savedCounter3);
            task4Counter.setText(savedCounter4);
            task5Counter.setText(savedCounter5);
            task6Counter.setText(savedCounter6);
            task7Counter.setText(savedCounter7);

            int task1Layout = savedInstanceState.getInt(TASK1_VIEW);
            int task1ProgLayout = savedInstanceState.getInt(TASK1_PROG_LAYOUT);

            int task2Layout = savedInstanceState.getInt(TASK2_VIEW);
            int task2ProgLayout = savedInstanceState.getInt(TASK2_PROG_LAYOUT);

            int task3Layout = savedInstanceState.getInt(TASK3_VIEW);
            int task3ProgLayout = savedInstanceState.getInt(TASK3_PROG_LAYOUT);

            int task4Layout = savedInstanceState.getInt(TASK4_VIEW);
            int task4ProgLayout = savedInstanceState.getInt(TASK4_PROG_LAYOUT);

            int task5Layout = savedInstanceState.getInt(TASK5_VIEW);
            int task5ProgLayout = savedInstanceState.getInt(TASK5_PROG_LAYOUT);

            int task6Layout = savedInstanceState.getInt(TASK6_VIEW);
            int task6ProgLayout = savedInstanceState.getInt(TASK6_PROG_LAYOUT);

            int task7Layout = savedInstanceState.getInt(TASK7_VIEW);
            int task7ProgLayout = savedInstanceState.getInt(TASK7_PROG_LAYOUT);

            task1Lay.setVisibility(task1Layout);
            prog1Lay.setVisibility(task1ProgLayout);

            task2Lay.setVisibility(task2Layout);
            prog2Lay.setVisibility(task2ProgLayout);

            task3Lay.setVisibility(task3Layout);
            prog3Lay.setVisibility(task3ProgLayout);

            task4Lay.setVisibility(task4Layout);
            prog4Lay.setVisibility(task4ProgLayout);

            task5Lay.setVisibility(task5Layout);
            prog5Lay.setVisibility(task5ProgLayout);

            task6Lay.setVisibility(task6Layout);
            prog6Lay.setVisibility(task6ProgLayout);

            task7Lay.setVisibility(task7Layout);
            prog7Lay.setVisibility(task7ProgLayout);

        }


    }

    // Toggles edit view between visible and gone if the user clicks openEditView more than once.
    public boolean setToggle() {
        if (!viewToggle) {
            editViewLay.setVisibility(View.VISIBLE);
            viewToggle = true;
        } else {
            editViewLay.setVisibility(View.GONE);
            viewToggle = false;
        }

        return viewToggle;
    }

    // Opens Diary Activity. Same for all diary buttons.
    public void openDiary() {
        Intent msg = new Intent(TrackerActivity.this, DiaryActivity.class);
        startActivity(msg);
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        // Puts task names, counter values, and view visibility in saved instance state for orientation.
        savedInstanceState.putString(TASK_NAME, editView.getText().toString());
        savedInstanceState.putString(TASK_ONE, task1View.getText().toString());
        savedInstanceState.putString(TASK_TWO, task2View.getText().toString());
        savedInstanceState.putString(TASK_THREE, task3View.getText().toString());
        savedInstanceState.putString(TASK_FOUR, task4View.getText().toString());
        savedInstanceState.putString(TASK_FIVE, task5View.getText().toString());
        savedInstanceState.putString(TASK_SIX, task6View.getText().toString());
        savedInstanceState.putString(TASK_SEVEN, task7View.getText().toString());

        savedInstanceState.putString(COUNTER_ONE, task1Counter.getText().toString());
        savedInstanceState.putString(COUNTER_TWO, task2Counter.getText().toString());
        savedInstanceState.putString(COUNTER_THREE, task3Counter.getText().toString());
        savedInstanceState.putString(COUNTER_FOUR, task4Counter.getText().toString());
        savedInstanceState.putString(COUNTER_FIVE, task5Counter.getText().toString());
        savedInstanceState.putString(COUNTER_SIX, task6Counter.getText().toString());
        savedInstanceState.putString(COUNTER_SEVEN, task7Counter.getText().toString());


        savedInstanceState.putInt(TASK1_VIEW, task1Lay.getVisibility());
        savedInstanceState.putInt(TASK1_PROG_LAYOUT, prog1Lay.getVisibility());

        savedInstanceState.putInt(TASK2_VIEW, task2Lay.getVisibility());
        savedInstanceState.putInt(TASK2_PROG_LAYOUT, prog2Lay.getVisibility());

        savedInstanceState.putInt(TASK3_VIEW, task3Lay.getVisibility());
        savedInstanceState.putInt(TASK3_PROG_LAYOUT, prog3Lay.getVisibility());

        savedInstanceState.putInt(TASK4_VIEW, task4Lay.getVisibility());
        savedInstanceState.putInt(TASK4_PROG_LAYOUT, prog4Lay.getVisibility());

        savedInstanceState.putInt(TASK5_VIEW, task5Lay.getVisibility());
        savedInstanceState.putInt(TASK5_PROG_LAYOUT, prog5Lay.getVisibility());

        savedInstanceState.putInt(TASK6_VIEW, task6Lay.getVisibility());
        savedInstanceState.putInt(TASK6_PROG_LAYOUT, prog6Lay.getVisibility());

        savedInstanceState.putInt(TASK7_VIEW, task7Lay.getVisibility());
        savedInstanceState.putInt(TASK7_PROG_LAYOUT, prog7Lay.getVisibility());


        super.onSaveInstanceState(savedInstanceState);
    }

    @Override
    protected void onPause() {
        super.onPause();

        // Gets username to compare
        sp = getApplicationContext().getSharedPreferences("NamePref", Context.MODE_PRIVATE);
        name = sp.getString("name", "");

        // Only saves to SharedPreferences if username is equal to admin
        if (name.equals("admin")) {
            SharedPreferences.Editor editor = sp2.edit();

            // Saves Habit Name Information
            editor.putString("task1View", task1View.getText().toString());
            editor.putString("task2View", task2View.getText().toString());
            editor.putString("task3View", task3View.getText().toString());
            editor.putString("task4View", task4View.getText().toString());
            editor.putString("task5View", task5View.getText().toString());
            editor.putString("task6View", task6View.getText().toString());
            editor.putString("task7View", task7View.getText().toString());


            // Saves Layout Visibility
            editor.putInt("lay1View", task1Lay.getVisibility());
            editor.putInt("lay2View", task2Lay.getVisibility());
            editor.putInt("lay3View", task3Lay.getVisibility());
            editor.putInt("lay4View", task4Lay.getVisibility());
            editor.putInt("lay5View", task5Lay.getVisibility());
            editor.putInt("lay6View", task6Lay.getVisibility());
            editor.putInt("lay7View", task7Lay.getVisibility());

            editor.putInt("prog1_lay", prog1Lay.getVisibility());
            editor.putInt("prog2_lay", prog2Lay.getVisibility());
            editor.putInt("prog3_lay", prog3Lay.getVisibility());
            editor.putInt("prog4_lay", prog4Lay.getVisibility());
            editor.putInt("prog5_lay", prog5Lay.getVisibility());
            editor.putInt("prog6_lay", prog6Lay.getVisibility());
            editor.putInt("prog7_lay", prog7Lay.getVisibility());

            // Saves current progress and counter numbers
            editor.putInt("prog1_key", progBar1.getProgress());
            editor.putString("counter1", task1Counter.getText().toString());

            editor.putInt("prog2_key", progBar2.getProgress());
            editor.putString("counter2", task2Counter.getText().toString());

            editor.putInt("prog3_key", progBar3.getProgress());
            editor.putString("counter3", task3Counter.getText().toString());

            editor.putInt("prog4_key", progBar4.getProgress());
            editor.putString("counter4", task4Counter.getText().toString());

            editor.putInt("prog5_key", progBar5.getProgress());
            editor.putString("counter5", task5Counter.getText().toString());

            editor.putInt("prog6_key", progBar6.getProgress());
            editor.putString("counter6", task6Counter.getText().toString());

            editor.putInt("prog7_key", progBar7.getProgress());
            editor.putString("counter7", task7Counter.getText().toString());
            editor.commit();
        }
    }



}