package pack.model;

import org.springframework.data.jpa.repository.JpaRepository;

public interface DataRepository2 extends JpaRepository<Gogek, Integer> {
    Gogek findByGogekno(int gogekno);
}
