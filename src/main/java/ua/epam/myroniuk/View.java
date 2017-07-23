package ua.epam.myroniuk;

/**
 * Created by Vitalii on 19.07.2017.
 */
public class View {
    // Text constants
    public static final String START_GAME = "THE GAME BEGINS!";
    public static final String DATA_INPUT = "Please, enter the integer number from %d to %d exclusively.";
    public static final String WRONG_INPUT_DATA = "Wrong input!";
    public static final String LESS = "The input number is less. Try again!";
    public static final String MORE = "The input number is more. Try again!";
    public static final String CONGRATULATIONS = "Congratulations! You have successfully guessed the number.";

    /**
     * This method prints a given message into console.
     * @param message message.
     */
    public void printMessage(String message){
        System.out.println(message);
    }

    /**
     * This method prints a given formatted string {@code format} into console.
     * @param format formatted string.
     * @param min the left bound of the interval that contains the secret number.
     * @param max the right bound of the interval that contains the secret number.
     */
    public void printMessage(String format, int min, int max){
        System.out.println(String.format(format, min, max));
    }
}
