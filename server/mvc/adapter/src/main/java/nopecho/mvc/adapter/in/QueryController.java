package nopecho.mvc.adapter.in;

import lombok.RequiredArgsConstructor;
import nopecho.server.application.port.in.query.CompositeQueryHandler;
import nopecho.server.application.port.in.query.UserQuery;
import nopecho.server.application.port.in.query.UsersQuery;
import nopecho.server.application.port.in.query.result.QueryResult;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class QueryController {

    private final CompositeQueryHandler queryHandler;

    @GetMapping("/foo")
    public ResponseEntity<QueryResult> foo() {
        UserQuery query = UserQuery.builder()
                .id("1")
                .build();
        query.selfValidate();

        QueryResult result = queryHandler.handle(query);

        return ResponseEntity.ok(result);
    }

    @GetMapping("/foo2")
    public ResponseEntity<QueryResult> foo2() {
        UsersQuery query = UsersQuery.defaults();

        QueryResult result = queryHandler.handle(query);

        return ResponseEntity.ok(result);
    }
}
