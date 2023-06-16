package smartStore_FastCampus.exception;


import smartStore_FastCampus.util.view.Message;

public class InputEmptyException extends RuntimeException {

    public InputEmptyException() {
        super(Message.ERR_MSG_INVALID_INPUT_EMPTY);
    }

    public InputEmptyException(String message) {
        super(message);
    }
}
