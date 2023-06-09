package nopecho.server.application.port.in.query.result;

import lombok.Data;
import lombok.Value;

import java.util.List;

@Data
@Value(staticConstructor = "of")
public class UsersResult implements QueryResult{

    List<UserResult> users;

    @Override
    public void selfValidate() {
        //validating
    }
}
