package nopecho.server.application.reactive.handler;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import nopecho.domain.User;
import nopecho.server.application.port.in.command.Command;
import nopecho.server.application.port.in.command.CreateUserCommand;
import nopecho.server.application.reactive.port.in.command.ReactiveCommandHandler;
import nopecho.server.application.reactive.port.out.ReactiveCreateUserPort;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Slf4j
@Service
@RequiredArgsConstructor
public class ReactiveCreateCommandHandler implements ReactiveCommandHandler {

    private final ReactiveCreateUserPort createUserPort;

    @Override
    public boolean canHandle(Command command) {
        return command.getClass().equals(CreateUserCommand.class);
    }

    @Override
    public Mono<Void> handle(Command command) {
        CreateUserCommand createCommand = validateAndConvert(command, CreateUserCommand.class);

        User user = ReactiveUserFactory.create(createCommand);

        return createUserPort.create(user);
    }
}
