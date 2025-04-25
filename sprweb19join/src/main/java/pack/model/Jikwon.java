package pack.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "jikwon")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Jikwon {
    @Id
    private int jikwonno;

    private String jikwonname;
    private String jikwonjik;
    private int jikwonpay;

    // Jikwon 엔티티는 Buser 엔티티와 다대일 관계
    @ManyToOne
    @JoinColumn(name = "busernum") // FK 관계 설정
    private Buser buser; // Jikwon에 속한 이 필드는 Buser 엔티티를 참조하기 때문에 Buser 객체에 접근 가능
}
