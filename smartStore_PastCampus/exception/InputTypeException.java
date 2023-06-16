package smartStore_PastCampus.exception;


import smartStore_PastCampus.util.view.Message;

public class InputTypeException extends RuntimeException {
    public InputTypeException() {
        super(Message.ERR_MSG_INVALID_INPUT_TYPE);
    }

    public InputTypeException(String message) {
        super(message);
    }
}
