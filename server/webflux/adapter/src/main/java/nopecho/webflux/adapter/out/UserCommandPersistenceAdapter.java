package nopecho.webflux.adapter.out;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import nopecho.domain.User;
import nopecho.server.application.reactive.port.out.ReactiveCreateUserPort;
import nopecho.webflux.adapter.out.persistence.UserEntity;
import nopecho.webflux.adapter.out.persistence.UserEntityRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserCommandPersistenceAdapter implements ReactiveCreateUserPort {

    private final UserEntityRepository repository;

    @Override
    public Mono<Void> create(User user) {
        UserEntity entity = UserEntity.create(user.getId(), user.getName(), user.getPassword(), user.getEmail());

        return repository.save(entity)
                .then();
    }
}
