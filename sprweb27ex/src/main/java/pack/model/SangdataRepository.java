package pack.model;

import org.springframework.data.jpa.repository.JpaRepository;

public interface SangdataRepository extends JpaRepository<Sangdata, Integer> {
    Sangdata findByCode(int code);
}
