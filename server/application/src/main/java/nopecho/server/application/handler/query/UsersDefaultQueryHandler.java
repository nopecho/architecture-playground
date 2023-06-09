package nopecho.server.application.handler.query;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import nopecho.server.application.port.in.query.Query;
import nopecho.server.application.port.in.query.QueryHandler;
import nopecho.server.application.port.in.query.UsersQuery;
import nopecho.server.application.port.in.query.result.QueryResult;
import nopecho.server.application.port.in.query.result.UserResult;
import nopecho.server.application.port.in.query.result.UsersResult;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class UsersDefaultQueryHandler implements QueryHandler {

    @Override
    public boolean canHandle(Query query) {
        return query.getClass().equals(UsersQuery.class) &&
                ((UsersQuery) query).getSize() == null &&
                ((UsersQuery) query).getPage() == null;
    }

    @Override
    public QueryResult handle(Query query) {
        List<UserResult> users = List.of(
                UserResult.of("1","test1"),
                UserResult.of("2","test2")
        );

        return UsersResult.of(users);
    }
}
