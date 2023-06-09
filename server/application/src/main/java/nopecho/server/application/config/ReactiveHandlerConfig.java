package nopecho.server.application.config;

import lombok.RequiredArgsConstructor;
import nopecho.server.application.reactive.handler.ReactiveCreateCommandHandler;
import nopecho.server.application.reactive.port.in.command.ReactiveCompositeCommandHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class ReactiveHandlerConfig {

    private final ReactiveCreateCommandHandler reactiveCreateCommandHandler;

    @Bean
    public ReactiveCompositeCommandHandler reactiveCompositeCommandHandler() {
        return new ReactiveCompositeCommandHandler(
                reactiveCreateCommandHandler
        );
    }
}
