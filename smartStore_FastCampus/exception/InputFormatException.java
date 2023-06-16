package smartStore_FastCampus.exception;

import smartStore_FastCampus.util.view.Message;

public class InputFormatException extends RuntimeException {
    public InputFormatException() {
        super(Message.ERR_MSG_INVALID_INPUT_FORMAT);
    }

    public InputFormatException(String message) {
        super(message);
    }
}
