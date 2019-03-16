package com.example.slotmachines;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    static int counter;

    @Override
    protected void onResume() {
        super.onResume();
        Button pressME = findViewById(R.id.button);
        final TextView display = findViewById(R.id.hello);

        pressME.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                counter++;
                display.setText(Integer.toString(counter));
            }
        });


    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {

        counter = outState.getInt("counter");
        super.onSaveInstanceState(outState);
    }
}
