package nopecho.mvc.application.port.in.query.result;

import lombok.Data;
import lombok.Value;

@Data
@Value(staticConstructor = "of")
public class UserResult implements QueryResult {

    String id;
    String name;

    @Override
    public void selfValidate() {
        //validating
    }
}
