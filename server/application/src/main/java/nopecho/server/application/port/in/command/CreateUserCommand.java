package nopecho.server.application.port.in.command;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class CreateUserCommand implements Command {

    private final String name;
    private final String password;
    private final String email;

    @Override
    public void selfValidate() {
    }
}
