import javax.swing.*;
import java.awt.*;
import java.awt.geom.Line2D;

class ImageChecker extends Controller {
    private int[][] image;
    private int startX;
    private int startY;
    private int startDir;

    ImageChecker(int size, int[][] image, int x, int y, int dir) {
        super(size);
        this.image = image;
        this.startX = x;
        this.startY = y;
        this.startDir = dir;
        ant.setX(this.startX);
        ant.setY(this.startY);
        ant.setDir(this.startDir);
        makeImage();
    }

    public void makeImage() {
        for (int y = 0; y < image.length; y++) {
            for (int x = 0; x < image[y].length; x++) {
                squares[x + middle][y + middle] = new Square(x, y, image[y][x]);
            }
        }
    }

    public boolean checkImage() {
        return false;
    }

    public void drawImage(Graphics g, double width, double height) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setStroke(new BasicStroke(3));
        g2.setColor(new Color(0, 255, 0));
        int pWidth = (int) (width / getAmount());
        int pHeight = (int) (width / getAmount());
        int x = getAmount() / 2;
        int y = getAmount() / 2;
        x *= pWidth;
        y *= pHeight;
        int iWidth = image[0].length * pWidth;
        int iHeight = image.length * pHeight;

        g2.drawRect(x, y, iWidth, iHeight);
    }
}
