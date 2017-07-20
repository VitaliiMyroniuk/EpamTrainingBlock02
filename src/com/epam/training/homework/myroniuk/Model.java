package com.epam.training.homework.myroniuk;

/**
 * Created by Vitalii on 19.07.2017.
 */
public class Model {
    private int min;
    private int max;
    private int x;

    // Getters
    public int getMin() {
        return min;
    }

    public int getMax() {
        return max;
    }

    // Setters
    public void setMin(int min) {
        this.min = min;
    }

    public void setMax(int max) {
        this.max = max;
    }

    /**
     * This method sets the number this.x to a random integer number from min to max (inclusively)
     * and updates values of this.min and this.max to min and max respectively.
     * @param min
     * @param max
     */
    public void rand(int min, int max) {
        this.min = min;
        this.max = max;
        double random = Math.random();
        x = (int) ((1 - random) * min + random * max);
    }

    /**
     * This method checks whether a given number inputNumber coincides with a number this.x.
     * @param inputNumber is the valid integer number entered by the user.
     * @return the value 0 if x == inputNumber;
     *         the value -1 if x < inputNumber; and
     *         the value 1 if x > inputNumber.
     */
    public int checkInputNumber(int inputNumber) {
        return Integer.compare(inputNumber, x);
    }
}
