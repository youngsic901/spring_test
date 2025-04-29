package pack;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Component
@Getter
@Setter
public class MyModel {
    private String name;
    private String[] skills;
}
