package pack.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;
//import jakarta.persistence.Table;

@Entity
//@Table(name = "buser")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
// 빌더 패턴이 가능 => 복잡한 생성자나 매개변수가 많을 때 유효한 디자인 패턴
// step by step 으로 값을 입력한 후에 최종적으로 build() 메소드로 하나의 인스턴스를 생성하여 반환
public class Buser {
    @Id
    private int buserno;

    private String busername;
    private String buserloc;
    private String busertel;
}
