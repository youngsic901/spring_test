package pack.model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface MemCrudRepository extends JpaRepository<Mem, Integer> {
    @Query(value = "select max(m.num) from Mem as m")
    int findMaxNum();

    @Query(value = "select m from Mem as m where m.num=?1")
    Mem findByNum(String num);
}
