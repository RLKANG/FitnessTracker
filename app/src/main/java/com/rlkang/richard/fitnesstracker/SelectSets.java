package com.rlkang.richard.fitnesstracker;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class SelectSets extends AppCompatActivity {
    public final static String i_count_exercises = "com.RLKANG.fitnesstracker.count_exercises";
    public final static String i_selected = "com.RLKANG.fitnesstracker.selected";
    public final static String i_mode = "com.RLKANG.fitnesstracker.mode";
    public final static String i_sets = "com.RLKANG.fitnesstracker.sets";

    int count_exercises;
    String selected[];
    String mode;
    TextView[] tv= new TextView[6];
    LinearLayout[] ll= new LinearLayout[6];
    EditText[] et= new EditText[6];
    int sets[]= new int [6];
    String num_choices[]= {"1", "2", "3", "4", "5", "6", "7", "8"};
    int ind=-1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_sets);

        Intent intent = getIntent();
        count_exercises = intent.getIntExtra(SelectionPanel.i_count_exercises, -1);
        selected= intent.getStringArrayExtra(SelectionPanel.i_selected);
        mode= intent.getStringExtra(SelectionPanel.i_mode);

        tv[0]=(TextView) findViewById(R.id.exercise1);
        tv[1]=(TextView) findViewById(R.id.exercise2);
        tv[2]=(TextView) findViewById(R.id.exercise3);
        tv[3]=(TextView) findViewById(R.id.exercise4);
        tv[4]=(TextView) findViewById(R.id.exercise5);
        tv[5]=(TextView) findViewById(R.id.exercise6);

        ll[0]=(LinearLayout) findViewById(R.id.lin1B);
        ll[1]=(LinearLayout) findViewById(R.id.lin2B);
        ll[2]=(LinearLayout) findViewById(R.id.lin3B);
        ll[3]=(LinearLayout) findViewById(R.id.lin4B);
        ll[4]=(LinearLayout) findViewById(R.id.lin5B);
        ll[5]=(LinearLayout) findViewById(R.id.lin6B);

        et[0]=(EditText) findViewById(R.id.stext1);
        et[1]=(EditText) findViewById(R.id.stext2);
        et[2]=(EditText) findViewById(R.id.stext3);
        et[3]=(EditText) findViewById(R.id.stext4);
        et[4]=(EditText) findViewById(R.id.stext5);
        et[5]=(EditText) findViewById(R.id.stext6);

        TextView title= (TextView) findViewById(R.id.main_workout_title);
        assert(title!=null);
        title.setText(mode);

        for (int i=0; i<count_exercises; i++) {
            tv[i].setText(selected[i]);
            ll[i].setVisibility(View.VISIBLE);
        }
    }

    public void Set (View view) {
        if (view.getId() == R.id.stext1) {
            ind = 0;
        } else if (view.getId() == R.id.stext2) {
            ind = 1;
        } else if (view.getId() == R.id.stext3) {
            ind = 2;
        } else if (view.getId() == R.id.stext4) {
            ind = 3;
        } else if (view.getId() == R.id.stext5) {
            ind = 4;
        } else {
            ind = 5;
        }

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Select Number of Sets");
        builder.setItems(num_choices, new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int num) {
                    et[ind].setText(num_choices[num]);
                    sets[ind]= Integer.parseInt(num_choices[num]);
                }
            });
        builder.show();
    }


    public void Start_Workout (View view) { //Save onto file here???
        Intent intent = new Intent(this, MainWorkout.class);
        intent.putExtra(i_count_exercises, count_exercises);
        intent.putExtra(i_selected, selected);
        intent.putExtra(i_mode, mode);
        intent.putExtra(i_sets, sets);
        startActivity(intent);
    }
}
