package pack.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pack.model.JikwonDao;
import pack.model.JikwonDto;

import java.util.HashMap;
import java.util.Map;

@Controller
public class DataController {
    @Autowired
    private JikwonDao jikwonDao;

    @GetMapping("/findjikwon")
    @ResponseBody
    public Map<String, Object> findJikwon(HttpSession session) {
        int gogekDamsaNO = (int)session.getAttribute("gogekDamsaNO");
        JikwonDto jikwonDto = jikwonDao.findJikwon(gogekDamsaNO);

        Map<String, Object> jikwonMap = new HashMap<>();
        jikwonMap.put("datas", jikwonDto);
        return jikwonMap;
    }
}
