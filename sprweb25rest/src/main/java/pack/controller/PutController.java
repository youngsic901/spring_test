package pack.controller;

import org.springframework.web.bind.annotation.*;

@RestController
public class PutController {
    @PutMapping(value = "hiput")
    public String put1() {
        System.out.println("put 요청 접수 1");
        return "put 요청1 결과";
    }

    @PutMapping(value = "hiput2")
    public String put2(@RequestBody PostDataBean postDataBean) {
        String name = postDataBean.getName();
        String addr = postDataBean.getAddr();

        System.out.println("put 요청 접수 2");
        return "수정용 이름 : " + name + ", 주소 : " + addr;
    }

    @DeleteMapping(value = "/hidelete/{num}")
    public String delete(@PathVariable("num")String num) {
        System.out.println("delete 요청 접수 num : " + num);
        return "delete할 번호 : " + num;
    }

}
