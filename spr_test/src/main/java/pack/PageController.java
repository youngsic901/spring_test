package pack;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageController {
    @GetMapping("/jsp")
    public String showJsp() {
        return "index"; // /WEB-INF/views/index.jsp
    }

    @GetMapping("/html")
    public String showHtml() {
        return "redirect:/example.html"; // /static/example.html
    }
}
