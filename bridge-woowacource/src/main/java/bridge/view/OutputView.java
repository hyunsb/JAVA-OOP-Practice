package bridge.view;

import bridge.domain.Bridge;
import bridge.dto.Result;
import bridge.dto.Status;

import java.util.List;

public class OutputView {

    private static final String SUCCESS = "O";
    private static final String FAIL = "X";

    private OutputView() {
        throw new IllegalArgumentException();
    }

    public static void printStatus(Status status) {
        int position = status.position();
        boolean isEnd = status.isEnd();
        List<Bridge> bridges = status.bridgesDto().bridges();
        // 대충 출력
    }

    public static void printResult(Result result) {
        // 대충 출력
    }
}
