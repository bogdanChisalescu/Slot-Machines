package com.example.slotmachines;

public class Player {

    private static float money;
    private static float bet;
    private boolean[] activeWin = new boolean[30];
    private final int[] winCoeff = {10, 10, 10, 5, 5, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3};
    private static int[][] slot = new int[15][5];
    private static float win;
    private Coeff[] winCoefficients = new Coeff[30];
    private static int[] frequency = new int[8];
    private static int[] afterWin = new int[30];


    public void initAfterWin(){

        for(int i = 0; i < 30; i++)
            afterWin[i] = 0;
    }

    public void initWinCoefficients(){

        for(int i = 0; i < 30; i++)
            winCoefficients[i] = new Coeff();


        winCoefficients[0].setI(1,1,1,1,1);
        winCoefficients[1].setI(0,0,0,0,0);
        winCoefficients[2].setI(2,2,2,2,2);
        winCoefficients[3].setI(0,1,2,1,0);
        winCoefficients[4].setI(2,1,0,1,2);
        winCoefficients[5].setI(1,0,0,0,1);
        winCoefficients[6].setI(1,2,2,2,1);
        winCoefficients[7].setI(0,0,1,2,2);
        winCoefficients[8].setI(2,2,1,0,0);
        winCoefficients[9].setI(1,2,1,0,1);
        winCoefficients[10].setI(1,0,1,2,1);
        winCoefficients[11].setI(0,1,1,1,0);
        winCoefficients[12].setI(2,1,1,1,2);
        winCoefficients[13].setI(0,1,0,1,0);
        winCoefficients[14].setI(2,1,2,1,2);
        winCoefficients[15].setI(1,1,0,1,1);
        winCoefficients[16].setI(1,1,2,1,1);
        winCoefficients[17].setI(0,0,2,0,0);
        winCoefficients[18].setI(2,2,0,2,2);
        winCoefficients[19].setI(0,2,2,2,0);
        winCoefficients[20].setI(2,0,0,0,2);
        winCoefficients[21].setI(1,2,0,2,1);
        winCoefficients[22].setI(1,0,2,0,1);
        winCoefficients[23].setI(0,2,0,2,0);
        winCoefficients[24].setI(2,0,2,0,2);
        winCoefficients[25].setI(0,2,1,0,2);
        winCoefficients[26].setI(2,0,1,2,0);
        winCoefficients[27].setI(1,0,2,1,2);
        winCoefficients[28].setI(0,2,1,2,0);
        winCoefficients[29].setI(2,1,0,0,1);

        for(int i = 0; i < 30; i++)
            winCoefficients[i].setJ(0,1,2,3,4);
        //can't believe I'm done with this
    }

    public void initSlot() {

        for (int i = 0; i < 15; i++)
            for (int j = 0; j < 5; j++)
                slot[i][j] = (int) (Math.random() * 8 + 1);
    }

    public void calculateWins(){

        for(int i = 0; i < 30; i++){ //go through all winning lines

            for(int j = 0; j < 5; j++) //required for j passing
                frequency[slot[winCoefficients[i].getI(j)][winCoefficients[i].getJ(j)] - 1]++; //frequency array

            for(int k = 0; k < 8; k++) //go through all numbers 1...8
                if(frequency[k] > 2) { //if we find an element at least 3 times
                    afterWin[i] += (k + 1) * frequency[k]; //we add to the line win the number multiplied by how many times it appeared
                    activeWin[i] = true; //we mark that we found a winning line
                }
            for(int k = 0; k < 8; k++)
                frequency[k] = 0; //reset the frequency array to prepare for the check-up of the next winning line
        }
    }

    public float returnWin(){

        int max = 0, index = -1;
        for(int i = 0; i < 30; i++)
            if(afterWin[i] > max && activeWin[i]) {
                max = afterWin[i];
                index = i;
            }

        if(index != -1) return (afterWin[index] + winCoeff[index]) * bet * (float)0.1 / (float)1.5; //multiply the bet by 0.1 because the win is high by design
        else return 0;

    }

    public void setMoney(float amount){

        money = amount;
    }

    public float getMoney(){

        return money;
    }

    public void setBet(float amount){

        bet = amount;
    }

    public float getBet(){

        return bet;
    }

    public int getSlot(int i, int j){

        return slot[i][j];
    }

    public void flushWin(){

        for(int i = 0; i < activeWin.length; i++) activeWin[i] = false;
    }

}

