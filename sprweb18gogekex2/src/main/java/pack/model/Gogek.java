package pack.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Gogek {
    @Id
    private int gogekno;
    private String gogekname, gogektel, gogekjumin;
}
