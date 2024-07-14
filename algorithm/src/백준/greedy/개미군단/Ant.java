package 백준.greedy.개미군단;

public abstract class Ant {
    private int power;
    private String type;

    public Ant(int power, String type) {
        this.power = power;
        this.type = type;
    }

    public int getPower() {
        return power;
    }

    public String getType() {
        return type;
    }
}
