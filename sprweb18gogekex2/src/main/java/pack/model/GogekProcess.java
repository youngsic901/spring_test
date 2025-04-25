package pack.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
public class GogekProcess {
    @Autowired
    private GogekRepository gogekRepository;

    public List<GogekDto> getGogeks(String gogekgen) {
        List<Gogek> list = gogekRepository.findAll();

        return list.stream()
                .map(GogekDto::fromEntity)
                .filter(dto -> {
                    if("전체".equals(gogekgen)) return true;
                    return dto.getGogekgen().equals(gogekgen);
                })
                .collect(Collectors.toList());
    }

}
