package nopecho.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.With;

@Getter
@Builder
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
