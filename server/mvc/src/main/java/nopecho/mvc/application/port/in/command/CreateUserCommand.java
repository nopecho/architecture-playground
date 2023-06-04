package nopecho.mvc.application.port.in.command;

import lombok.Builder;

@Builder
public class CreateUserCommand implements Command {

    private final String name;

    @Override
    public void selfValidate() {
    }
}
