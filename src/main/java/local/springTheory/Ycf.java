package local.springTheory;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Ycf {

    @NameAnnotation
    private String name;

    @AgeAnnotation(age=28)
    private int age;

    @GreetAnnotation
    public void greet(String greetMsg) {
        System.out.println(greetMsg);
    }

}
