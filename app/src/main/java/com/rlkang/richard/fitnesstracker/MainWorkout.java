package com.rlkang.richard.fitnesstracker;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainWorkout extends AppCompatActivity {
    int count_exercises;
    String[] selected;
    String mode;
    int[] sets;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_workout);

        Intent intent = getIntent();
        count_exercises = intent.getIntExtra(SelectSets.i_count_exercises, -1);
        selected= intent.getStringArrayExtra(SelectSets.i_selected);
        mode= intent.getStringExtra(SelectSets.i_mode);
        sets= intent.getIntArrayExtra(SelectSets.i_sets);

        /*System.out.println(count_exercises);
        for (int i=0; i<count_exercises; i++) {
            System.out.println(selected[i]);
        }
        System.out.println(mode);
        for (int i=0; i<count_exercises; i++) {
            System.out.println(sets[i]);
        }*/
    }

    public void Enter (View view) {
        System.out.println("Enter Button Pressed");
    }


}
