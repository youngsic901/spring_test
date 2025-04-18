package pack.model;

import org.apache.ibatis.annotations.*;
import pack.controller.MemBean;

import java.util.List;

@Mapper
public interface DataMapperInterface {
    @Select("select num, name, addr from mem")
    List<MemDto> selectAll();

    @Select("select * from mem where num=#{num}")
    MemDto selectPart(String num);

    @Insert("insert into mem values(#{num}, #{name}, #{addr})")
    int insertData(MemBean bean);

    @Update("update mem set name=#{name}, addr=#{addr} where num=#{num}")
    int updateData(MemBean bean);

    @Delete("delete from mem where num=#{num}")
    int deleteData(String num);
}
