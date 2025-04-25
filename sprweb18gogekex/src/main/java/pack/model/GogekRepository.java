package pack.model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface GogekRepository extends JpaRepository<Gogek, Integer> {
    @Query(value = """
    SELECT
        gogekno,
        gogekname,
        gogektel,
        CASE
            WHEN SUBSTR(gogekjumin, 8, 1) IN ('1', '3') THEN '남'
            WHEN SUBSTR(gogekjumin, 8, 1) IN ('2', '4') THEN '여'
            ELSE '?'
        END AS gogekgen,
        TIMESTAMPDIFF(
            YEAR,
            STR_TO_DATE(
                CASE
                    WHEN SUBSTR(gogekjumin, 8, 1) IN ('1','2') THEN CONCAT('19', SUBSTR(gogekjumin, 1, 6))
                    WHEN SUBSTR(gogekjumin, 8, 1) IN ('3','4') THEN CONCAT('20', SUBSTR(gogekjumin, 1, 6))
                    ELSE NULL
                END, '%Y%m%d'
            ),
            CURDATE()
        ) - (
            DATE_FORMAT(CURDATE(), '%m%d') <
            DATE_FORMAT(STR_TO_DATE(
                CASE
                    WHEN SUBSTR(gogekjumin, 8, 1) IN ('1','2') THEN CONCAT('19', SUBSTR(gogekjumin, 1, 6))
                    WHEN SUBSTR(gogekjumin, 8, 1) IN ('3','4') THEN CONCAT('20', SUBSTR(gogekjumin, 1, 6))
                    ELSE NULL
                END, '%Y%m%d'
            ), '%m%d')
        ) AS gogeknai
    FROM gogek
     WHERE
       (
           (:gender = '남' AND SUBSTR(gogekjumin, 8, 1) IN ('1', '3')) OR
           (:gender = '여' AND SUBSTR(gogekjumin, 8, 1) IN ('2', '4')) OR
           (:gender = '전체')
       )
""", nativeQuery = true)
    List<Gogek> findGogekWithGenderAndAge(String gender);
}
