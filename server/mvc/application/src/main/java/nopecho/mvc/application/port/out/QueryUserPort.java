package nopecho.mvc.application.port.out;

import nopecho.domain.User;

public interface QueryUserPort {

    User getUserById(String id);
}
