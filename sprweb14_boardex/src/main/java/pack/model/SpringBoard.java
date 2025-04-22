package pack.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "springboard")
@Getter
@Setter
public class SpringBoard {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // auto_increment
    private Integer num;

    private String author;
    private String title;

    @Column(columnDefinition = "TEXT")
    private String content;

    private LocalDateTime bwrite;
    private Integer readcnt;


}
