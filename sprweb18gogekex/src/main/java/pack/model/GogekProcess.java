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
        List<Gogek> list = gogekRepository.findGogekWithGenderAndAge(gogekgen);

        return list.stream()
                .map(GogekDto::fromEntity)
                .collect(Collectors.toList());
    }

}
