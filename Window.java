import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Window implements ActionListener {
    private JFrame frame;
    private Simulation simulation;

    private final Double FRAMES_PER_SECOND = 60.0;
    private final Timer timer = new Timer((int) (1000.0 / FRAMES_PER_SECOND), this);
    private int time = 0;

    public Window(int size, Controller controller) {
        frame = new JFrame("Langton's ant simulator");
        frame.setVisible(true);
        frame.setSize(size, size);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        simulation = new Simulation(size, controller);
        frame.add((JPanel) simulation);
    }

    public void start() {
        timer.start();
    }

    public void stop() {
        timer.stop();
    }

    public void simulate(int steps) {
        for (int i = 0; i < steps; i++) {
            simulation.step();
        }
        frame.repaint();
    }

    private void step() {
        simulation.step();
        time++;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        step();
        frame.repaint();
        Toolkit.getDefaultToolkit().sync();
    }

}
