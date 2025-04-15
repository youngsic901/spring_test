package pack.model;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.springframework.stereotype.Repository;

@Repository
public class DataImpl implements DataInterface{
	@Override
	public List<MemDto> selectDataAll() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
		EntityManager em = emf.createEntityManager(); // CRUD 수행 관리
		EntityTransaction tx = em.getTransaction(); // 트랜잭션을 관리하는 인터페이스
		
		List<MemDto> list = null;
		
		try {
			// 레코드 한 개 조회
			MemDto mdto = em.find(MemDto.class, 1);
			System.out.println(mdto.getNum() + " " + mdto.getName() + " " + mdto.getAddr());
			list = findAll(em, MemDto.class);
		} catch (Exception e) {
			System.out.println("selectDataAll err : " + e);
			tx.rollback();
		} finally {
			em.close();
			emf.close();
		}
		
		return list;
	}
	
	public List findAll(EntityManager em, Class cla) {
		// JPQL
		return em.createQuery("select e from " + cla.getName() + " e", cla).getResultList();
	}
}
