/* Example document on how to use the program.
 * Run this file to start the simulation.
 */

import java.util.*;

public class Main {
    public static void main(String[] args) {
        //Make a new image to check
        int[][] image =
            {{0, 1, 1},
             {1, 0, 1}};

        //Make the controller
        ImageChecker controller = new ImageChecker(51, image, 1, 1, 0);

        //Add the rules
        controller.addRule(true);
        controller.addRule(false);

        //Make and start the window
        Window window = new Window(800, controller);
        window.start();
    }
}
