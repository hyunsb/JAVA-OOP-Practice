package bridge.domain;

import bridge.dto.Result;
import bridge.dto.Status;

public class BridgeGame {

    private final Bridges bridges;

    private int position;
    private boolean isEnd;

    public BridgeGame(Bridges bridges) {
        this.bridges = bridges;
    }

    public void move(MoveCommand moveCommand) {
        boolean isSuccess = bridges.isMatched(position, moveCommand.toBridge());
        if (!isSuccess) {
            isEnd = true;
        }
        position += 1;
    }

    public boolean isEnd() {
        return isEnd;
    }

    public Status getStatus() {
        return new Status(position, isEnd, bridges.toDto());
    }

    public Result getResult() {
        return new Result(this.getStatus(), isEnd);
    }
}
