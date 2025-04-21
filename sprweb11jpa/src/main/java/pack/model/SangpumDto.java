package pack.model;

import jakarta.persistence.Column;
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
@Table(name = "sangdata")
public class SangpumDto { // JPA는 실제 테이블 sangdata를 영속성 컨텍스트에서 SangpumDto 클래스로 처리
    @Id // sangdata 테이블의 primary key 칼럼과 매핑. JPA는 이 필드를 기준으로 레코드를 식별
    @Column(name = "code") // sangdata 테이블의 code 칼럼과 SangpumDto의 code 필드를 연결
    private int code;

    @Column(name = "sang", nullable = false) // null 허용 안함
    private String sang;
    private int su;
    private int dan;
}
