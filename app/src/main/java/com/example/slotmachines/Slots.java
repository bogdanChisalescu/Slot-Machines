package com.example.slotmachines;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class Slots extends AppCompatActivity {

    //Variable & some UI elements declarations
    static float win;
    static float bet;
    static float money;
    boolean spinning;
    boolean NuPrimaRulare=false;
    Player Raul = new Player();
    Button spinButton;
    Button autoSpinButton;
    Button increaseBet;
    Button decreaseBet;
    TextView WinText;
    TextView BalanceText;
    TextView BetText;
    int i,j,k;

    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;

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

        sharedPreferences = this.getSharedPreferences("sharedPref", 0);
        editor = sharedPreferences.edit();
        SetFullscreen();
        //UI elements declarations
        increaseBet = findViewById(R.id.right);
        decreaseBet = findViewById(R.id.left);
        spinButton = findViewById(R.id.SpinButton);
        autoSpinButton = findViewById(R.id.AutoSpinButton);
        WinText = findViewById(R.id.Win);
        BalanceText = findViewById(R.id.Balance);
        BetText = findViewById(R.id.Bet);

        //load the money variable stored in permanent memory
        money = sharedPreferences.getFloat("userMoney", 1000);
        Raul.setMoney(money); //sets the money variable to be used by the Player class to perform calculations

        //load the bet variable stored in permanent memory
        bet = sharedPreferences.getFloat("userBet", 2);
        Raul.setBet(bet); //sets the bet variable to be used by the Player class to perform calculations

        Raul.initWinCoefficients(); //sets the winning lines

        BetText.setText(Float.toString(bet));
        BalanceText.setText(Float.toString(money));

        //image1.setBackgroundResource(R.drawable.img1);
        for (i = 0; i < 75; i++) {   //loads the image views into image array
            image.add((ImageView) findViewById(getResources().getIdentifier("imageView" + (i + 1), "id", getPackageName())));
        }


        int dur=1000;
        for (i = 0; i < 15; i++) {   //defines the animation type and duration for the image array elements
            ecranul.add(ObjectAnimator.ofFloat(image.get(i+60), "translationY", 0, 2800));
            ecranul.get(i).setDuration(dur);
            cascada.add(ObjectAnimator.ofFloat(image.get(i), "translationY", -2800, 0));
            cascada.get(i).setDuration(dur);
            cascada1.add(ObjectAnimator.ofFloat(image.get(i + 30), "translationY", -2100, 700));
            cascada1.get(i).setDuration(dur);
            cascada2.add(ObjectAnimator.ofFloat(image.get(i + 45), "translationY", -1400, 1400));
            cascada2.get(i).setDuration(dur);
            cascada3.add(ObjectAnimator.ofFloat(image.get(i + 15), "translationY", -700, 2100));
            cascada3.get(i).setDuration(dur);
        }



    }

    @Override
    protected void onResume() {
        super.onResume();
        SetFullscreen();
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);

        final AnimatorSet AnimCas = new AnimatorSet();
        final AnimatorSet AnimCas1 = new AnimatorSet();
        final AnimatorSet AnimCas2 = new AnimatorSet();
        final AnimatorSet AnimCas3 = new AnimatorSet();
        final AnimatorSet AnimEcr = new AnimatorSet();

       final AlertDialog.Builder message = new AlertDialog.Builder(Slots.this, R.style.MyDialogTheme);

        spinButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (money >= bet) {

                    money -= bet;

                    if(NuPrimaRulare){    //ia setul de imagini din vechia rulare si le scrie pe noua rulare sa evite o rescriere a elementelor direct pe ecranul utilizatorului
                        for (i = 12; i < 15; i++)
                            for (j = 0; j < 5; j++) {
                                if (Raul.getSlot(i-12, j) == 1)
                                    image.get(i * 5 + j).setImageResource(R.drawable.bobina);
                                else if (Raul.getSlot(i-12, j) == 2)
                                    image.get(i * 5 + j).setImageResource(R.drawable.condensator);
                                else if (Raul.getSlot(i-12, j) == 3)
                                    image.get(i * 5 + j).setImageResource(R.drawable.dioda);
                                else if (Raul.getSlot(i-12, j) == 4)
                                    image.get(i * 5 + j).setImageResource(R.drawable.resistor);
                                else if (Raul.getSlot(i-12, j) == 5)
                                    image.get(i * 5 + j).setImageResource(R.drawable.transistor);
                                else if (Raul.getSlot(i-12, j) == 6)
                                    image.get(i * 5 + j).setImageResource(R.drawable.q);
                                else if (Raul.getSlot(i-12, j) == 7)
                                    image.get(i * 5 + j).setImageResource(R.drawable.k);
                                else if (Raul.getSlot(i-12, j) == 8)
                                    image.get(i * 5 + j).setImageResource(R.drawable.j);
                            }
                         }else{
                        AnimCas.play(cascada.get(0)).with(cascada.get(1)).with(cascada.get(2)).with(cascada.get(3)).with(cascada.get(4)).with(cascada.get(5)).with(cascada.get(6)).with(cascada.get(7)).with(cascada.get(8)).with(cascada.get(9)).with(cascada.get(10)).with(cascada.get(11)).with(cascada.get(12)).with(cascada.get(13)).with(cascada.get(14));
                        AnimCas1.play(cascada1.get(0)).with(cascada1.get(1)).with(cascada1.get(2)).with(cascada1.get(3)).with(cascada1.get(4)).with(cascada1.get(5)).with(cascada1.get(6)).with(cascada1.get(7)).with(cascada1.get(8)).with(cascada1.get(9)).with(cascada1.get(10)).with(cascada1.get(11)).with(cascada1.get(12)).with(cascada1.get(13)).with(cascada1.get(14));
                        AnimCas2.play(cascada2.get(0)).with(cascada2.get(1)).with(cascada2.get(2)).with(cascada2.get(3)).with(cascada2.get(4)).with(cascada2.get(5)).with(cascada2.get(6)).with(cascada2.get(7)).with(cascada2.get(8)).with(cascada2.get(9)).with(cascada2.get(10)).with(cascada2.get(11)).with(cascada2.get(12)).with(cascada2.get(13)).with(cascada2.get(14));
                        AnimCas3.play(cascada3.get(0)).with(cascada3.get(1)).with(cascada3.get(2)).with(cascada3.get(3)).with(cascada3.get(4)).with(cascada3.get(5)).with(cascada3.get(6)).with(cascada3.get(7)).with(cascada3.get(8)).with(cascada3.get(9)).with(cascada3.get(10)).with(cascada3.get(11)).with(cascada3.get(12)).with(cascada3.get(13)).with(cascada3.get(14));
                        AnimEcr.play(ecranul.get(0)).with(ecranul.get(1)).with(ecranul.get(2)).with(ecranul.get(3)).with(ecranul.get(4)).with(ecranul.get(5)).with(ecranul.get(6)).with(ecranul.get(7)).with(ecranul.get(8)).with(ecranul.get(9)).with(ecranul.get(10)).with(ecranul.get(11)).with(ecranul.get(12)).with(ecranul.get(13)).with(ecranul.get(14));

                    }

                    Raul.initSlot();
                    Raul.initAfterWin();

                    for (i = 0; i < 12; i++)
                        for (j = 0; j < 5; j++) {
                            if (Raul.getSlot(i, j) == 1)
                                image.get(i * 5 + j).setImageResource(R.drawable.bobina);
                            else if (Raul.getSlot(i, j) == 2)
                                image.get(i * 5 + j).setImageResource(R.drawable.condensator);
                                else if (Raul.getSlot(i, j) == 3)
                                image.get(i * 5 + j).setImageResource(R.drawable.dioda);
                            else if (Raul.getSlot(i, j) == 4)
                                image.get(i * 5 + j).setImageResource(R.drawable.resistor);
                            else if (Raul.getSlot(i, j) == 5)
                                image.get(i * 5 + j).setImageResource(R.drawable.transistor);
                            else if (Raul.getSlot(i, j) == 6)
                                image.get(i * 5 + j).setImageResource(R.drawable.q);
                            else if (Raul.getSlot(i, j) == 7)
                                image.get(i * 5 + j).setImageResource(R.drawable.k);
                             else if (Raul.getSlot(i, j) == 8)
                                image.get(i * 5 + j).setImageResource(R.drawable.j);
                        }

                    Raul.calculateWins();
                    win = (int)Raul.returnWin();

                    //loads animations into each animator set
                     AnimCas.start(); //commands the start of the animations
                    AnimCas1.start();
                    AnimCas2.start();
                    AnimCas3.start();
                    AnimEcr.start();
                    NuPrimaRulare=true;

                    money += win;
                    Raul.flushWin();
                    WinText.setText(Float.toString(win));
                    BalanceText.setText(Float.toString(money));


                }
                else {
                   message.setMessage("Not enough money")    //incrementor de balance pt debugging
                            .setPositiveButton("Add 1000", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    money += 1000;
                                    BalanceText.setText(Float.toString(money));
                                }
                            });
                    message.show();
                }
            }
        });

        autoSpinButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { //ruleaza pana gaseste win-ul sau bet>money
                spinning=true;
                while (spinning == true) {
                    if (money >= bet) {

                        money -= bet;

                        if(NuPrimaRulare){    //ia setul de imagini din vechia rulare si le scrie pe noua rulare sa evite o rescriere a elementelor direct pe ecranul utilizatorului
                        for (i = 12; i < 15; i++)
                            for (j = 0; j < 5; j++) {
                                if (Raul.getSlot(i-12, j) == 1)
                                    image.get(i * 5 + j).setImageResource(R.drawable.bobina);
                                else if (Raul.getSlot(i-12, j) == 2)
                                    image.get(i * 5 + j).setImageResource(R.drawable.condensator);
                                else if (Raul.getSlot(i-12, j) == 3)
                                    image.get(i * 5 + j).setImageResource(R.drawable.dioda);
                                else if (Raul.getSlot(i-12, j) == 4)
                                    image.get(i * 5 + j).setImageResource(R.drawable.resistor);
                                else if (Raul.getSlot(i-12, j) == 5)
                                    image.get(i * 5 + j).setImageResource(R.drawable.transistor);
                                else if (Raul.getSlot(i-12, j) == 6)
                                    image.get(i * 5 + j).setImageResource(R.drawable.q);
                                else if (Raul.getSlot(i-12, j) == 7)
                                    image.get(i * 5 + j).setImageResource(R.drawable.k);
                                else if (Raul.getSlot(i-12, j) == 8)
                                    image.get(i * 5 + j).setImageResource(R.drawable.j);
                            }
                        }else{
                            AnimCas.play(cascada.get(0)).with(cascada.get(1)).with(cascada.get(2)).with(cascada.get(3)).with(cascada.get(4)).with(cascada.get(5)).with(cascada.get(6)).with(cascada.get(7)).with(cascada.get(8)).with(cascada.get(9)).with(cascada.get(10)).with(cascada.get(11)).with(cascada.get(12)).with(cascada.get(13)).with(cascada.get(14));
                            AnimCas1.play(cascada1.get(0)).with(cascada1.get(1)).with(cascada1.get(2)).with(cascada1.get(3)).with(cascada1.get(4)).with(cascada1.get(5)).with(cascada1.get(6)).with(cascada1.get(7)).with(cascada1.get(8)).with(cascada1.get(9)).with(cascada1.get(10)).with(cascada1.get(11)).with(cascada1.get(12)).with(cascada1.get(13)).with(cascada1.get(14));
                            AnimCas2.play(cascada2.get(0)).with(cascada2.get(1)).with(cascada2.get(2)).with(cascada2.get(3)).with(cascada2.get(4)).with(cascada2.get(5)).with(cascada2.get(6)).with(cascada2.get(7)).with(cascada2.get(8)).with(cascada2.get(9)).with(cascada2.get(10)).with(cascada2.get(11)).with(cascada2.get(12)).with(cascada2.get(13)).with(cascada2.get(14));
                            AnimCas3.play(cascada3.get(0)).with(cascada3.get(1)).with(cascada3.get(2)).with(cascada3.get(3)).with(cascada3.get(4)).with(cascada3.get(5)).with(cascada3.get(6)).with(cascada3.get(7)).with(cascada3.get(8)).with(cascada3.get(9)).with(cascada3.get(10)).with(cascada3.get(11)).with(cascada3.get(12)).with(cascada3.get(13)).with(cascada3.get(14));
                            AnimEcr.play(ecranul.get(0)).with(ecranul.get(1)).with(ecranul.get(2)).with(ecranul.get(3)).with(ecranul.get(4)).with(ecranul.get(5)).with(ecranul.get(6)).with(ecranul.get(7)).with(ecranul.get(8)).with(ecranul.get(9)).with(ecranul.get(10)).with(ecranul.get(11)).with(ecranul.get(12)).with(ecranul.get(13)).with(ecranul.get(14));

                        }

                        Raul.initSlot();

                        for (i = 0; i < 12; i++)
                            for (j = 0; j < 5; j++) {
                                if (Raul.getSlot(i, j) == 1)
                                    image.get(i * 5 + j).setImageResource(R.drawable.bobina);
                                else if (Raul.getSlot(i, j) == 2)
                                    image.get(i * 5 + j).setImageResource(R.drawable.condensator);
                                else if (Raul.getSlot(i, j) == 3)
                                    image.get(i * 5 + j).setImageResource(R.drawable.dioda);
                                else if (Raul.getSlot(i, j) == 4)
                                    image.get(i * 5 + j).setImageResource(R.drawable.resistor);
                                else if (Raul.getSlot(i, j) == 5)
                                    image.get(i * 5 + j).setImageResource(R.drawable.transistor);
                                else if (Raul.getSlot(i, j) == 6)
                                    image.get(i * 5 + j).setImageResource(R.drawable.q);
                                else if (Raul.getSlot(i, j) == 7)
                                    image.get(i * 5 + j).setImageResource(R.drawable.k);
                                else if (Raul.getSlot(i, j) == 8)
                                    image.get(i * 5 + j).setImageResource(R.drawable.j);
                            }

                        Raul.calculateWins();
                        win = Raul.returnWin();
  //loads animations into each animator set
                          //AnimCas.start(); //commands the start of the animations
                        //AnimCas1.start();
                        //AnimCas2.start();
                        //AnimCas3.start();
                        //AnimEcr.start();
                        NuPrimaRulare=true;

                        money += win;
                        Raul.flushWin();
                        WinText.setText(Float.toString(win));
                        BalanceText.setText(Float.toString(money));
                        if(win!=0){
                            message.setMessage("You Won!")//blocheaza rularea pt debugging
                             .setPositiveButton("GG", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                             }
                            });
                            message.show();
                            spinning=false;
                        }

                    } else {
                        spinning=false;
                        message.setMessage("Not enough money")  //incrementor de balance pt debugging
                                .setPositiveButton("Add 1000", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        money += 1000;
                                        BalanceText.setText(Float.toString(money));
                                    }
                                });
                        message.show();
                    }
                }
            }
        });

        increaseBet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (bet < 10) {

                    bet += 2;
                    Raul.setBet(bet);
                    BetText.setText(Float.toString(bet));
                }
            }
        });


        decreaseBet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (bet > 2) {

                    bet -= 2;
                    Raul.setBet(bet);
                    BetText.setText(Float.toString(bet));
                }
            }
        });

    }

    @Override
    protected void onStop() {
        super.onStop();
        SetFullscreen();
        editor.putFloat("userMoney", money);
        editor.putFloat("userBet", bet);
        editor.commit();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        editor.putFloat("userMoney", money);
        editor.putFloat("userBet", bet);
        editor.commit();
    }

    protected void onRestart() {
        super.onRestart();
        SetFullscreen();

    }

    public void SetFullscreen() {
        final View decorView = getWindow().getDecorView();
        decorView.setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                        | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);

        decorView.setOnSystemUiVisibilityChangeListener (new View.OnSystemUiVisibilityChangeListener() {
            @Override
            public void onSystemUiVisibilityChange(int visibility) {
                if ((visibility & View.SYSTEM_UI_FLAG_FULLSCREEN) == 0) {
                    decorView.setSystemUiVisibility(
                            View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                                    | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                                    | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                                    | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                                    | View.SYSTEM_UI_FLAG_FULLSCREEN
                                    | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);
                }
            }
        });
    }

}