package nopecho.mvc.application.handler.query;

import nopecho.domain.User;
import nopecho.mvc.application.port.in.query.result.UserResult;

public class ResultConverter {

    public static UserResult userResultFrom(User user) {
        return UserResult.of(
                user.getId().toString(),
                user.getName());
    }
}
