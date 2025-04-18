package pack.model;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface JikwonMapperInter {
    @Select("select * from jikwon where jikwonjik = #{jikwonjik} ")
    List<JikwonDto> selectJikwon(String jikwonjik);
}
