import javax.swing.*;
import java.awt.*;

public class Simulation extends JPanel {
    private double width;
    private double height;
    private Controller controller;

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
                if (controller.getSquares()[x][y].getState() == 1) {
                    g.setColor(new Color(0,0,0));
                    g.fillRect((int) (x * width / controller.getAmount()), (int) (y * height / controller.getAmount()),
                               (int) (width / controller.getAmount()), (int) (height / controller.getAmount()));
                } else if (controller.getSquares()[x][y].getState() == 2) {
                    g.setColor(new Color(255,0,0));
                    g.fillRect((int) (x * width / controller.getAmount()), (int) (y * height / controller.getAmount()),
                               (int) (width / controller.getAmount()), (int) (height / controller.getAmount()));
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
