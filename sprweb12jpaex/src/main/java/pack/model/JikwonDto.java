package pack.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "jikwon")
public class JikwonDto {
    @Id
    private String jikwonno;

    private String jikwonname, jikwongen, jikwonpay, jikwonjik;
}
