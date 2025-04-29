package pack.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class DataProcess {
    @Autowired
    private BuserRepository buserRepository;

    @Autowired
    private JikwonRepository jikwonRepository;

    @Autowired
    private GogekRepository gogekRepository;

    public List<Jikwon> jikwonBuserList() { // 직원 + 부서 자료 읽기
        List<Jikwon> list = jikwonRepository.findAll();
        System.out.println(list.get(0).getJikwonname() + " " + list.get(0).getBuser().getBusername());
        return list;
    }

    public List<Jikwon> jikwonGogekList() {
        List<Jikwon> list2 = jikwonRepository.findAll();
        System.out.println(list2.get(0).getJikwonname() + " " +
                list2.get(0).getGogeks().get(0).getGogekname() + " " +
                list2.get(0).getBuser().getBusername());

        return list2;
    }

    public List<String> gogekDamdangList() {
        List<String> damdangList = new ArrayList<>();
//        damdangList.add("고객 신선해님의 담당 직원은 홍길동 이사, 부서전화:02-22-2222");
//        damdangList.add("고객 신기루님의 담당 직원은 고길동 부장, 부서전화:02-33-3333");

        List<Gogek> gogekList = gogekRepository.findAll();
        for(Gogek gogek : gogekList) {
            if(gogek.getJikwon() != null) {
                String info = String.format("고객 %s님의 담당직원은 %s, %s, 부서전화:%s",
                        gogek.getGogekname(),
                        gogek.getJikwon().getJikwonname(),
                        gogek.getJikwon().getJikwonjik(),
                        gogek.getJikwon().getBuser().getBusertel());

                damdangList.add(info);
            }
        }
        return  damdangList;
    }
}
