package pack;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class JsonController {
    @Autowired
    private MyModel myModel;

    @GetMapping("list")
    @ResponseBody // 반환 객체를 http 응답객체로 전송. 문자열 또는 JSON 형식의 결과 반환
    public MyModel getJson(@RequestParam("name")String name){
        myModel.setName(name);
        myModel.setSkills(new String[] {"자바 개발자", "웹 개발자"});
        return myModel;
    }

    @GetMapping("list2")
    @ResponseBody
    public Map<String, Object> getJson2() {
        List<Map<String, String>> dataList = new ArrayList<Map<String, String>>();

        Map<String, String> data = new HashMap<>();
        data.put("name", "손오공");
        data.put("age", "33");
        dataList.add(data);

        data = new HashMap<>();
        data.put("name", "저팔계");
        data.put("age", "31");
        dataList.add(data);

        data = new HashMap<>();
        data.put("name", "사오정");
        data.put("age", "30");
        dataList.add(data);

        Map<String, Object> data2 = new HashMap<String, Object>();
        data2.put("datas", dataList);
        return data2;
    }
}
