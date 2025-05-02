package pack.model;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import pack.controller.TodoRequest;

import java.util.List;

//@Repository
@Service
@AllArgsConstructor
public class TodoService {
    private final TodoRepository todoRepository;

    // 일정관리 목록에 아이템 추가
    public TodoEntity add(TodoRequest request) { // insert
        TodoEntity todoEntity = new TodoEntity();
        todoEntity.setTitle(request.getTitle());
        todoEntity.setOrder(request.getOrder());
        todoEntity.setCompleted(request.getCompleted());
        return this.todoRepository.save(todoEntity); // save는 제네릭으로 받은 타입을 반환
    }

    // 일정관리 목록 중 특정 아이템 조회
    public TodoEntity searchById(Integer id) {
        System.out.println("searchById : " + id);
        return this.todoRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    // 일정관리 목록 전체 조회
    public List<TodoEntity> searchAll() {
        return this.todoRepository.findAll();
    }

    // 일정관리 목록 중 특정 아이템을 수정
    public TodoEntity updateById(Integer id, TodoRequest request) {
        TodoEntity todoEntity = searchById(id); // 수정 대상 레코드 읽기

        if(request.getTitle() != null) {
            todoEntity.setTitle(request.getTitle()); // 수정자료로 원본 자료를 덮어쓰기
        }

        if(request.getOrder() != null) {
            todoEntity.setOrder(request.getOrder());
        }

        if(request.getCompleted() != null) {
            todoEntity.setCompleted(request.getCompleted());
        }

        return  todoRepository.save(todoEntity);
    }

    // 일정관리 목록 중 특정 아이템 삭제
    public void deleteById(Integer id) {
        System.out.println("deleteById : " + id);
        todoRepository.deleteById(id);
    }

    // 일정관리 목록 전체 아이템 삭제
    public void deleteAll() {
        todoRepository.deleteAll();
    }
}
