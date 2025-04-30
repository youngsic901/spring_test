package pack.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class JikwonDao {
    @Autowired
    private DataRepository dataRepository;

    // 담당직원 가져오기
    public JikwonDto findJikwon(int jikwonno) {
        return JikwonDto.toDto(dataRepository.findFirstByJikwonno(jikwonno));
    }
}
