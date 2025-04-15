package pack.mybatis;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import pack.model.BuserDto;
import pack.model.JikwonDto;
import pack.model.PayDto;

public interface SqlMapperInter {
	@Select("SELECT jikwonno, jikwonname, nvl(busername, '무소속') AS busername, SUBSTR(jikwonibsail, 1, 4) AS ibsa FROM jikwon LEFT JOIN buser ON buserno = busernum")
	public List<JikwonDto> selectJikwon();
	
	@Select("SELECT busername, COUNT(*) AS inwon FROM buser RIGHT JOIN jikwon ON buserno = busernum GROUP BY buserno")
	public List<BuserDto> selectBuser();
	
	@Select("SELECT jikwonname, MAX(jikwonpay) AS jikwonpay, \r\n"
			+ "case\r\n"
			+ "	when busername IS NULL then '무소속'\r\n"
			+ "	ELSE busername\r\n"
			+ "	END AS busername\r\n"
			+ "FROM jikwon \r\n"
			+ "LEFT JOIN buser ON buserno = busernum\r\n"
			+ "GROUP BY buserno")
	public List<PayDto> selectPay();
	
}
