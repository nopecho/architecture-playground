package nopecho.server.application.handler.command;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import nopecho.server.application.port.in.command.Command;
import nopecho.server.application.port.in.command.CommandHandler;
import nopecho.server.application.port.in.command.CreateUserCommand;
import nopecho.server.application.port.in.command.UpdateAndDeleteCommand;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class UpdateAndDeleteCommandHandler implements CommandHandler {

    private final CreateUserCommandHandler createUserCommandHandler;

    @Override
    public boolean canHandle(Command command) {
        return command.getClass().equals(UpdateAndDeleteCommand.class);
    }

    @Override
    public void handle(Command command) {
        UpdateAndDeleteCommand updateAndDeleteCommand = validateAndConvert(command, UpdateAndDeleteCommand.class);

        CreateUserCommand createUserCommand = updateAndDeleteCommand.toCreateUserCommand();
        createUserCommandHandler.handle(createUserCommand);

        log.info(command.getClass().getName());
    }
}
