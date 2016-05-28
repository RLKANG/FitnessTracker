package com.rlkang.richard.fitnesstracker;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    public final static String user_choice = "com.RLKANG.fitnesstracker.choice";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void Workout_Log (View view) {
        String parts[] = new String[] {"Arms", "Shoulders", "Chest", "Back", "Legs", "Other"};

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
        String parts[] = new String[] {"Arms", "Shoulders", "Chest", "Back", "Legs", "Other"};
        String choice= parts[num];

        Intent intent = new Intent(this, SelectionPanel.class);
        intent.putExtra(user_choice, choice);
        startActivity(intent);
    }
}
