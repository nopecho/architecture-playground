package nopecho.webflux.adapter.in;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import nopecho.domain.User;
import nopecho.server.application.port.in.command.Command;
import nopecho.server.application.port.in.command.CompositeCommandHandler;
import nopecho.server.application.port.in.command.CreateUserCommand;
import nopecho.server.application.reactive.port.in.command.ReactiveCompositeCommandHandler;
import nopecho.utils.LongIdGenerator;
import nopecho.webflux.adapter.in.model.Requested;
import nopecho.webflux.adapter.out.UserCommandPersistenceAdapter;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Slf4j
@Component
@RequiredArgsConstructor
public class CommandRequestHandler {

    private final ReactiveCompositeCommandHandler commandHandler;

    public Mono<ServerResponse> saveUser(ServerRequest request) {
        return request.bodyToMono(Requested.CreateUser.class)
                .map(this::createUserCommandFrom)
                .flatMap(this::handleResponseCommand);
    }

    private CreateUserCommand createUserCommandFrom(Requested.CreateUser request) {
        CreateUserCommand command = CreateUserCommand.builder()
                .name(request.getName())
                .password(request.getPassword())
                .email(request.getEmail())
                .build();
        command.selfValidate();
        return command;
    }

    private Mono<ServerResponse> handleResponseCommand(Command command) {
        return commandHandler.handle(command)
                .flatMap(r -> ServerResponse.ok().build())
                .onErrorResume(e -> Mono.just(e)
                        .flatMap(this::handleResponseError));
    }

    private Mono<ServerResponse> handleResponseError(Throwable throwable) {
        throwable.printStackTrace();
        String message = throwable.getMessage();
        return ServerResponse.badRequest().bodyValue(message);
    }
}
