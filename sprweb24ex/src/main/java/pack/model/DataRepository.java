package pack.model;

import org.springframework.data.jpa.repository.JpaRepository;

public interface DataRepository extends JpaRepository<Jikwon, Integer> {
    Jikwon findFirstByJikwonno(int jikwonno);
}
