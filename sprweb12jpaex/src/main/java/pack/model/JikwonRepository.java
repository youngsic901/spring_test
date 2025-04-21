package pack.model;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface JikwonRepository extends JpaRepository<JikwonDto, Integer> {
    List<JikwonDto> findByJikwonjikContaining(String jikwonjik);
}
