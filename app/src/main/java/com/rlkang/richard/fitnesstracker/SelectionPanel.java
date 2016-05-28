package com.rlkang.richard.fitnesstracker;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class SelectionPanel extends AppCompatActivity {

    public static String mode= "";
    public static String[] arm_exercises= {};
    public static String[] shoulder_exercises= {};
    public static String[] chest_exercises= {};
    public static String[] back_exercises= {};
    public static String[] legs_exercises= {};
    public static String[] custom_exercises= {};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selection_panel);

        Intent intent = getIntent();
        String choice = intent.getStringExtra(MainActivity.user_choice);
        TextView display_part = (TextView) findViewById(R.id.display_part);
        assert(display_part!=null);
        display_part.setText(choice);
        mode= choice;

        if (mode.equals("Arms")) {

        }
        else if (mode.equals("Shoulders")) {

        }
        else if (mode.equals("Chest")) {

        }
        else if (mode.equals("Back")) {

        }
        else if (mode.equals("Legs")) {

        }
        else {

        }

    }

    public void Add (View view) {
        System.out.println("Add button pressed");
    }

    public void Start_Workout (View view) {
        System.out.println("Start Workout button pressed");
    }

}
