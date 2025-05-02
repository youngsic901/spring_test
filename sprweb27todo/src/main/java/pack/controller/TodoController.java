package pack.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;
import pack.model.TodoEntity;
import pack.model.TodoResponse;
import pack.model.TodoService;

import java.util.List;

@RestController
@AllArgsConstructor
@CrossOrigin(origins = "*") // 기본적으로 다른 도메인에서 서버에 요청한 내용은 차단되지만 해당 어노테이션은 모든 도메인 요청을 허용
@RequestMapping("/data")
public class TodoController {
    private final TodoService service;

    @PostMapping
    public ResponseEntity<TodoResponse> create(@RequestBody TodoRequest request) {
        System.out.println("create(insert)");

        if(ObjectUtils.isEmpty(request.getTitle())) {
            return ResponseEntity.badRequest().build(); // 에러가 있는 경우 에러 코드 반환
        }

        if(ObjectUtils.isEmpty(request.getOrder())) {
            request.setOrder(0); // Order 가 없는 경우 0으로 설정
        }

        if(ObjectUtils.isEmpty(request.getCompleted())) {
            request.setCompleted(false); // completed 가 없는 경우 false로 설정
        }

        TodoEntity entity = service.add(request); // insert 처리 후 결과 반환
        System.out.println("insert result : " + ResponseEntity.ok(new TodoResponse(entity)));

        return ResponseEntity.ok(new TodoResponse(entity)); // JSON 형식으로 반환됨
    }

    @GetMapping
    public ResponseEntity<List<TodoResponse>> readAll() {
        System.out.println("readAll");

        List<TodoEntity> list = service.searchAll();
        // Entity를 Dto로 변환
        List<TodoResponse> responses = list.stream().map(TodoResponse::new).toList();
        // new 는 new TodoResponse(todoEntity)를 의미
        System.out.println("readAll result : " + ResponseEntity.ok(responses));
        return ResponseEntity.ok(responses);
    }

    @GetMapping(value = "{id}")
    public ResponseEntity<TodoResponse> readOne(@PathVariable(name = "id")Integer id) {
        System.out.println("readOne");

        TodoEntity entity = service.searchById(id);
        // Entity를 Dto로 변환
        return ResponseEntity.ok(new TodoResponse(entity)); // 생성자를 이용해 Entity를 Dto로 변환 후 반환
    }

    @PatchMapping("{id}")
    public ResponseEntity<TodoEntity> update(@PathVariable(name = "id")Integer id, @RequestBody TodoRequest request) {
        System.out.println("update");

        TodoEntity entity = service.updateById(id, request);
        System.out.println("update one : " + ResponseEntity.ok(entity));

        return ResponseEntity.ok(entity);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> deleteOne(@PathVariable(name = "id")Integer id) {
        System.out.println("deleteOne");

        service.deleteById(id);
        System.out.println("deleteOne : " + ResponseEntity.ok());

        return ResponseEntity.ok().build(); // 200 ok 만 반환. 처리 성공만 알림
    }

    @DeleteMapping
    public ResponseEntity<?> deleteAll() {
        System.out.println("deleteAll");

        service.deleteAll();
        System.out.println("deleteAll : " + ResponseEntity.ok());

        return ResponseEntity.ok().build(); // 200 ok 만 반환. 처리 성공만 알림
    }
}
