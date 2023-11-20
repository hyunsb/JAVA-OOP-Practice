package bridge.controller;

import bridge.domain.BridgeGame;
import bridge.domain.BridgeSize;
import bridge.domain.Bridges;
import bridge.domain.MoveCommand;
import bridge.util.BridgeRandomNumberGenerator;
import bridge.util.RandomNumberGenerator;
import bridge.view.InputView;

import java.util.List;

public class BridgeGameController {

    public BridgeGameController() {

    }

    public void run() {
        BridgeGame bridgeGame = this.generateBridgeGame();
        while (!bridgeGame.isEnd()) {
            MoveCommand moveCommand = InputView.readMoveCommand();
            bridgeGame.move(moveCommand);
        }
    }

    private BridgeGame generateBridgeGame() {
        BridgeSize bridgeSize = InputView.readBridgeSize();

        RandomNumberGenerator randomNumberGenerator = new BridgeRandomNumberGenerator();
        List<Integer> numbers = randomNumberGenerator.generate(bridgeSize.bridgeSize());

        Bridges bridges = Bridges.makeFromIntegers(numbers);

        return new BridgeGame(bridges);
    }
}
