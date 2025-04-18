package pack.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import pack.model.JikwonDao;
import pack.model.JikwonDto;

import java.util.ArrayList;

@Controller
public class JikwonController {
    @Autowired
    private JikwonDao jikwonDao;

    @PostMapping("jikwon")
    public String searchProcess(JikwonBean bean, Model model) {
//        if(bean.getJikwonjik().isEmpty()) {
//            return "redirect:warning.html";
//        } else {
//            ArrayList<JikwonDto> slist = (ArrayList<JikwonDto>)jikwonDao.getJikwon(bean);
//            model.addAttribute("jikwons", slist);
//            return "list";
//        }
        ArrayList<JikwonDto> slist = (ArrayList<JikwonDto>)jikwonDao.getJikwon(bean);
        model.addAttribute("jikwons", slist);
        return "list";
    }
}
