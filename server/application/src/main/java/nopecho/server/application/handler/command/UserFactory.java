package nopecho.server.application.handler.command;

import nopecho.domain.User;
import nopecho.server.application.port.in.command.CreateUserCommand;
import nopecho.utils.LongIdGenerator;

public class UserFactory {

    public static User create(CreateUserCommand command) {
        return User.builder()
                .id(LongIdGenerator.gen())
                .name(command.getName())
                .password(command.getPassword())
                .email(command.getEmail())
                .build();
    }
}
