package pack.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pack.model.DataDao;
import pack.model.SangpumDto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class TestController {
    @Autowired
    private DataDao dataDao;

    @GetMapping("sangpums")
    @ResponseBody
    public Map<String, Object> abc() {
        /*
        List<Map<String ,String>> list = new ArrayList<>();
        Map<String ,String> data = null;

        for(SangpumDto s : dataDao.getSangpumAll()) {
            data = new HashMap<>();
            data.put("code", String.valueOf(s.getCode()));
            data.put("sang", s.getSang());
            data.put("su", s.getSu());
            data.put("dan", s.getDan());
            list.add(data);
        }
        System.out.println(data);

        Map<String, Object> sangList = new HashMap<>();
        sangList.put("datas", list);

        return sangList;
        */

        List<SangpumDto> list = dataDao.getSangpumAll();
        Map<String, Object> sangList = new HashMap<>();
        sangList.put("datas", list);

        return sangList;
    }
}
