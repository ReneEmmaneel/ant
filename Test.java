class Test {
    public static void main(String[] args) {
        Controller c = new Controller(11);
        c.addRule(false);
        c.addRule(true);
        for (int i = 0; i < 10; i++) {
            c.step();
            c.console();
        }
    }
}
