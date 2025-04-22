package pack.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
//@Table(name = "mem")
public class Mem {
    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY) // 자동 증가
    @Column(name = "num")
    private int num;
    @Column(name = "name", nullable = false)
    private String name;
    private String addr;
}
