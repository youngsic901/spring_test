package pack.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class GogekDto {
    private int gogekno;
    private String gogekname;
    private String gogektel;



    public static GogekDto toDto(Gogek gogek) {
        return GogekDto.builder()
                .gogekno(gogek.getGogekno())
                .gogekname(gogek.getGogekname())
                .gogektel(gogek.getGogektel())
                .build();
    }
}
