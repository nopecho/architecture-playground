package nopecho.server.application.reactive.port.out;

import nopecho.domain.User;
import reactor.core.publisher.Mono;

public interface ReactiveCreateUserPort {

    Mono<Void> create(User user);
}
