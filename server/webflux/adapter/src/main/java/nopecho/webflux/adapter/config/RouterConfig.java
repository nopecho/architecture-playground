package nopecho.webflux.adapter.config;

import nopecho.webflux.adapter.in.CommandRequestHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

@Configuration
public class RouterConfig {

    @Bean
    public RouterFunction<ServerResponse> commandRoutersV1(CommandRequestHandler handler) {
        return RouterFunctions.route()
                .path("/api/v1", v1 -> v1
                        .POST("", handler::saveUser))
                .build();
    }
}
