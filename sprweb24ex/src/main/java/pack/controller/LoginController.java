package pack.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import pack.model.GogekDao;
import pack.model.GogekDto;
import pack.model.JikwonDao;
import pack.model.JikwonDto;

import java.util.HashMap;
import java.util.Map;

@Controller
public class LoginController {
    @Autowired
    private GogekDao gogekDao;

    @Autowired
    private JikwonDao jikwonDao;

    @PostMapping("gogeklogin")
//    @ResponseBody
    public String gogeklogin(@RequestBody Map<String, String> gogek, HttpSession session) {
        int gogekno = Integer.parseInt(gogek.get("gogekno"));
        String gogekname = gogek.get("gogekname");

        GogekDto gogekDto = gogekDao.findGogekDamsaNo(gogekno);

        if (gogekDto != null && gogekno == gogekDto.getGogekno() && gogekname.equals(gogekDto.getGogekname())) {
            session.setAttribute("idKey", gogekno);
            session.setAttribute("gogekDamsaNO", gogekDto.getGogekdamsano());

//            JikwonDto jikwonDto = jikwonDao.findJikwon(gogekDto.getGogekdamsano());
            return "redirect:/findjikwon";
        } else {
//            result.put("success", false);
//            result.put("message", "고객 정보가 일치하지 않습니다.");
            return "redirect:/index";
        }

//        return result;
    }

}
