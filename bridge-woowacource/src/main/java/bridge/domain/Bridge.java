package bridge.domain;

public enum Bridge {

    UP(0),
    DOWN(1);

    private final int number;

    Bridge(int number) {
        this.number = number;
    }

    public static Bridge from(int number) {
        for (Bridge bridge : Bridge.values()) {
            if (bridge.number == number) {
                return bridge;
            }
        }
        throw new IllegalArgumentException();
    }
}
