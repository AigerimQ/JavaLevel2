package lesson1.participants;

public class Cat implements Member {
    private String name;
    private final int jumpHeight;
    private final int runLength;

    public Cat(String name, int jumpHeight, int runLength) {
        this.name = name;
        this.jumpHeight = jumpHeight;
        this.runLength = runLength;
    }

    @Override
    public int run() {
        System.out.printf("%s может пробежать %d м.\n", name, runLength);
        return runLength;
    }

    @Override
    public int jump() {
        System.out.printf("%s может прыгнуть на %d м.\n", name, jumpHeight);
        return jumpHeight;
    }

    @Override
    public String toString() {
        return ("Cat name " + name + ", jumpHeight = " + jumpHeight + ", runLength = " + runLength);
    }
}
