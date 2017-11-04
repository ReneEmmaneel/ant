import java.util.HashMap;
import javax.swing.*;
import java.awt.*;

class Controller {
    protected Square[][] squares;
    protected int middle;
    protected Ant ant = new Ant();

    protected int totalStates;

    public Controller(int size) {
        squares = new Square[size][size];
        middle = size / 2;
        totalStates = 0;
        fill();
    }

    public Controller() {
        this(101);
    }

    public int getTotalStates() {
        return totalStates;
    }

    public Square[][] getSquares() {
        return squares;
    }

    public int getAmount() {
        return squares.length;
    }

    public void fill() {
        for (int x = 0; x < squares.length; x++) {
            for (int y = 0; y < squares.length; y++) {
                squares[x][y] = new Square(x, y);
            }
        }
    }

    public void addRule(int state, boolean right) {
        ant.addRule(state, right);
        totalStates++;
    }

    public void addRule(boolean right) {
        addRule(totalStates, right);
    }

    public void doubleSquares() {
        Square[][] newSquares = new  Square[squares.length * 3][squares[0].length * 3];
        for (int x = 0; x < newSquares.length; x++) {
            for (int y = 0; y < newSquares[0].length; y++) {
                newSquares[x][y] = new Square(x ,y);
            }
        }
        for (int x = 0; x < squares.length; x++) {
            for (int y = 0; y < squares[0].length; y++) {
                newSquares[squares.length + x][squares[0].length + y] = squares[x][y];
            }
        }

        squares = newSquares;
    }

    public void step() {
        middle = squares.length / 2;
        int x = ant.getX() + middle;
        int y = ant.getY() + middle;
        if (x < 2 || x > squares.length - 2 ||
            y < 2 || y > squares[0].length - 2) {
            doubleSquares();
            middle = squares.length / 2;
            x = ant.getX() + middle;
            y = ant.getY() + middle;
        }
        int state = squares[x][y].getState();
        squares[x][y].incrementState(totalStates);
        ant.move(ant.getDir(state));
    }

    //Don't draw anything
    public void drawImage(Graphics g, double width, double height) {}

    public void console() {
        for (int x = 0; x < squares.length; x++) {
            for (int y = 0; y < squares.length; y++) {
                System.out.print(squares[x][y].getState() + " ");
            }
            System.out.println();
        }
        System.out.printf("Ant coords: (%d,%d)%n", ant.getX(), ant.getY());
    }
}
