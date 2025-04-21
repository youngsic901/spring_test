package pack.model;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class JikwonDao {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private JikwonRepository repository;

    public List<JikwonDto> getAllJikwon() {
        List<JikwonDto> list = repository.findAll();
        logger.info("인원수 : " + list.size() + "명");
        return list;
    }

    public List<JikwonDto> getJikwonSearch(String jikwonjik) {
        List<JikwonDto> list = repository.findByJikwonjikContaining(jikwonjik);
        logger.info("검색 인원수 : " + list.size() + "명");
        return list;
    }
}
