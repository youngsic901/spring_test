package pack.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Gogek {
    @Id
    private int gogekno;

    private String gogekname;
    private int gogekdamsano;
}
