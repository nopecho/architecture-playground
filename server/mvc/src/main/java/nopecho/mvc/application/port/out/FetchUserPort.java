package nopecho.mvc.application.port.out;

import nopecho.domain.User;

public interface FetchUserPort {

    User fetchById(String id);
}
