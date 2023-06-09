package nopecho.mvc.adapter.out;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import nopecho.domain.User;
import nopecho.mvc.adapter.config.Adapter;
import nopecho.mvc.adapter.out.persistence.EntityTransformer;
import nopecho.mvc.adapter.out.persistence.UserEntity;
import nopecho.mvc.adapter.out.persistence.UserEntityRepository;
import nopecho.server.application.port.out.CreateUserPort;

@Slf4j
@Adapter
@RequiredArgsConstructor
public class UserCommandPersistenceAdapter implements CreateUserPort {

    private final UserEntityRepository repository;

    @Override
    public void create(User user) {
        UserEntity entity = EntityTransformer.transform(user);
        repository.save(entity);
    }
}
