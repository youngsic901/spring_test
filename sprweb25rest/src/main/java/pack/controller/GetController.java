package pack.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

//@Controller
//@ResponseBody
@RestController// Controller 와 ResponseBody를 합친 어노테이션
public class GetController {
    @GetMapping(value = "/hello")
    public String abc() {
        System.out.println("요청1 접수");
        return "hello world";
    }

    @GetMapping(value = "/hello/{info}")
    public String abc2(@PathVariable("info")String info) {
        System.out.println("요청2 접수");
        return info;
    }

    @GetMapping(value = "/world")
    public String abc3(@RequestParam("name")String irum, @RequestParam("age")String nai) {
        System.out.println("요청3 접수");
        return irum + " " + nai;
    }
}
