package bridge.domain;

public enum MoveCommand {

    UP("U", Bridge.UP),
    DOWN("D", Bridge.DOWN);

    private final String command;
    private final Bridge bridge;

    MoveCommand(String command, Bridge bridge) {
        this.command = command;
        this.bridge = bridge;
    }

    public static MoveCommand from(String command) {
        for (MoveCommand moveCommand : MoveCommand.values()) {
            command = command.toUpperCase();
            if (moveCommand.command.equals(command)) {
                return moveCommand;
            }
        }
        throw new IllegalArgumentException("커멘드가 일치하지 않음");
    }

    public Bridge toBridge() {
        return bridge;
    }
}
