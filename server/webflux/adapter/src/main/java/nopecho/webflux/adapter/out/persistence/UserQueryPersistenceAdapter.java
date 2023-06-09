package nopecho.webflux.adapter.out.persistence;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import nopecho.domain.User;
import nopecho.server.application.port.out.CreateUserPort;
import nopecho.server.application.port.out.QueryUserPort;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserQueryPersistenceAdapter implements QueryUserPort{

    private final UserEntityRepository repository;

    @Override
    public User getUserById(String id) {
        return null;
    }
}
