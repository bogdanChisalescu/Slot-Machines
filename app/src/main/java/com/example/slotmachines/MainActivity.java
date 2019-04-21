package com.example.slotmachines;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); //sets the layout defined in activity_main
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE); //sets the orientation of the screen to landscape
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN); //makes the app enter fullscreen

            //declaring main menu buttons
        Button exitButton = findViewById(R.id.ExitButton);
        Button settingsButton = findViewById(R.id.SettingsButton);
        Button showButton = findViewById(R.id.ShowMoney);
        Button startButton = findViewById(R.id.StartButton);

        final Intent slotsIntent = new Intent(this, Slots.class);//required to start the second activity

        exitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.super.onBackPressed();
            }
        });


        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(slotsIntent);
            }
        });
        //write new code here
    }


    @Override //don't touch this for the moment
    protected void onResume() {
        super.onResume();


}

    @Override //Don't touch this
    public void onBackPressed() {

        AlertDialog.Builder builder;
        builder = new AlertDialog.Builder(this);

        builder.setMessage("Lost enough money (exit) ? ");

        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                MainActivity.super.onBackPressed();
            }
        });

        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });

        builder.show();


    }
}
