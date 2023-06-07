package nopecho.mvc.application.port.in.command;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class CreateUserCommand implements Command {

    private final String name;

    @Override
    public void selfValidate() {
    }
}
