package bridge.domain;

public enum RetryCommand {

    QUIT("Q"),
    RETRY("R");

    private final String command;

    RetryCommand(String command) {
        this.command = command;
    }

    public static RetryCommand from(String command) {
        for (RetryCommand retryCommand : RetryCommand.values()) {
            command = command.toUpperCase();
            if (retryCommand.command.equals(command)) {
                return retryCommand;
            }
        }
        throw new IllegalArgumentException();
    }
}
