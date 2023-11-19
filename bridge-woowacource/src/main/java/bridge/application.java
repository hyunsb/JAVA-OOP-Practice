package bridge;

import bridge.domain.BridgeSize;
import bridge.view.InputView;

public class application {
    public static void main(String[] args) {
        BridgeSize bridgeSize = InputView.readBridgeSize();
        System.out.println(bridgeSize);
    }
}
