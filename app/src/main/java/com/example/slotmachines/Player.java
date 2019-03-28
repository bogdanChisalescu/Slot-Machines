package com.example.slotmachines;

public class Player {

    private static float money;
    private static float bet; //should have a minimum and maximum value, deal with it in android studio
    private boolean[] activeWin = new boolean[30];
    private final int[] winCoeff = {10, 10, 10, 5, 5, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3};
    private int[][] slot = new int[15][5];
    private static float win;


    public void initSlot() {

        for (int i = 0; i < 15; i++)
            for (int j = 0; j < 5; j++)
                slot[i][j] = (int) (Math.random() * 5 + 1);
    }

    public void calculateWins(){

        activeWin[0] = returnTruth(slot[1][0], slot[1][1], slot[1][2], slot[1][3], slot[1][4]);
        activeWin[1] = returnTruth(slot[0][0], slot[0][1], slot[0][2], slot[0][3], slot[0][4]);
        activeWin[2] = returnTruth(slot[2][0], slot[2][1], slot[2][2], slot[2][3], slot[2][4]);
        activeWin[3] = returnTruth(slot[0][0], slot[1][1], slot[2][2], slot[1][3], slot[0][4]);
        activeWin[4] = returnTruth(slot[2][0], slot[1][1], slot[0][2], slot[1][3], slot[2][4]);
        activeWin[5] = returnTruth(slot[1][0], slot[0][1], slot[0][2], slot[0][3], slot[1][4]);
        activeWin[6] = returnTruth(slot[1][0], slot[2][1], slot[2][2], slot[2][3], slot[1][4]);
        activeWin[7] = returnTruth(slot[0][0], slot[0][1], slot[1][2], slot[2][3], slot[2][4]);
        activeWin[8] = returnTruth(slot[2][0], slot[2][1], slot[1][2], slot[0][3], slot[0][4]);
        activeWin[9] = returnTruth(slot[1][0], slot[2][1], slot[1][2], slot[0][3], slot[1][4]);
        activeWin[10] = returnTruth(slot[1][0], slot[0][1], slot[1][2], slot[2][3], slot[1][4]);
        activeWin[11] = returnTruth(slot[0][0], slot[1][1], slot[1][2], slot[1][3], slot[0][4]);
        activeWin[12] = returnTruth(slot[2][0], slot[1][1], slot[1][2], slot[1][3], slot[2][4]);
        activeWin[13] = returnTruth(slot[0][0], slot[1][1], slot[0][2], slot[1][3], slot[0][4]);
        activeWin[14] = returnTruth(slot[2][0], slot[1][1], slot[2][2], slot[1][3], slot[2][4]);
        activeWin[15] = returnTruth(slot[1][0], slot[1][1], slot[0][2], slot[1][3], slot[1][4]);
        activeWin[16] = returnTruth(slot[1][0], slot[1][1], slot[2][2], slot[1][3], slot[1][4]);
        activeWin[17] = returnTruth(slot[0][0], slot[0][1], slot[2][2], slot[0][3], slot[0][4]);
        activeWin[18] = returnTruth(slot[2][0], slot[2][1], slot[0][2], slot[2][3], slot[2][4]);
        activeWin[19] = returnTruth(slot[0][0], slot[2][1], slot[2][2], slot[2][3], slot[0][4]);
        activeWin[20] = returnTruth(slot[2][0], slot[0][1], slot[0][2], slot[0][3], slot[2][4]);
        activeWin[21] = returnTruth(slot[1][0], slot[2][1], slot[0][2], slot[2][3], slot[1][4]);
        activeWin[22] = returnTruth(slot[1][0], slot[0][1], slot[2][2], slot[0][3], slot[1][4]);
        activeWin[23] = returnTruth(slot[0][0], slot[2][1], slot[0][2], slot[2][3], slot[0][4]);
        activeWin[24] = returnTruth(slot[2][0], slot[0][1], slot[2][2], slot[0][3], slot[2][4]);
        activeWin[25] = returnTruth(slot[0][0], slot[2][1], slot[1][2], slot[0][3], slot[2][4]);
        activeWin[26] = returnTruth(slot[2][0], slot[0][1], slot[1][2], slot[2][3], slot[0][4]);
        activeWin[27] = returnTruth(slot[1][0], slot[0][1], slot[2][2], slot[1][3], slot[2][4]);
        activeWin[28] = returnTruth(slot[0][0], slot[2][1], slot[1][2], slot[2][3], slot[0][4]);
        activeWin[29] = returnTruth(slot[2][0], slot[1][1], slot[0][2], slot[0][3], slot[1][4]);
        //can't believe i'm done with this
    }

    private boolean returnTruth(int s1, int s2, int s3, int s4, int s5){

        if(s1 == s2 && s3 == s4 && s2 == s3 && s5 == s2) return true;
        else return false;

    }

    public float returnWin(){

        int max = winCoeff[0], index = -1;
        for(int i = 0;i < winCoeff.length; i++)
            if(winCoeff[i] >= max && activeWin[i] == true) {
                max = winCoeff[i];
                index = i;
            }

        if(index != -1) return winCoeff[index] * bet;
        else return 0;
    }

    public void setMoney(float amount){

        money += amount;
    }

    public float getMoney(){

        return money;
    }

    public void setBet(float amount){

        bet += amount;
    }

    public float getBet(){

        return bet;
    }

    public void flushWin(){

        for(int i = 0; i < activeWin.length; i++) activeWin[i] = false;
    }

}
