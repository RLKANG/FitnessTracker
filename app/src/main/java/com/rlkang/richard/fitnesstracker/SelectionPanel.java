package com.rlkang.richard.fitnesstracker;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class SelectionPanel extends AppCompatActivity {

    public final static String i_count_exercises = "com.RLKANG.fitnesstracker.count_exercises";
    public final static String i_selected = "com.RLKANG.fitnesstracker.selected";
    public final static String i_mode = "com.RLKANG.fitnesstracker.mode";

    public static String mode= "";
    public static String[] arm_exercises= {"Select...", "Dumbbell Bicep Curl", "EZ-Bar Bicep Curl", "Skullcrushers", "Tricep Pushups"};
    public static String[] shoulder_exercises= {"Select...", "Lateral Dumbbell Raises", "Front Dumbbell Raises", "Shoulder Press"};
    public static String[] chest_exercises= {"Select...", "Bench Press","Chest Flyes", "Dumbbell Chest Press"};
    public static String[] back_exercises= {"Select...", "Stiff-Leg Deadlift", "Pullups", "Lat Pulldown"};
    public static String[] leg_exercises= {"Select...", "Front Squat", "Back Squat", "Calf Raises"};
    public static EditText[] exercises_text= new EditText[6];
    public static int ind=-1; //Keeps track of which EditText was pressed

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selection_panel);

        exercises_text[0]=(EditText) findViewById(R.id.text1);
        exercises_text[1]=(EditText) findViewById(R.id.text2);
        exercises_text[2]=(EditText) findViewById(R.id.text3);
        exercises_text[3]=(EditText) findViewById(R.id.text4);
        exercises_text[4]=(EditText) findViewById(R.id.text5);
        exercises_text[5]=(EditText) findViewById(R.id.text6);

        Intent intent = getIntent();
        String choice = intent.getStringExtra(MainActivity.user_choice);
        TextView display_part = (TextView) findViewById(R.id.display_part);
        assert(display_part!=null);
        display_part.setText(choice);
        mode= choice;
    }

    public void Add (View view) {
        if (view.getId()==R.id.text1) {
            ind=0;
        }
        else if (view.getId()==R.id.text2) {
            ind=1;
        }
        else if (view.getId()==R.id.text3) {
            ind=2;
        }
        else if (view.getId()==R.id.text4) {
            ind=3;
        }
        else if (view.getId()==R.id.text5) {
            ind=4;
        }
        else {
            ind=5;
        }
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Select Exercise");

        if (mode.equals("Arms")) {
            builder.setItems(arm_exercises, new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int num) {
                    exercises_text[ind].setText(arm_exercises[num]);
                }
            });
        }
        else if (mode.equals("Shoulders")) {
            builder.setItems(shoulder_exercises, new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int num) {
                    exercises_text[ind].setText(shoulder_exercises[num]);
                }
            });
        }
        else if (mode.equals("Chest")) {
            builder.setItems(chest_exercises, new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int num) {
                    exercises_text[ind].setText(chest_exercises[num]);
                }
            });
        }
        else if (mode.equals("Back")) {
            builder.setItems(back_exercises, new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int num) {
                    exercises_text[ind].setText(back_exercises[num]);
                }
            });
        }
        else if (mode.equals("Legs")) {
            builder.setItems(leg_exercises, new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int num) {
                    exercises_text[ind].setText(leg_exercises[num]);
                }
            });
        }
        builder.show();
    }

    public void Select_Sets (View view) {
        boolean select = false;
        for (int i = 0; i < 6; i++) {
            if (!exercises_text[i].getText().toString().equals("Select...")) {
                select = true;
                break;
            }
        }

        if (select) {
            int count_exercises = 0;
            for (int i = 0; i < 6; i++) {
                if (!exercises_text[i].getText().toString().equals("Select...")) {
                    count_exercises++;
                }
            }

            String selected[] = new String[count_exercises];
            int j = 0;
            for (int i = 0; i < 6; i++) {
                if (!exercises_text[i].getText().toString().equals("Select...")) {
                    selected[j] = exercises_text[i].getText().toString();
                    j++;
                }
            }

            Intent intent = new Intent(this, SelectSets.class);
            intent.putExtra(i_count_exercises, count_exercises);
            intent.putExtra(i_selected, selected);
            intent.putExtra(i_mode, mode);
            startActivity(intent);
        }
        else {
            Context context = getApplicationContext();
            CharSequence text = "Select at least one exercise";
            int duration = Toast.LENGTH_SHORT;

            Toast toast = Toast.makeText(context, text, duration);
            toast.show();
        }
    }

}
