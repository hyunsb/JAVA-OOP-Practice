package smartStore_PastCampus.exception;

import smartStore_PastCampus.util.view.Message;

public class GroupSetAlreadyException extends RuntimeException{

    public GroupSetAlreadyException() {
        super(Message.ERR_MSG_GROUP_SET_ALREADY);
    }

    public GroupSetAlreadyException(String message) {
        super(message + Message.ERR_MSG_GROUP_SET_ALREADY);
    }
}
