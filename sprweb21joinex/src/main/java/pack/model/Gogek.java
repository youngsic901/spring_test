package pack.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Gogek {
    @Id
    private int gogekno;

    private String gogekname;
    private String gogektel;
    private String gogekjumin;

    @ManyToOne
    @JoinColumn(name = "gogekdamsano")
    private Jikwon jikwon;
}
