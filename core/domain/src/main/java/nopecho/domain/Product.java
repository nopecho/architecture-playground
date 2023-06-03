package nopecho.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.With;

@Getter
@AllArgsConstructor
public class Product {

    private final Long id;
    @With
    private String name;
    private Integer price;
}
