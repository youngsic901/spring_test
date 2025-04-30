package pack.model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

public interface DataRepository extends JpaRepository<Jikwon, Integer> {
    Jikwon findByJikwonnoAndJikwonname(@Param("jikwonno")int jikwonno, @Param("jikwonname")String jikwonname);
}
