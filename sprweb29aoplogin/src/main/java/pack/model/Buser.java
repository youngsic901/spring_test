package pack.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Getter;

import java.util.List;

@Getter
@Entity
public class Buser {
    @Id
    private String buserno;

    private String busername;

    @OneToMany(mappedBy = "buser")
    private List<Jikwon> jikwons;
}
