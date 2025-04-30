package pack.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import pack.model.DataDao;
import pack.model.JikwonBean;
import pack.model.JikwonDto;

import java.util.HashMap;
import java.util.Map;

@RestController
public class DataController {
    @Autowired
    private DataDao jikwonDao;

    @PostMapping(value = "/findGogek")
    public Map<String, Object> findGogek(@RequestBody JikwonBean bean) {
        int jikwonno = bean.getJikwonno();
        String jikwonname = bean.getJikwonname();
        System.out.println(jikwonno + ":" + jikwonname);

        JikwonDto jikwonDto = jikwonDao.findData(jikwonno, jikwonname);
        Map<String, Object> gogekList = new HashMap<>();
        gogekList.put("datas", jikwonDto);
        return gogekList;
    }
}
