package com.example.slotmachines;

import android.content.pm.ActivityInfo;
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

        Button exitButton = findViewById(R.id.ExitButton);
        Button settingsButton = findViewById(R.id.SettingsButton);
        Button showButton = findViewById(R.id.ShowMoney);
        Button startButton = findViewById(R.id.StartButton);

        //write new code here
    }


    @Override
    protected void onResume() {
        super.onResume();


    }

}
