package pack.model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface GogekRepository extends JpaRepository<Gogek, Integer> {
    @Query("SELECT g FROM Gogek g JOIN g.jikwon j WHERE j.jikwonno = :jikwonno")
    List<Gogek> findByJikwonno(@Param("jikwonno") int jikwonno);
}
