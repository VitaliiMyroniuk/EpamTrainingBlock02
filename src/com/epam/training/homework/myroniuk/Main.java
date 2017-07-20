package com.epam.training.homework.myroniuk;

/**
 * Created by Vitalii on 19.07.2017.
 */
public class Main {
    public static void main(String[] args) {
        // Initialization
        Model model = new Model();
        View view = new View();
        Controller controller = new Controller(model, view);

        // Run the game for integer numbers from 0 to 100 (inclusively).
        controller.startGame(0, 100);
    }
}
