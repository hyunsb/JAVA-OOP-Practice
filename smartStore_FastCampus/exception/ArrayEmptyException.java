package smartStore_FastCampus.exception;

import smartStore_FastCampus.util.view.Message;

public class ArrayEmptyException extends RuntimeException {

    public ArrayEmptyException() {
        super(Message.ERR_MSG_INVALID_ARR_EMPTY);
    }

    public ArrayEmptyException(String message) {
        super(message);
    }
}
