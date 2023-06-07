package nopecho.mvc.application.config;

import lombok.RequiredArgsConstructor;
import nopecho.mvc.application.handler.command.CreateUserCommandHandler;
import nopecho.mvc.application.handler.command.UpdateAndDeleteCommandHandler;
import nopecho.mvc.application.handler.query.UserByIdQueryHandler;
import nopecho.mvc.application.handler.query.UsersDefaultQueryHandler;
import nopecho.mvc.application.port.in.command.CompositeCommandHandler;
import nopecho.mvc.application.port.in.query.CompositeQueryHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class HandlerConfig {

    //command
    private final CreateUserCommandHandler createUserCommandHandler;
    private final UpdateAndDeleteCommandHandler updateAndDeleteCommandHandler;

    //query
    private final UserByIdQueryHandler userByIdQueryHandler;
    private final UsersDefaultQueryHandler usersDefaultQueryHandler;


    @Bean
    public CompositeCommandHandler commandHandler() {
        return new CompositeCommandHandler(
                createUserCommandHandler,
                updateAndDeleteCommandHandler
        );
    }

    @Bean
    public CompositeQueryHandler queryHandler() {
        return new CompositeQueryHandler(
                usersDefaultQueryHandler,
                userByIdQueryHandler
        );
    }
}
