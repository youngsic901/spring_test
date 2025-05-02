package pack.controller;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pack.model.DataProcess;
import pack.model.MemDto;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api") // 요청 endpoint 경로에 /api를 prefix로 지정
public class MemController {
    @Autowired
    private DataProcess dataProcess;

    @Operation(summary = "전체자료", description = "test")
    @GetMapping("/members")
    public List<MemDto> listProcess() {
        return dataProcess.getDataAll();
    }

    @PutMapping("/members")
    public Map<String, Object> updateProcess(@RequestBody MemBean memBean) {
        dataProcess.update(memBean);
        return Map.of("isSuccess", true); // {"isSuccess":true} 형태로 직렬화
    }

    @PostMapping("/members")
    public Map<String, Object> insertProcess(@RequestBody MemBean memBean) {
        dataProcess.insert(memBean);
        return Map.of("isSuccess", true);
    }

    @DeleteMapping("/members/{num}")
    public Map<String, Object> deleteProcess(@PathVariable("num")int num) {
        dataProcess.delete(num);
        return Map.of("isSuccess", true);
    }
}
