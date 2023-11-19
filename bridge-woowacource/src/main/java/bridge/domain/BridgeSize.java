package bridge.domain;

public class BridgeSize {

    private static final int MAX_SIZE = 20;
    private static final int MIN_SIZE = 3;

    private final int bridgeSize;

    public BridgeSize(int bridgeSize) {
        this.validate(bridgeSize);
        this.bridgeSize = bridgeSize;
    }

    private void validate(int bridgeSize) {
        if (bridgeSize > MAX_SIZE || bridgeSize < MIN_SIZE) {
            throw new IllegalArgumentException("다리 길이 범위를 확인하세요");
        }
    }

    @Override
    public String toString() {
        return "BridgeSize{" +
                "bridgeSize=" + bridgeSize +
                '}';
    }
}
