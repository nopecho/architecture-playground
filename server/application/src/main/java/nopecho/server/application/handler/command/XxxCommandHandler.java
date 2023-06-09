package nopecho.server.application.handler.command;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import nopecho.server.application.port.in.command.Command;
import nopecho.server.application.port.in.command.CommandHandler;
import nopecho.server.application.port.in.command.CreateUserCommand;
import nopecho.server.application.port.in.command.XxxCommand;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;

@Slf4j
@Service
@RequiredArgsConstructor
public class XxxCommandHandler implements CommandHandler {

    private final CreateUserCommandHandler createUserCommandHandler;

    @Override
    public boolean canHandle(Command command) {
        return Objects.equals(command.getClass(), XxxCommand.class);
    }

    @Transactional
    @Override
    public void handle(Command command) {
        XxxCommand xxxCommand = validateAndConvert(command, XxxCommand.class);
        //do anything..

        //do command convert..
        CreateUserCommand createUserCommand = xxxCommand.toCreateUserCommand();
        createUserCommandHandler.handle(createUserCommand);
    }
}
