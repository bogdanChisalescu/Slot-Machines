package com.example.slotmachines;

public class Coeff {

    private int[] I = new int[5];
    private int[] J = new int[5];

    public void setI(int i1, int i2, int i3, int i4, int i5) {
        I[0] = i1;
        I[1] = i2;
        I[2] = i3;
        I[3] = i4;
        I[4] = i5;
    }

    public void setJ(int j1, int j2, int j3, int j4, int j5) {
        J[0] = j1;
        J[1] = j2;
        J[2] = j3;
        J[3] = j4;
        J[4] = j5;
    }

    public int getI(int i) {
        return I[i];
    }

    public int getJ(int j) {
        return J[j];
    }

}
