package nopecho.mvc.application.port.in.command;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class XxxCommand implements Command {

    public CreateUserCommand toCreateUserCommand() {
        return CreateUserCommand.builder()
                .build();
    }
    @Override
    public void selfValidate() {
        // validating
    }
}
