import javax.swing.*;
import java.awt.*;

public class Simulation extends JPanel {
    private double width;
    private double height;
    private Controller controller;
    public static Color[] COLORS = {new Color(255,255,255), new Color(255,0,0),
                                    new Color(0,255,0)    , new Color(0,0,255),
                                    new Color(255,255,0)  , new Color(255,0,255),
                                    new Color(0,255,255)};

    public void paint(Graphics g) {
        g.clearRect(0, 0, getWidth(), getHeight());

        printGraph(g);
        fillGraph(g);
        controller.drawImage(g, width, height);
    }

    public void printGraph(Graphics g) {

        for (int i = 0; i < controller.getAmount() + 1; i++) {
            g.drawLine((int) (i * width / controller.getAmount()), 0, (int) (i * width / controller.getAmount()), (int) (height));
        }
        for (int i = 0; i < controller.getAmount() + 1; i++) {
            g.drawLine(0, (int) (i * height / controller.getAmount()), (int) (width), (int) (i * height / controller.getAmount()));
        }
    }

    public void fillGraph(Graphics g) {
        for (int x = 0; x < controller.getSquares().length; x++) {
            for (int y = 0; y < controller.getSquares()[x].length; y++) {
                if (controller.getSquares()[x][y].getState() == 0) {
                    //do Nothing
                } else if (controller.getSquares()[x][y].getState() <= 7) {
                    g.setColor(COLORS[controller.getSquares()[x][y].getState()]);
                    g.fillRect((int) (x * width / controller.getAmount()), (int) (y * height / controller.getAmount()),
                               (int) (width / controller.getAmount()), (int) (height / controller.getAmount()));
                } else {
                    throw new RuntimeException("color not found");
                }
            }
        }
    }

    public void step() {
        controller.step();
    }

    Simulation(int width, int height, Controller controller) {
        this.width = width;
        this.height = height;
        this.controller = controller;
        if (controller.getTotalStates() == 0)
            controller.addRule(true);
    }

    Simulation(int width, int height) {
        this(width, height, new Controller(101));
    }

    Simulation(int size, Controller controller) {
        this(size, size, controller);
    }

    Simulation(int size) {
        this(size, size);
    }
}
