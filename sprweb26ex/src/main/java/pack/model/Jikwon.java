package pack.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class Jikwon {
    @Id
    private int jikwonno;

    private String jikwonname;

    @OneToMany(mappedBy = "jikwon")
    private List<Gogek> gogeks;
}
