package bridge.view;

import bridge.domain.BridgeSize;
import bridge.util.Console;

import java.util.function.Supplier;

public class InputView {

    private InputView() {}

    private static <T> T repeatUntilNoException(Supplier<T> supplier) {
        while (true) {
            try {
                return supplier.get();
            } catch (Exception exception) {
                System.out.println(exception.getMessage());
            }
        }
    }

    public static BridgeSize readBridgeSize() {
        System.out.println("다리 건너기 게임을 시작합니다.\n");
        System.out.println("다리의 길이를 입력해주세요.");

        return repeatUntilNoException(() -> {
            int bridgeSize = readToInt(Console.readLine());
            return new BridgeSize(bridgeSize);
        });
    }

    private static int readToInt(String read) throws IllegalArgumentException {
        try {
            return Integer.parseInt(read);
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException("숫자만 입력하세요.");
        }
    }
}
