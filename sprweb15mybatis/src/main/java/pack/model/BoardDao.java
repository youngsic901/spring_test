package pack.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BoardDao {
    @Autowired
    private DataMapperInterface mapperInterface;

    public List<Board> list() {
        List<Board> list = null;

        try {
            list = mapperInterface.selectDataAll();
        } catch (Exception e) {
            System.out.println("list err : " + e);
        }

        return list;
    }
}
