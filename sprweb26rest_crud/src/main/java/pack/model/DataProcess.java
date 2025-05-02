package pack.model;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import pack.controller.MemBean;

import java.util.List;
import java.util.stream.Collectors;

@Repository
public class DataProcess {
    @Autowired
    private MemCrudRepository repository;

    // 전체자료
    public List<MemDto> getDataAll() {
        return repository.findAll().stream()
                .map(MemDto::toDto)
                .collect(Collectors.toList());
    }

    // 수정, 삭제를 위한 레코드 읽기
    public MemDto getData(String num) {
        return MemDto.toDto(repository.findByNum(num));
    }

    // 추가
    public String insert(MemBean bean) {
        // int max = repository.findByMaxNum(); // 번호 자동 증가시
        /*
        // 입력한 번호 확인
        try {
            MemDto memDto = MemDto.toDto(repository.findById(bean.getNum()).get());
            return "이미 등록된 번호 입니다.";
        } catch (Exception e) {
            // 등록 가능한 번호
            try {
                Mem mem = new Mem(bean.getNum(), bean.getName(), bean.getAddr());
                repository.save(mem);
                return "success";
            } catch (Exception e2) {
                return "입력자료 오류 : " + e2.getMessage();
            }
        }
        */
        if(repository.findById(bean.getNum()).isPresent()) {
            return "이미 등록된 번호 입니다.";
        }

        try {
            Mem mem = new Mem(bean.getNum(), bean.getName(), bean.getAddr());
            repository.save(mem);
            return "success";
        } catch (Exception e) {
            throw new RuntimeException("입력자료 오류 : " + e.getMessage()); // Spring 이 자동으로 rollback 실행
        }
    }

    // 수정
    @Transactional
    public String update(MemBean bean) {
        try {
            Mem mem = new Mem(bean.getNum(), bean.getName(), bean.getAddr());
            repository.save(mem); // update ...
            return "success";
        } catch (Exception e) {
            throw new RuntimeException("입력자료 오류 : " + e.getMessage());
        }
    }

    // 삭제
    @Transactional
    public String delete(int num) {
        try {
            repository.deleteById(num);
            return "success";
        } catch (Exception e) {
            throw new RuntimeException("삭제자료 오류 : " + e.getMessage());
        }
    }
}
