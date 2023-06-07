package nopecho.mvc.application.port.in.command;

public interface CommandHandler {

    boolean canHandle(Command command);

    void handle(Command command);

    default <T extends Command> T validateAndCast(Command command, Class<T> classOfT) {
        if(canHandle(command)) {
            return classOfT.cast(command);
        }
        throw new RuntimeException(
                String.format("can not support this command: %s", command.getClass())
        );
    }
}
