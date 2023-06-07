package nopecho.mvc.adapter.in;

import lombok.RequiredArgsConstructor;
import nopecho.mvc.application.port.in.command.CompositeCommandHandler;
import nopecho.mvc.application.port.in.command.CreateUserCommand;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class CommandController {

    private final CompositeCommandHandler commandHandler;

    @GetMapping("/xx")
    public ResponseEntity<?> xx() {
        CreateUserCommand command = CreateUserCommand.builder()
                .name("test")
                .build();
        command.selfValidate();

        commandHandler.handle(command);

        return ResponseEntity.ok("ok");
    }
}
