package nopecho.mvc.application.handler.command;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import nopecho.mvc.application.port.in.command.Command;
import nopecho.mvc.application.port.in.command.CommandHandler;
import nopecho.mvc.application.port.in.command.CreateUserCommand;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class CreateUserCommandHandler implements CommandHandler {

    @Override
    public boolean canHandle(Command command) {
        return command.getClass().equals(CreateUserCommand.class);
    }

    @Override
    public void handle(Command command) {
        log.info(command.getClass().toString());
    }
}
