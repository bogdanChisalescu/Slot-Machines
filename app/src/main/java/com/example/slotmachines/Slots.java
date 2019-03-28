package com.example.slotmachines;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class Slots extends AppCompatActivity {

    //Variable & some UI elements declarations
    static float win;
    static float bet = 2;
    static float money = 0;
    String Money;
    String Bet;
    Player Raul = new Player();
    Button spinButton;
    Button increaseBet;
    Button decreaseBet;
    TextView WinText;
    TextView BalanceText;
    TextView BetText;
    int i;

    SharedPreferences load; //used to store the value of money variable and bet variable

    ArrayList<ImageView> image = new ArrayList<ImageView>();

    ArrayList<ObjectAnimator> cascada = new ArrayList<ObjectAnimator>();
    ArrayList<ObjectAnimator> cascada1 = new ArrayList<ObjectAnimator>();
    ArrayList<ObjectAnimator> cascada2 = new ArrayList<ObjectAnimator>();
    ArrayList<ObjectAnimator> cascada3 = new ArrayList<ObjectAnimator>();
    ArrayList<ObjectAnimator> ecranul = new ArrayList<ObjectAnimator>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_slots);
        View overlay = findViewById(R.id.layout);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE); //sets the orientation of the screen to landscape
        overlay.setSystemUiVisibility(View.SYSTEM_UI_FLAG_HIDE_NAVIGATION|View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY|View.SYSTEM_UI_FLAG_FULLSCREEN);

        //UI elements declarations
        increaseBet = findViewById(R.id.right);
        decreaseBet = findViewById(R.id.left);
        spinButton = findViewById(R.id.SpinButton);
        WinText = findViewById(R.id.Win);
        BalanceText = findViewById(R.id.Balance);
        BetText = findViewById(R.id.Bet);

        //load the money variable stored in permanent memory
        /*load = getSharedPreferences("userMoney", 0);
        Money = load.getString("userMoney", "100");
        money = Float.parseFloat(Money);
        Raul.setMoney(money); //sets the money variable to be used by the Player class to perform calculations

        //load the bet variable stored in permanent memory
        load = getSharedPreferences("userBet", 0);
        Bet  =load.getString("userBet", "1");
        bet = Float.parseFloat(Bet);
        Raul.setBet(bet); //sets the bet variable to be used by the Player class to perform calculations

    */
        BetText.setText(Float.toString(bet));
        BalanceText.setText(Float.toString(money));

        //image1.setBackgroundResource(R.drawable.img1);
        // image2.setBackgroundResource(R.drawable.img2);
        for(i=0;i<75;i++) {
            image.add((ImageView) findViewById(getResources().getIdentifier("imageView" + (i + 1), "id", getPackageName())));
        }


        for(i=0;i<15;i++) {
            ecranul.add(ObjectAnimator.ofFloat(image.get(i), "translationY",  0, 2800));
            ecranul.get(i).setDuration(1000);
            cascada.add(ObjectAnimator.ofFloat(image.get(i+15), "translationY", -2800, 0));
            cascada.get(i).setDuration(1000);
            cascada1.add(ObjectAnimator.ofFloat(image.get(i+30), "translationY", -2100, 700));
            cascada1.get(i).setDuration(1000);
            cascada2.add(ObjectAnimator.ofFloat(image.get(i+45), "translationY", -1400, 1400));
            cascada2.get(i).setDuration(1000);
            cascada3.add(ObjectAnimator.ofFloat(image.get(i+60), "translationY", -700, 2100));
            cascada3.get(i).setDuration(1000);
        }

    }

    @Override
    protected void onResume() {
        super.onResume();

        final AnimatorSet AnimCas = new AnimatorSet();
        final AnimatorSet AnimCas1 = new AnimatorSet();
        final AnimatorSet AnimCas2 = new AnimatorSet();
        final AnimatorSet AnimCas3 = new AnimatorSet();
        final AnimatorSet AnimEcr = new AnimatorSet();

        spinButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(money >= bet) {


                    money -= bet;
                    Raul.initSlot();
                    Raul.calculateWins();
                    win = Raul.returnWin();

                    AnimCas.play(cascada.get(0)).with(cascada.get(1)).with(cascada.get(2)).with(cascada.get(3)).with(cascada.get(4)).with(cascada.get(5)).with(cascada.get(6)).with(cascada.get(7)).with(cascada.get(8)).with(cascada.get(9)).with(cascada.get(10)).with(cascada.get(11)).with(cascada.get(12)).with(cascada.get(13)).with(cascada.get(14));
                    AnimCas1.play(cascada1.get(0)).with(cascada1.get(1)).with(cascada1.get(2)).with(cascada1.get(3)).with(cascada1.get(4)).with(cascada1.get(5)).with(cascada1.get(6)).with(cascada1.get(7)).with(cascada1.get(8)).with(cascada1.get(9)).with(cascada1.get(10)).with(cascada1.get(11)).with(cascada1.get(12)).with(cascada1.get(13)).with(cascada1.get(14));
                    AnimCas2.play(cascada2.get(0)).with(cascada2.get(1)).with(cascada2.get(2)).with(cascada2.get(3)).with(cascada2.get(4)).with(cascada2.get(5)).with(cascada2.get(6)).with(cascada2.get(7)).with(cascada2.get(8)).with(cascada2.get(9)).with(cascada2.get(10)).with(cascada2.get(11)).with(cascada2.get(12)).with(cascada2.get(13)).with(cascada2.get(14));
                    AnimCas3.play(cascada3.get(0)).with(cascada3.get(1)).with(cascada3.get(2)).with(cascada3.get(3)).with(cascada3.get(4)).with(cascada3.get(5)).with(cascada3.get(6)).with(cascada3.get(7)).with(cascada3.get(8)).with(cascada3.get(9)).with(cascada3.get(10)).with(cascada3.get(11)).with(cascada3.get(12)).with(cascada3.get(13)).with(cascada3.get(14));
                    AnimEcr.play(ecranul.get(0)).with(ecranul.get(1)).with(ecranul.get(2)).with(ecranul.get(3)).with(ecranul.get(4)).with(ecranul.get(5)).with(ecranul.get(6)).with(ecranul.get(7)).with(ecranul.get(8)).with(ecranul.get(9)).with(ecranul.get(10)).with(ecranul.get(11)).with(ecranul.get(12)).with(ecranul.get(13)).with(ecranul.get(14));
                    AnimCas.start();
                    AnimCas1.start();
                    AnimCas2.start();
                    AnimCas3.start();
                    AnimEcr.start();

                    money += win;
                    Raul.flushWin();
                    WinText.setText(Float.toString(win));
                    BalanceText.setText(Float.toString(money));

                }
                else{
                    //show a message
                }
            }
        });


        increaseBet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(bet < 10){

                    bet += 2;
                    Raul.setBet(bet);
                    BetText.setText(Float.toString(bet));
                }
            }
        });


        decreaseBet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(bet > 2){

                    bet -= 2;
                    Raul.setBet(bet);
                    BetText.setText(Float.toString(bet));
                }
            }
        });

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        /*SharedPreferences erase = getSharedPreferences("userMoney", 0);
        erase.edit().remove(Money).commit();
        erase = getSharedPreferences("userBet", 0);
        erase.edit().remove(Bet).commit();*/
        /*
        SharedPreferences.Editor save = load.edit();
        save.putString("userMoney", Float.toString(money)).commit();
        save.putString("userBet", Float.toString(bet)).commit();
        */
    }
}

