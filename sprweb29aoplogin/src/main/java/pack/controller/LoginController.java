package pack.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pack.model.DataDao;
import pack.model.Jikwon;

@Controller
public class LoginController {
    @Autowired
    private DataDao dataDao;

    @GetMapping("login")
    public String getLogin() {
        return "login";
    }

    @PostMapping("login")
    public String loginProcess(HttpSession httpsession,
                               @RequestParam("no")String no,
                               @RequestParam("name")String name) {
        Jikwon jikwon = dataDao.jikwonLogin(no);

//        System.out.println(jikwon.getJikwonname() + " " + jikwon.getJikwonno());
        if(jikwon != null) {
            if(name.equals(jikwon.getJikwonname())) {
                httpsession.setAttribute("nameok", name); // 로그인 성공으로 session  설정함
            }
        }

        return "redirect:/jikwonlist";
    }

    @GetMapping("logout")
    public String logoutProcess(HttpSession httpSession) {
        httpSession.removeAttribute("nameok");

        return "redirect:/";
    }
}
