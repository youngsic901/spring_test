package pack.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pack.model.GogekDto;
import pack.model.GogekProcess;

import java.util.List;

@Controller
public class GogekController {
    @Autowired
    private GogekProcess gogekProcess;

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("list")
    public String list() {
        return "list";
    }

    @PostMapping("list")
    public String listProcess(@RequestParam("gogekgen")String gogekgen, Model model) {
        System.out.println("gogekgen: " + gogekgen);
        List<GogekDto> list = gogekProcess.getGogeks(gogekgen);

        model.addAttribute("datas", list);
        return "list";
    }

}
