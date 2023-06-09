package nopecho.server.application.reactive.port.in.command;

import nopecho.server.application.port.in.command.Command;
import reactor.core.publisher.Mono;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public final class ReactiveCompositeCommandHandler implements ReactiveCommandHandler {

    private final List<ReactiveCommandHandler> handlers;

    public ReactiveCompositeCommandHandler(ReactiveCommandHandler... handlers) {
        this.handlers = Collections.unmodifiableList(Arrays.asList(handlers));
    }

    @Override
    public boolean canHandle(Command command) {
        return this.handlers.stream()
                .anyMatch(h -> h.canHandle(command));
    }

    @Override
    public Mono<Void> handle(Command command) {
        return handleOrThrow(command);
    }

    private Mono<Void> handleOrThrow(Command command) {
        ReactiveCommandHandler handler = findHandlerOrThrow(command);
        try {
            return handler.handle(command);
        } catch (Exception e) {
            throw new RuntimeException(
              String.format("error from [%s]. message: %s",getCommandName(command), e.getMessage())
            );
        }
    }

    private ReactiveCommandHandler findHandlerOrThrow(Command command) {
        return this.handlers.stream()
                .filter(h -> h.canHandle(command))
                .findFirst()
                .orElseThrow(() -> new RuntimeException(
                        String.format("can not support this command: %s", getCommandName(command)))
                );
    }

    private String getCommandName(Command command) {
        return command.getClass().getName();
    }
}
