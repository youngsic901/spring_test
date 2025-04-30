package pack.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Gogek {
    @Id
    private int gogekno;

    private String gogekname;
    private String gogektel;

    @ManyToOne
    @JoinColumn(name = "gogekdamsano")
    private Jikwon jikwon;
}
