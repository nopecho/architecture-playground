package nopecho.webflux.adapter.in;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Component
public class DummyCommandRequestHandler {

    public Mono<ServerResponse> post(ServerRequest request) {
        String path = request.path();
        return ServerResponse
                .status(HttpStatus.CREATED)
                .bodyValue(path);
    }
}
