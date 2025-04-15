package pack.model;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.stereotype.Repository;

import pack.mybatis.SqlMapConfig;
import pack.mybatis.SqlMapperInter;

@Repository
public class JikwonImpl implements DataInter<JikwonDto>{
	private SqlSessionFactory factory = SqlMapConfig.getSqlSession();
	
	@Override
	public List<JikwonDto> selectList() {
		SqlSession sqlSession = factory.openSession();
		List<JikwonDto> list = null;
		try {
			SqlMapperInter mapperInter = (SqlMapperInter)sqlSession.getMapper(SqlMapperInter.class);
			list = mapperInter.selectJikwon();
		} catch (Exception e) {
			System.out.println("selectList err : " + e);
		} finally {
			if(sqlSession != null) sqlSession.close();
		}
		
		return list;
	}
}
