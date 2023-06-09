package nopecho.mvc.adapter.out;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import nopecho.domain.User;
import nopecho.mvc.adapter.config.Adapter;
import nopecho.mvc.adapter.out.persistence.EntityTransformer;
import nopecho.mvc.adapter.out.persistence.UserEntity;
import nopecho.mvc.adapter.out.persistence.UserEntityRepository;
import nopecho.server.application.port.out.QueryUserPort;

@Slf4j
@Adapter
@RequiredArgsConstructor
public class UserQueryPersistenceAdapter implements QueryUserPort {

    private final UserEntityRepository repository;

    @Override
    public User getUserById(String id) {
        UserEntity entity = repository.findById(Long.parseLong(id))
                .orElseThrow(() -> new RuntimeException("not found user"));

        return EntityTransformer.transform(entity);
    }
}
