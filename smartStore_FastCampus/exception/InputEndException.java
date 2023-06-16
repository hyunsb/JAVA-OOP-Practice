package smartStore_FastCampus.exception;

import smartStore_FastCampus.util.view.Message;

public class InputEndException extends RuntimeException {
    public InputEndException() {
        super(Message.ERR_MSG_INPUT_END);
    }

    public InputEndException(String message) {
        super(message);
    }
}
