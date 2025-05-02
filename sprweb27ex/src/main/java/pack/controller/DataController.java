package pack.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pack.model.DataProcess;
import pack.model.SangdataDto;

import java.util.List;

@RestController
public class DataController {
    @Autowired
    private DataProcess dataProcess;

    @PostMapping("/print")
    public List<SangdataDto> print() {
        return dataProcess.getSangDataAll();
    }

    @PostMapping("/insert")
    public String insert(@RequestBody SangdataBean sangdataBean) {
        dataProcess.insertSangData(sangdataBean);
        return "success";
    }

    @PutMapping("/update")
    public String update(@RequestBody SangdataBean sangdataBean) {
        dataProcess.updateSangData(sangdataBean);
        return "success";
    }

    @DeleteMapping("/delete/{code}")
    public String delete(@PathVariable("code")int code) {
        dataProcess.deleteSangData(code);
        return "success";
    }
}
