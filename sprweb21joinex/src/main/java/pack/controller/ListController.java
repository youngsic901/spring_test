package pack.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pack.model.DataProcess;
import pack.model.GogekDto;
import pack.model.JikwonDto;

import java.util.List;

@Controller
public class ListController {
    @Autowired
    private DataProcess dataProcess;

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("list")
    public String list(Model model) {
        List<JikwonDto> list = dataProcess.getJikwon();
        model.addAttribute("lists", list);
        return "list";
    }

    @GetMapping("gogek")
    public String gogek(@RequestParam("jikwonno") int jikwonno, @RequestParam("jikwonname")String jikwonname, Model model) {
        System.out.println("gogek");
        List<GogekDto> list = dataProcess.getGogek(jikwonno);
        model.addAttribute("jikwonname", jikwonname);
        model.addAttribute("lists", list);
//        System.out.println(list.getFirst().getGogekname());
        return "gogek";
    }
}
