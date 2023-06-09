package nopecho.webflux.adapter.out.persistence;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface UserEntityRepository extends ReactiveCrudRepository<UserEntity, Long> {
}
