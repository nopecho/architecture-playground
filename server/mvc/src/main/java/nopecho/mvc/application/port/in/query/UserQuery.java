package nopecho.mvc.application.port.in.query;

import lombok.Builder;
import lombok.Getter;

import java.util.Objects;

@Getter
@Builder
public class UserQuery implements Query {

    private final String id;
    private final String name;

    @Override
    public void selfValidate() {
        if(Objects.nonNull(id) && isInvalidId()) {
            throw new RuntimeException("query user id is empty");
        }

        if(Objects.nonNull(name) && isInvalidName()) {
            throw new RuntimeException("query user name is empty");
        }
    }

    private boolean isInvalidId() {
        return this.id.isBlank();
    }

    private boolean isInvalidName() {
        return this.name.isBlank();
    }
}
