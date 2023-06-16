package smartStore_PastCampus.exception;

import smartStore_PastCampus.util.view.Message;

public class InputEndException extends RuntimeException {
    public InputEndException() {
        super(Message.ERR_MSG_INPUT_END);
    }

    public InputEndException(String message) {
        super(message);
    }
}
