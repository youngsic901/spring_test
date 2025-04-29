package pack.model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface JikwonRepository extends JpaRepository<Jikwon, Integer> {


    @Query("select j from Jikwon as j join j.buser b order by j.jikwonno")
    List<Jikwon> findAllWithBuser();

    @Query("select j from Jikwon as j join j.buser b where j.jikwonpay >= 5000")
    List<Jikwon> findAllWithHighPay();

    @Query("select j from Jikwon as j join j.buser b where b.busername = :busername")
    List<Jikwon> findAllBuserName(@Param("busername") String busername);


    // left join : Jikwon은 모두 나오고 buser는 없는 경우 null
    @Query("select j from Jikwon j left join j.buser b")
    List<Jikwon> findAllBuserLeftJoin();

    @Query("select j from Jikwon j right join j.buser b")
    List<Jikwon> findAllBuserRightJoin();

    // fetch join : join과 유사하나 JPA에서는 연관된 엔티티를 즉시 로딩할수 있도록 fetch 사용
    @Query("select j from Jikwon j join fetch j.buser b")
    List<Jikwon> findAllBuserFetch();

    // native query
    @Query(value = "select * from Jikwon j join buser b on j.busernum=b.buserno", nativeQuery = true)
    List<Jikwon> findAllBuserNative();

    // subquery : 가장 높은 연봉을 받는 직원 조회를 서브쿼리로 작성
    @Query("select j from Jikwon j where j.jikwonpay=(select max(j2.jikwonpay) from Jikwon j2)")
    List<Jikwon> findTopPaidJikwon();

    // 다음 조건 조인
    @Query("select j from Jikwon j join j.buser b where b.busername = :busername and j.jikwonpay > :minpay")
    List<Jikwon> findJikwonByBuserNameAndMinpay(@Param("busername") String busername, @Param("minpay") String minpay);
}
