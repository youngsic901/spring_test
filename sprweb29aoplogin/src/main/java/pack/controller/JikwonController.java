package pack.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pack.model.DataDao;
import pack.model.Jikwon;

import java.util.List;

@Controller
public class JikwonController {
    @Autowired
    private DataDao dataDao;

    @GetMapping("jikwonlist")
    // AOP 로그인 처리시 pointcut 대상 메소드는 request, response가 반드시 있어야 함
    public String jikwonProcess(HttpServletResponse response, HttpServletRequest request, Model model) {
        List<Jikwon> jlist = dataDao.jikwonListAll();
        model.addAttribute("jlist", jlist);
        return "jikshow";
    }
}
