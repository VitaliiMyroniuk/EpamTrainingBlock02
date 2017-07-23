package ua.epam.myroniuk;

/**
 * Created by Vitalii on 19.07.2017.
 */
public class Model {
    /** The left bound of the interval that contains the secret number. */
    private int min;

    /** The right bound of the interval that contains the secret number. */
    private int max;

    /** The secret number */
    private int secretNumber;

    // Getters
    public int getMin() {
        return min;
    }

    public int getMax() {
        return max;
    }

    public int getSecretNumber() {
        return secretNumber;
    }

    // Setters
    public void setMin(int min) {
        this.min = min;
    }

    public void setMax(int max) {
        this.max = max;
    }

    public void setSecretNumber(int secretNumber) {
        this.secretNumber = secretNumber;
    }

    /**
     * This method assigns the number {@code secretNumber} to a random integer number
     * from {@code min} to {@code max} exclusively.
     * It also updates values of {@code this.min} and {@code this.max}
     * to given {@code min} and {@code max} respectively.
     * It throws IllegalArgumentException if {@code max - min <= 1}.
     * @param min the left bound of the interval that contains the secret number.
     * @param max the right bound of the interval that contains the secret number.
     */
    public void rand(int min, int max) {
        long dif = (long) max - min;

        if (dif > 1) {
            this.min = min;
            this.max = max;
            secretNumber = min + ((int) (dif * Math.random()));
        }
        else {
            throw new IllegalArgumentException();
        }
    }

    /**
     * This method checks whether a given number {@code inputNumber} coincides with {@code secretNumber}.
     * @param inputNumber the integer number entered by the user.
     * @return the value {@code -2} if inputNumber does not belong to the expected interval;
     *         the value {@code -1} if {@code inputNumber < secretNumber};
     *         the value {@code 0} if {@code secretNumber == inputNumber};
     *         the value {@code 1} if {@code secretNumber < inputNumber}.
     */
    public int checkInputNumber(int inputNumber) {
        if ((inputNumber <= min) || (inputNumber >= max)) {
            return -2;
        }
        else if (inputNumber < secretNumber) {
            min = inputNumber;
            return -1;
        }
        else if (inputNumber > secretNumber) {
            max = inputNumber;
            return 1;
        }
        else {
            return 0;
        }
    }
}
