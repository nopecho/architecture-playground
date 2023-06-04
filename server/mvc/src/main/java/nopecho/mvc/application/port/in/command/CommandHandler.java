package nopecho.mvc.application.port.in.command;

public interface CommandHandler {

    boolean canHandle(Command command);

    void handle(Command command);
}
