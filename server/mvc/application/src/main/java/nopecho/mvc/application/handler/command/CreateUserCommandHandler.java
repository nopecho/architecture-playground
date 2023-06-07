package nopecho.mvc.application.handler.command;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import nopecho.domain.User;
import nopecho.mvc.application.port.in.command.Command;
import nopecho.mvc.application.port.in.command.CommandHandler;
import nopecho.mvc.application.port.in.command.CreateUserCommand;
import nopecho.mvc.application.port.out.CreateUserPort;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class CreateUserCommandHandler implements CommandHandler {

    private final CreateUserPort createUserPort;

    @Override
    public boolean canHandle(Command command) {
        return command.getClass().equals(CreateUserCommand.class);
    }

    @Override
    public void handle(Command command) {
        CreateUserCommand createCommand = validateAndConvert(command, CreateUserCommand.class);
        User user = UserFactory.create(createCommand);
        createUserPort.create(user);
    }
}
