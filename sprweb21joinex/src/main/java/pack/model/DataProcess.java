package pack.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
public class DataProcess {
    @Autowired
    private JikwonRepository jikwonRepository;

    @Autowired
    private GogekRepository gogekRepository;

    public List<JikwonDto> getJikwon() {
        List<Jikwon> list = jikwonRepository.findAll()  ;
        return list.stream()
                .map(JikwonDto::fromEntity)
                .collect(Collectors.toList());
    }

    public List<GogekDto> getGogek(int jikwonno) {
        System.out.println("getGogek");
        List<Gogek> list = gogekRepository.findByJikwonno(jikwonno);

        return list.stream()
                .map(GogekDto::fromEntity)
                .collect(Collectors.toList());
    }
}
