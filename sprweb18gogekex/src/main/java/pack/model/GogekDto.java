package pack.model;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class GogekDto {
    private int gogekno;
    private String gogekname, gogektel, gogekgen, gogeknai;

    public static GogekDto fromEntity(Gogek entity) {
        return GogekDto.builder()
                .gogekno(entity.getGogekno())
                .gogekname(entity.getGogekname())
                .gogektel(entity.getGogektel())
                .gogekgen(entity.getGogekgen())
                .gogeknai(entity.getGogeknai())
                .build();
    }
}
