package ua.epam.myroniuk;

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
     * This method starts a game for integer numbers from {@code min} to {@code max} exclusively.
     * @param min the left bound of the interval that contains the secret number.
     * @param max the right bound of the interval that contains the secret number.
     */
    public void startGame(int min, int max) {
        view.printMessage(View.START_GAME);
        model.rand(min, max);

        while(true) {
            int inputNumber = getInputNumber();
            int tmp = model.checkInputNumber(inputNumber);

            if (tmp == -1) {
                view.printMessage(View.LESS, model.getMin(), model.getMax());
            } else if (tmp == 1) {
                view.printMessage(View.MORE, model.getMin(), model.getMax());
            } else if (tmp == 0) {
                view.printMessage(View.CONGRATULATIONS);
                break;
            } else {
                view.printMessage(View.WRONG_INPUT_DATA);
            }
        }
    }

    /**
     * This method starts a game for integer numbers from {@code 0} to {@code Integer.MAX_VALUE} exclusively.
     */
    public void startGame() {
        startGame(0, Integer.MAX_VALUE);
    }

    /**
     * This method gets an integer number entered by the user.
     * @return the integer number entered by the user.
     */
    private int getInputNumber() {
        view.printMessage(View.DATA_INPUT, model.getMin(), model.getMax());
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            try {
                return Integer.parseInt(reader.readLine());
            } catch (Exception e) {
                view.printMessage(View.WRONG_INPUT_DATA);
                view.printMessage(View.DATA_INPUT, model.getMin(), model.getMax());
            }
        }
    }
}
