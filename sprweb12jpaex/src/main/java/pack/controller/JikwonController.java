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
    public String listJikwon(JikwonBean bean,  Model model) {
        ArrayList<JikwonDto> jikwonList;
//        if(bean.getJikwonjik().isEmpty()) {
//            jikwonList = (ArrayList<JikwonDto>)jikwonDao.getAllJikwon();
//        } else {
//            jikwonList = (ArrayList<JikwonDto>)jikwonDao.getJikwonSearch(bean.getJikwonjik());
//        }
        jikwonList = bean.getJikwonjik().isEmpty()
                ?(ArrayList<JikwonDto>)jikwonDao.getAllJikwon()
                :(ArrayList<JikwonDto>)jikwonDao.getJikwonSearch(bean.getJikwonjik());

        model.addAttribute("jikwons", jikwonList);
        return "list";
    }
}
