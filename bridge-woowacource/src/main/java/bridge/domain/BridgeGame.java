package bridge.domain;

public class BridgeGame {

    private final Bridges bridges;

    private int location;
    private boolean isEnd;

    public BridgeGame(Bridges bridges) {
        this.bridges = bridges;
    }

    public void move(MoveCommand moveCommand) {
        boolean isSuccess = bridges.isMatched(location, moveCommand.toBridge());
        if (!isSuccess) {
            isEnd = true;
        }
        location += 1;
    }

    public boolean isEnd() {
        return isEnd;
    }
}
