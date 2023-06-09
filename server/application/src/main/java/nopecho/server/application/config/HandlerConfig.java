package nopecho.server.application.config;

import lombok.RequiredArgsConstructor;
import nopecho.server.application.handler.command.CreateUserCommandHandler;
import nopecho.server.application.handler.command.UpdateAndDeleteCommandHandler;
import nopecho.server.application.handler.query.UserByIdQueryHandler;
import nopecho.server.application.handler.query.UsersDefaultQueryHandler;
import nopecho.server.application.port.in.command.CompositeCommandHandler;
import nopecho.server.application.port.in.query.CompositeQueryHandler;
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
    public CompositeCommandHandler compositeCommandHandler() {
        return new CompositeCommandHandler(
                createUserCommandHandler,
                updateAndDeleteCommandHandler
        );
    }

    @Bean
    public CompositeQueryHandler compositeQueryHandler() {
        return new CompositeQueryHandler(
                usersDefaultQueryHandler,
                userByIdQueryHandler
        );
    }
}
