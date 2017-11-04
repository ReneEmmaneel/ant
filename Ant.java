import java.util.HashMap;

class Ant {
    /*
     * The HashMap with the rules.
     * Each rule is stored as a boolean, with true meaning right and false left.
     */
    final private HashMap<Integer, Boolean> rules;
    private int x = 0;
    private int y = 0;

    /*
     * dir is the direction the ant is facing.
     * 0 = up, 1 = right, 2 = down, 3 = left.
     */
    private int dir = 0;

    public Ant() {
        rules = new HashMap<>();
    }

    public Ant(int x, int y) {
        this();
        this.x = x;
        this.y = y;
        this.dir = 0;
    }

    public void addRule(int state, boolean right) {
        rules.put(state, right);
    }

    /*
     * Change dir and move the ant.
     */
    public void move(boolean right) {
        dir += right ? 1 : -1;
        if (dir == 4) dir = 0;
        if (dir == -1) dir = 3;
        if (dir == 0) {
            y++;
        } else if (dir == 1) {
            x++;
        } else if (dir == 2) {
            y--;
        } else if (dir == 3) {
            x--;
        }
    }

    public boolean getDir(int state) {
        return rules.get(state);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setDir(int dir) {
        this.dir = dir;
    }
}
