package pack.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@Builder
public class JikwonDto {
    private int jikwonno;
    private String jikwonname;
    private List<GogekDto> gogekDtos;

    public static JikwonDto toDto(Jikwon jikwon) {
        return JikwonDto.builder()
                .jikwonno(jikwon.getJikwonno())
                .jikwonname(jikwon.getJikwonname())
                .gogekDtos(jikwon.getGogeks() != null ?
                        jikwon.getGogeks()
                                .stream()
                                .map(GogekDto::toDto)
                                .collect(Collectors.toList())
                        :null)
                .build();
    }
}
