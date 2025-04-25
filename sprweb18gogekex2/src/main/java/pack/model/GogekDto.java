package pack.model;

import lombok.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class GogekDto {
    private int gogekno, gogekage;
    private String gogekname, gogektel,gogekgen;

    public static String parseGogekgen(String gogekjumin) {
        if(gogekjumin.charAt(7) == '1' || gogekjumin.charAt(7) == '3') {
            return "남";
        } else if(gogekjumin.charAt(7) == '2' || gogekjumin.charAt(7) == '4') {
            return "여";
        } else {
            return "성별불명";
        }
    }

    public static int parseGogekage(String gogekjumin) {
        LocalDate now = LocalDate.now();
        String birthYearPre;
        LocalDate birthDay;

        if(gogekjumin.charAt(7) == '1' || gogekjumin.charAt(7) == '2') {
            birthYearPre = "19";
        } else {
            birthYearPre = "20";
        }

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");
        birthDay = LocalDate.parse(birthYearPre + gogekjumin.substring(0,6),formatter);

        int age = now.getYear() - birthDay.getYear();
        System.out.println( "age : " + age);
        return age;
    }

    public static GogekDto fromEntity(Gogek entity) {
        return GogekDto.builder()
                .gogekno(entity.getGogekno())
                .gogekname(entity.getGogekname())
                .gogektel(entity.getGogektel())
                .gogekgen(parseGogekgen(entity.getGogekjumin()))
                .gogekage(parseGogekage(entity.getGogekjumin()))
                .build();
    }
}
