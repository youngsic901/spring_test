package pack.model;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpringBoardRepository extends JpaRepository<SpringBoard, Integer> {
    // 기본 메소드 findAll, save, findById
    Page<SpringBoard> findByTitleContaining(String keyword, Pageable pageable);
    Page<SpringBoard> findByAuthorContaining(String keyword, Pageable pageable);
    Page<SpringBoard> findByContentContaining(String keyword, Pageable pageable);
}
