package pack.model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface JikwonRepository extends JpaRepository<Jikwon, Integer> {
    @Query("select j from Jikwon  as j join j.buser b")
    List<Jikwon> findAllWithBuser();
}
