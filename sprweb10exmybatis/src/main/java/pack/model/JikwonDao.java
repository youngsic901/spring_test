package pack.model;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import pack.controller.JikwonBean;

import java.util.List;

@Repository
public class JikwonDao {
    @Autowired
    private JikwonMapperInter jikwonMapperInter;

    public List<JikwonDto> getJikwon(JikwonBean bean) {
        List<JikwonDto> list = jikwonMapperInter.selectJikwon(bean.getJikwonjik());
        return list;
    }
}
