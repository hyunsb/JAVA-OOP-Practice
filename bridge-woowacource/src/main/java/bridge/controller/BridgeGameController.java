package bridge.controller;

import bridge.domain.*;
import bridge.dto.Result;
import bridge.util.BridgeRandomNumberGenerator;
import bridge.util.RandomNumberGenerator;
import bridge.view.InputView;
import bridge.view.OutputView;

import java.util.List;

public class BridgeGameController {

    private int gameCount;

    public BridgeGameController() {

    }

    public void run() {
        BridgeGame bridgeGame = this.generateBridgeGame();
        Result result = this.playGame(bridgeGame);

        if (result.isEnd()) {
            OutputView.printResult(result);
            return;
        }

        RetryCommand retryCommand = InputView.readRetryCommand();
        if (retryCommand.isEnd) {
            // 결과 출력
        }
        run();
    }

    public Result playGame(BridgeGame bridgeGame) {
        gameCount += 1;
        while (!bridgeGame.isEnd()) {
            MoveCommand moveCommand = InputView.readMoveCommand();
            bridgeGame.move(moveCommand);
            OutputView.printStatus(bridgeGame.getStatus());
        }
        return bridgeGame.getResult();
    }

    private BridgeGame generateBridgeGame() {
        BridgeSize bridgeSize = InputView.readBridgeSize();

        RandomNumberGenerator randomNumberGenerator = new BridgeRandomNumberGenerator();
        List<Integer> numbers = randomNumberGenerator.generate(bridgeSize.bridgeSize());

        Bridges bridges = Bridges.makeFromIntegers(numbers);

        return new BridgeGame(bridges);
    }
}
