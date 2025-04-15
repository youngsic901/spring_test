package pack.model;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.stereotype.Repository;

import pack.mybatis.SqlMapConfig;
import pack.mybatis.SqlMapperInter;

@Repository
public class PayImpl implements DataInter<PayDto>{
private SqlSessionFactory factory = SqlMapConfig.getSqlSession();
	
	@Override
	public List<PayDto> selectList() {
		SqlSession sqlSession = factory.openSession();
		List<PayDto> list = null;
		try {
			SqlMapperInter mapperInter = (SqlMapperInter)sqlSession.getMapper(SqlMapperInter.class);
			list = mapperInter.selectPay();
		} catch (Exception e) {
			System.out.println("selectList err : " + e);
		} finally {
			if(sqlSession != null) sqlSession.close();
		}
		
		return list;
	}
}
