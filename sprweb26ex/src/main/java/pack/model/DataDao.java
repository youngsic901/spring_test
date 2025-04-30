package pack.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class DataDao {
    @Autowired
    private DataRepository dataRepository;

    public JikwonDto findData(int jikwonno, String jikwonname) {
        Jikwon jikwon = dataRepository.findByJikwonnoAndJikwonname(jikwonno, jikwonname);

        return JikwonDto.toDto(jikwon);
    }
}
