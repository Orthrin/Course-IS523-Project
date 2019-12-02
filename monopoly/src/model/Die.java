package model;

import java.util.Random;

public class Die {

    int faceValue;
    private static Random random = new Random();

    public Die() {

    }

    public int getFaceValue() {
        return faceValue;
    }

    public void roll() {
        faceValue = random.nextInt(6) + 1;
    }

}
