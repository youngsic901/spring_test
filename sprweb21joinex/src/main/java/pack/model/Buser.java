package pack.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Buser {
    @Id
    private int buserno;
    private String busername;

    @OneToMany(mappedBy = "buser")
    private List<Jikwon> jikwons;
}
