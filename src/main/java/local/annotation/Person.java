package local.annotation;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Person {

    @NotNull
    private String name;

    @Length(min=3,max=7)
    private String userId;

}
