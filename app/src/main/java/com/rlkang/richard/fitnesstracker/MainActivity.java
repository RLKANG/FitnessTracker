package com.rlkang.richard.fitnesstracker;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    public final static String user_choice = "com.RLKANG.fitnesstracker.choice";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void Workout_Log (View view) {
        String parts[] = new String[] {"Arms", "Shoulders", "Chest", "Back", "Legs"};

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Select Body Part");
        builder.setItems(parts, new DialogInterface.OnClickListener() {
            public void onClick (DialogInterface dialog, int num) {
                    Send_To_SelectionPanel(num);
            }
        });
        builder.show();
    }

    public void Send_To_SelectionPanel (int num) {
        String parts[] = new String[] {"Arms", "Shoulders", "Chest", "Back", "Legs"};
        String choice= parts[num];

        Intent intent = new Intent(this, SelectionPanel.class);
        intent.putExtra(user_choice, choice);
        startActivity(intent);
    }
}
