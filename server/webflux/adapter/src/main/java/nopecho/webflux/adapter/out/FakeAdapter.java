package nopecho.webflux.adapter.out;

import nopecho.domain.User;
import nopecho.server.application.port.out.CreateUserPort;
import org.springframework.stereotype.Service;

@Service
public class FakeAdapter implements CreateUserPort {

    @Override
    public void create(User user) {

    }
}
