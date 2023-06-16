package smartStore_FastCampus.exception;

import smartStore_FastCampus.util.view.Message;

public class GroupNotFoundException extends RuntimeException {

    public GroupNotFoundException() {
        super(Message.ERR_MSG_GROUP_NOT_FOUND);
    }

    public GroupNotFoundException(String message) {
        super(message);
    }
}
