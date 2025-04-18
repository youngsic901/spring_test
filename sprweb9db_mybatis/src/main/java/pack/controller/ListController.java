package pack.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pack.model.DataDao;
import pack.model.SanpumDto;

import java.util.ArrayList;

@Controller
public class ListController {
    @Autowired
    private DataDao dataDao;

    @GetMapping("testdb")
    public String listProcess(Model model) {
        ArrayList<SanpumDto> slist = (ArrayList<SanpumDto>)dataDao.getDataAll();
        model.addAttribute("datas", slist);
        return "list";
    }

    @GetMapping("search")
    public String searchProcess(FormBean bean, Model model) {
        ArrayList<SanpumDto> slist = (ArrayList<SanpumDto>)dataDao.getDataSearch(bean);
        model.addAttribute("datas", slist);
        return "list";
    }
}
