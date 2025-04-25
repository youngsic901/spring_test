package pack.controller;

import lombok.*;
import pack.model.Gogek;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class GogekBean {
    private int gogekno;
    private String gogekname, gogektel,gogekjumin;

    public Gogek toEntity() {
        return Gogek.builder()
                .gogekno(this.gogekno)
                .gogekname(this.gogekname)
                .gogektel(this.gogektel)
                .gogekjumin(this.gogekjumin)
                .build();
    }
}
