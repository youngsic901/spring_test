package pack.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BuserDto {
    private int buserno;
    private String busername;

    public Buser toEntity() {
        return Buser.builder()
                .buserno(this.buserno)
                .busername(this.busername)
                .build();
    }

    public static BuserDto fromEntity(Buser buser) {
        return BuserDto.builder()
                .buserno(buser.getBuserno())
                .busername(buser.getBusername())
                .build();
    }
}
