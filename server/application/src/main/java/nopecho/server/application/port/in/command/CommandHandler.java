package nopecho.server.application.port.in.command;

public interface CommandHandler {

    boolean canHandle(Command command);

    void handle(Command command);

    default <T extends Command> T validateAndConvert(Command command, Class<T> classOfT) {
        if(canHandle(command)) {
            return classOfT.cast(command);
        }
        throw new RuntimeException(
                String.format("can not casting to command. because not handle this command: %s", command.getClass())
        );
    }
}
