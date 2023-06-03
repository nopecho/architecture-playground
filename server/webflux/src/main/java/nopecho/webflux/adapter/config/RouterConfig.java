package nopecho.webflux.adapter.config;

import nopecho.webflux.adapter.in.DummyCommandRequestHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

@Configuration
public class RouterConfig {

    @Bean
    public RouterFunction<ServerResponse> v1CommandRouters(DummyCommandRequestHandler handler) {
        return RouterFunctions.route()
                .path("/api/v1", v1 -> v1
                        .GET("", handler::post))
                .build();
    }
}
