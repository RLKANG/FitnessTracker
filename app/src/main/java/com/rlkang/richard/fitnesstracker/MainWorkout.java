package com.rlkang.richard.fitnesstracker;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainWorkout extends AppCompatActivity {
    int count_exercises;
    String[] selected;
    String mode;
    int[] sets;
    int exercise_num=0;
    LinearLayout[] ll= new LinearLayout[8];


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_workout);

        Intent intent = getIntent();
        count_exercises = intent.getIntExtra(SelectSets.i_count_exercises, -1);
        selected= intent.getStringArrayExtra(SelectSets.i_selected);
        mode= intent.getStringExtra(SelectSets.i_mode);
        sets= intent.getIntArrayExtra(SelectSets.i_sets);

        ll[0]=(LinearLayout) findViewById(R.id.lin1C);
        ll[1]=(LinearLayout) findViewById(R.id.lin2C);
        ll[2]=(LinearLayout) findViewById(R.id.lin3C);
        ll[3]=(LinearLayout) findViewById(R.id.lin4C);
        ll[4]=(LinearLayout) findViewById(R.id.lin5C);
        ll[5]=(LinearLayout) findViewById(R.id.lin6C);
        ll[6]=(LinearLayout) findViewById(R.id.lin7C);
        ll[7]=(LinearLayout) findViewById(R.id.lin8C);

        TextView title= (TextView) findViewById(R.id.main_workout_title);
        assert(title!=null);
        title.setText(mode);

        TextView exercise_display= (TextView) findViewById(R.id.exercise);
        assert(exercise_display!=null);
        exercise_display.setText(selected[exercise_num]);

        for (int i=0; i<sets[exercise_num]; i++) {
            ll[i].setVisibility(View.VISIBLE);
        }

        exercise_num++;
    }

    public void Enter (View view) {
        if (exercise_num<count_exercises) {
            for (int i = 0; i < 8; i++) {
                ll[i].setVisibility(View.INVISIBLE);
            }

            TextView exercise_display = (TextView) findViewById(R.id.exercise);
            assert (exercise_display != null);
            exercise_display.setText(selected[exercise_num]);

            for (int i = 0; i < sets[exercise_num]; i++) {
                ll[i].setVisibility(View.VISIBLE);
            }

            exercise_num++;
        }
        else {
            AlertDialog.Builder end_of_workout  = new AlertDialog.Builder(this);
            end_of_workout.setMessage("You have reached the end of your workout");
            end_of_workout.setTitle("End of Workout");
            end_of_workout.setPositiveButton("Ok",
                    new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            GoHome();
                        }
                    });
            end_of_workout.setNegativeButton("Cancel", null);
            end_of_workout.setCancelable(true);
            end_of_workout.create().show();
        }
    }

    public void GoHome() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

}
