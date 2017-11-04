class Square {
    final public int x, y;
    public int state = 0;

    public Square(int x, int y, int state) {
        this.x = x;
        this.y = y;
        this.state = state;
    }

    public Square(int x, int y) {
        this(x, y, 0);
    }

    public void incrementState(int totalStates) {
        if (++state >= totalStates)
            state = 0;
    }

    public int getState() {
        return state;
    };
}
