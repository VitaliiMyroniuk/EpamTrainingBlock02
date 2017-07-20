package com.epam.training.homework.myroniuk;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Created by Vitalii on 19.07.2017.
 */
public class Controller {
    // Model and View
    private Model model;
    private View view;

    // Constructor
    public Controller(Model model, View view) {
        this.model = model;
        this.view = view;
    }

    /**
     * This method starts a game for integer numbers from min to max (inclusively).
     * @param min
     * @param max
     */
    public void startGame(int min, int max) {
        view.printMessage(View.START_GAME);
        model.rand(min, max);

        while(true) {
            int inputNumber = this.getInputNumber();
            int tmp = model.checkInputNumber(inputNumber);

            if (tmp < 0) {
                view.printMessage(View.LESS, model.getMin(), model.getMax());
                model.setMin(inputNumber);
            } else if (tmp > 0) {
                view.printMessage(View.MORE, model.getMin(), model.getMax());
                model.setMax(inputNumber);
            } else {
                view.printMessage(View.CONGRATULATIONS);
                break;
            }
        }
    }

    /**
     * This method starts a game for integer numbers from 0 to 2147483647 (inclusively).
     */
    public void startGame() {
        startGame(0, Integer.MAX_VALUE);
    }

    /**
     * This method asks the user to enter the valid integer number.
     * @return the valid integer number entered by user.
     */
    private int getInputNumber() {
        view.printMessage(View.DATA_INPUT, model.getMin(), model.getMax());
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            try {
                int tmp = Integer.parseInt(reader.readLine());

                if ((tmp < model.getMin()) || (model.getMax() < tmp)) {
                    view.printMessage(View.WRONG_INPUT_DATA, model.getMin(), model.getMax());
                } else {
                    return tmp;
                }
            } catch (Exception e) {
                view.printMessage(View.WRONG_INPUT_DATA, model.getMin(), model.getMax());
            }
        }
    }
}
