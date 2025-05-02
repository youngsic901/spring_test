package pack.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class MemDto {
    private int num;
    private String name;
    private String addr;

    public static MemDto toDto(Mem mem) {
        return MemDto.builder()
                .num(mem.getNum())
                .name(mem.getName())
                .addr(mem.getAddr())
                .build();
    }
}
