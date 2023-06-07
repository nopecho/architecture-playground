package nopecho.mvc.application.port.out;

import nopecho.domain.User;

public interface CreateUserPort {

    void create(User user);
}
