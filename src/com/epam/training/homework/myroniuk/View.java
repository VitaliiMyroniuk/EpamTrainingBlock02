package com.epam.training.homework.myroniuk;

/**
 * Created by Vitalii on 19.07.2017.
 */
public class View {
    // Text constants
    public static final String START_GAME = "THE GAME BEGINS!";
    public static final String DATA_INPUT = "Please, enter the integer number from %d to %d.";
    public static final String WRONG_INPUT_DATA = "Wrong input! Please, enter the integer number from %d to %d.";
    public static final String LESS = "The input number is less. Try again!";
    public static final String MORE = "The input number is more. Try again!";
    public static final String CONGRATULATIONS = "Congratulations! You have successfully guessed the number.";

    /**
     * This method prints a given message into console.
     * @param message
     */
    public void printMessage(String message){
        System.out.println(message);
    }

    /**
     * This method prints a given formatted string into console.
     * @param format
     * @param min
     * @param max
     */
    public void printMessage(String format, int min, int max){
        System.out.println(String.format(format, min, max));
    }
}
