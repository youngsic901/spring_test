package pack.model;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface DataMapperInterface {
    @Select("select * from sangdata")
    List<SanpumDto> selectAll();

    @Select("select * from sangdata where sang like concat('%', #{searchValue}, '%')")
    List<SanpumDto> selectSearch(String searchValue);

    // MariaDB : where sang like concat('%', #{searchValue}, '%')
    // Oracle : where sang like '%' || #{searchValue} || '%'
}
