package nopecho.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.With;

@Getter
@AllArgsConstructor
public class User {

    private final Long id;

    @With
    private String name;
    @With
    private String password;
    @With
    private String email;
}
