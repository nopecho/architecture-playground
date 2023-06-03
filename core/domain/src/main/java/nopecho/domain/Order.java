package nopecho.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.With;

import java.util.List;

@Getter
@AllArgsConstructor
public class Order {

    private final Long id;
    @With
    private Status status;
    private List<Long> productIds;
}
