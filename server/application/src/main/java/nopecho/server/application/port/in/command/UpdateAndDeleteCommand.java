package nopecho.server.application.port.in.command;

import lombok.Builder;

@Builder
public class UpdateAndDeleteCommand implements Command{

    private final String name;

    @Override
    public void selfValidate() {

    }

    public CreateUserCommand toCreateUserCommand() {
        return CreateUserCommand.builder()
                .name(name)
                .build();
    }
}
