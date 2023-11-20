package bridge;

import bridge.controller.BridgeGameController;

public class application {
    public static void main(String[] args) {
        BridgeGameController bridgeGameController = new BridgeGameController();
        bridgeGameController.run();
    }
}
