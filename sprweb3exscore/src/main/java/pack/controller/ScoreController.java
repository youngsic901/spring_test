package pack.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ScoreController {
    // log 정보 출력
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @GetMapping("input")
    public String moveInput(){
        return "redirect:http://localhost/input.html";
    }

    @PostMapping("score")
    public String moveDisplay(@RequestParam String user, @RequestParam int javaScore, @RequestParam int pythonScore, Model model){
//        logger.info(user + " " + javaScore + " " + pythonScore);

        model.addAttribute("user", user);
        model.addAttribute("javaScore", javaScore);
        model.addAttribute("pythonScore", pythonScore);
        return "display";
    }
}
