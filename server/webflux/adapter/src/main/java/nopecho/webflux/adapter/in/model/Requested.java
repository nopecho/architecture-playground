package nopecho.webflux.adapter.in.model;

import lombok.Data;

public interface Requested {

    @Data
    class CreateUser {
        private String name;
        private String password;
        private String email;
    }
}
