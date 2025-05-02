package pack.model;

import lombok.Data;

@Data
public class TodoResponse {
    private Integer id;
    private String title;
    private Integer order;
    private Boolean completed;

    public TodoResponse(TodoEntity todoEntity) { // 생성자로 Entity를 Dto에게 전달
        this.id = todoEntity.getId();
        this.title = todoEntity.getTitle();
        this.order = todoEntity.getOrder();
        this.completed = todoEntity.getCompleted();
    }
}
