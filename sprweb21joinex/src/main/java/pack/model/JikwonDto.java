package pack.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class JikwonDto {
    private int jikwonno;
    private String jikwonname;
    private String jikwonjik;
    private BuserDto buserDto;
    private List<GogekDto> gogekDtos;

    private String hasGogeks; // 추가! 담당고객여부 ("있음"/"없음")

    public Jikwon toEntity() {
        return Jikwon.builder()
                .jikwonno(this.jikwonno)
                .jikwonname(this.jikwonname)
                .jikwonjik(this.jikwonjik)
                .buser(this.buserDto != null ? this.buserDto.toEntity() : null)
                .build();
    }

    public static JikwonDto fromEntity(Jikwon jikwon) {
        return JikwonDto.builder()
                .jikwonno(jikwon.getJikwonno())
                .jikwonname(jikwon.getJikwonname())
                .jikwonjik(jikwon.getJikwonjik())
                .buserDto(jikwon.getBuser() != null ? BuserDto.fromEntity(jikwon.getBuser()) : null)
                .gogekDtos(jikwon.getGogeks() != null ?
                        jikwon.getGogeks()
                                .stream()
                                .map(GogekDto::fromEntity)
                                .collect(Collectors.toList())
                        :null)
                // .hasGogeks(jikwon.getGogeks() != null && !jikwon.getGogeks().isEmpty() ? "O" : "X") // 여기가 핵심
                .build();
    }
}
