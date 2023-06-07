package nopecho.mvc.application.handler.query;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import nopecho.domain.User;
import nopecho.mvc.application.port.in.query.Query;
import nopecho.mvc.application.port.in.query.QueryHandler;
import nopecho.mvc.application.port.in.query.UserQuery;
import nopecho.mvc.application.port.in.query.result.QueryResult;
import nopecho.mvc.application.port.out.QueryUserPort;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserByIdQueryHandler implements QueryHandler {

    private final QueryUserPort queryUserPort;

    @Override
    public boolean canHandle(Query query) {
        return Objects.equals(query.getClass(), UserQuery.class) &&
                Objects.nonNull(((UserQuery) query).getId());
    }

    @Override
    public QueryResult handle(Query query) {
        UserQuery userQuery = (UserQuery) query;

        User user = queryUserPort.getUserById(userQuery.getId());

        return ResultConverter.userResultFrom(user);
    }
}
