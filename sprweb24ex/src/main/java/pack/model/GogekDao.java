package pack.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class GogekDao {
    @Autowired
    private DataRepository2 dataRepository2;

    public GogekDto findGogekDamsaNo(int gogekno) {
        return GogekDto.toDto(dataRepository2.findByGogekno(gogekno));
    }
}
