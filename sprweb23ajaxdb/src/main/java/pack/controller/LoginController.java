package pack.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class LoginController {
    @GetMapping("login")
    public String login(HttpSession session) {
        if(session.getAttribute("idKey") == null) {
            return "redirect:/login.html";
        } else {
            return "redirect:/buserlist";
        }
    }

    @PostMapping("login")
    public String login(HttpSession session, @RequestParam("id")String id, @RequestParam("pwd")String pwd) {
        if(id.equals("aa") && pwd.equals("123")) {
            session.setAttribute("idKey", id);
            return "redirect:/buserlist";
        } else {
            return "redirect:/login.html";
        }
    }

    @RequestMapping(value = "logout", method = RequestMethod.GET)
    public String logout(HttpSession session) {
        session.removeAttribute("idKey");
        return "redirect:/";
    }
}
