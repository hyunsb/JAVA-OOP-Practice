package bridge.domain;

import java.util.List;

public class Bridges {

    private final List<Bridge> bridges;
    private int location;

    private Bridges(List<Bridge> bridges) {
        this.validate(bridges);
        this.bridges = bridges;
    }

    private void validate(List<Bridge> bridges) {
        if (bridges.isEmpty()) {
            throw new IllegalArgumentException("다리는 비어있을 수 없음");
        }
    }

    public static Bridges makeFromIntegers(List<Integer> numbers) {
        List<Bridge> bridges = numbers.stream()
                .map(Bridge::from)
                .toList();

        return new Bridges(bridges);
    }

    @Override
    public String toString() {
        return "Bridges{" +
                "bridges=" + bridges +
                ", location=" + location +
                '}';
    }
}
