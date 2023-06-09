package nopecho.webflux.adapter.out.persistence;

import nopecho.domain.User;

public class EntityTransformer {

    public static User transform(UserEntity entity) {
        return User.builder()
                .id(entity.getId())
                .name(entity.getEmail())
                .email(entity.getEmail())
                .password(entity.getPassword())
                .build();
    }

    public static UserEntity transform(User user) {
        return UserEntity.builder()
                .id(user.getId())
                .username(user.getName())
                .email(user.getEmail())
                .password(user.getPassword())
                .build();
    }
}
