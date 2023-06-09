package nopecho.mvc.adapter.out.persistence;

import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.annotation.Version;
import org.springframework.data.domain.AbstractAggregateRoot;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDateTime;

@Table("domain_user")
@Getter
@Builder
@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class UserEntity extends AbstractAggregateRoot<UserEntity> {

    @Id
    private Long id;
    @With
    private String username;
    @With
    private String password;
    @With
    private String email;

    @CreatedDate
    private LocalDateTime createdAt;
    @LastModifiedDate
    private LocalDateTime lastModifiedAt;
    @Version
    private Long version;
}
