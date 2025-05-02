package pack.controller;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import pack.model.DataProcess;
import pack.model.Mem;
import pack.model.MemDto;

// HTML view controller
@Controller
@RequestMapping("/members")
public class MemViewController {
    @Autowired
    private DataProcess dataProcess;

//    @GetMapping("/")
//    public String index() {
//        return "index";
//    }

    @GetMapping("/list")
    public String list() {
        return "list";
    }

    @GetMapping("/new")
    public String insert() {
        return "insert";
    }

    @GetMapping("/update/{num}")
    public String updateProcess(@PathVariable("num")String num , Model model) { // 수정화면 호출
        MemDto memDto = dataProcess.getData(num);
        model.addAttribute("data", memDto);
        return "update";
    }
}
