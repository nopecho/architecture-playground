package nopecho.server.application.port.in.query;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class UsersQuery implements Query {

    private final Integer size;
    private final Integer page;

    public static UsersQuery defaults() {
        return new UsersQuery(null, null);
    }

    @Override
    public void selfValidate() {

    }
}
