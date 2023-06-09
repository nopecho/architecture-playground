package nopecho.server.application.reactive.handler;

import nopecho.domain.User;
import nopecho.server.application.port.in.command.CreateUserCommand;
import nopecho.utils.LongIdGenerator;
import reactor.core.publisher.Mono;

public class ReactiveUserFactory {

    public static User create(CreateUserCommand command) {
        return User.builder()
                .id(LongIdGenerator.gen())
                .name(command.getName())
                .password(command.getPassword())
                .email(command.getEmail())
                .build();
    }
}
