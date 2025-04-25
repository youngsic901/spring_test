package pack.model;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class JikwonDto {
    private int jikwonno;
    private String jikwonname;
    private String jikwonjik;
    private int jikwonpay;
    private BuserDto buserDto;

    // DTO -> Entity
    public Jikwon toEntity() {
//        Jikwon jikwon = new Jikwon();
//        jikwon.setJikwonno(this.jikwonno);
//        jikwon.setJikwonname(this.jikwonname);
//        jikwon.setJikwonjik(this.jikwonjik);
//        jikwon.setJikwonpay(this.jikwonpay);
//        if(this.buserDto != null) {
//            jikwon.setBuser(this.buserDto.toEntity());
//        }
//        return jikwon;

        // 위의 코드를 Builder를 사용해 리팩토링
        return Jikwon.builder()
                .jikwonno(this.jikwonno)
                .jikwonname(this.jikwonname)
                .jikwonjik(this.jikwonjik)
                .jikwonpay(this.jikwonpay)
                .buser(this.buserDto != null ? this.buserDto.toEntity() : null)
                .build();
    }

    // Entity -> DTO
    public static JikwonDto fromEntity(Jikwon jikwon) {
//        JikwonDto dto = new JikwonDto();
//        dto.setJikwonno(jikwon.getJikwonno());
//        dto.setJikwonname(jikwon.getJikwonname());
//        dto.setJikwonjik(jikwon.getJikwonjik());
//        dto.setJikwonpay(jikwon.getJikwonpay());
//        if(jikwon.getBuser() != null) {
//            dto.setBuserDto(BuserDto.fromEntity(jikwon.getBuser()));
//        }
//        return dto;

        return JikwonDto.builder()
                .jikwonno(jikwon.getJikwonno())
                .jikwonname(jikwon.getJikwonname())
                .jikwonjik(jikwon.getJikwonjik())
                .jikwonpay(jikwon.getJikwonpay())
                .buserDto(jikwon.getBuser() != null ? BuserDto.fromEntity(jikwon.getBuser()):null)
                .build();
    }
}
