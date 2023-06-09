package nopecho.server.application.reactive.port.in.command;

import nopecho.server.application.port.in.command.Command;
import reactor.core.publisher.Mono;

public interface ReactiveCommandHandler {

    boolean canHandle(Command command);

    Mono<Void> handle(Command command);

    default <T extends Command> T validateAndConvert(Command command, Class<T> classOfT) {
        if(canHandle(command)) {
            return classOfT.cast(command);
        }
        throw new RuntimeException(
                String.format("can not casting to command. because not handle this command: %s", command.getClass())
        );
    }
}
