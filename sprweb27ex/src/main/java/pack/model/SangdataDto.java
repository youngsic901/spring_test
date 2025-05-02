package pack.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class SangdataDto {
    private int code;
    private String sang;
    private String su;
    private String dan;

    public static SangdataDto toDto(Sangdata sangdata) {
        return SangdataDto.builder()
                .code(sangdata.getCode())
                .sang(sangdata.getSang())
                .su(sangdata.getSu())
                .dan(sangdata.getDan())
                .build();
    }
}
