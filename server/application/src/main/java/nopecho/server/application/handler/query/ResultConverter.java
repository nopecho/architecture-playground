package nopecho.server.application.handler.query;

import nopecho.domain.User;
import nopecho.server.application.port.in.query.result.UserResult;

public class ResultConverter {

    public static UserResult userResultFrom(User user) {
        return UserResult.of(
                user.getId().toString(),
                user.getName());
    }
}
