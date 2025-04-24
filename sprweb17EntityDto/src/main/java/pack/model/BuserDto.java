package pack.model;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BuserDto {
    // 엔티티로부터 전체 또는 필요한 데이터(정보)만 추출한 후 클라이언트에 전송하는 역할
    private int buserno;
    private String busername;
    private String buserloc;
    private String busertel;

    // 빌더 패턴을 사용하지 않은 경우
    /*
    public static BuserDto fromEntity(Buser entity) {
        BuserDto dto = new BuserDto();
        dto.setBuserno(entity.getBuserno());
        dto.setBusername(entity.getBusername());
        dto.setBuserloc(entity.getBuserloc());
        dto.setBusertel(entity.getBusertel());
        return dto;
    }
     */
    public static BuserDto fromEntity(Buser entity) {
        return  BuserDto.builder()
                .buserno(entity.getBuserno())
                .busername(entity.getBuserloc())
                .buserloc(entity.getBuserloc())
                .build();
    }
}
