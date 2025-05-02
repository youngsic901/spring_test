package pack.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class TodoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String title;

    @Column(name = "todoOrder", nullable = false)
    private Integer order;

    @Column(nullable = false)
    private Boolean completed;
}
