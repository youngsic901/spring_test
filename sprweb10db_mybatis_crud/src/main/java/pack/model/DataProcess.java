package pack.model;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import pack.controller.MemBean;

import java.util.List;

@Repository
public class DataProcess {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private DataMapperInterface mapperInterface; // 자동으로 pooling(DBCP) - HikariPool

    // 전체 자료 읽기
    public List<MemDto> getDataAll() {
        List<MemDto> list = mapperInterface.selectAll();
        logger.info("datas : " + list.size());
        return list;
    }

    // 추가
    public boolean insert(MemBean bean) {
        // 번호 중복 확인 또는 번호 자동 증가 생략
        logger.info("num : " + bean.getNum());

        int re = mapperInterface.insertData(bean);
        if (re > 0) {
            return true;
        } else {
            return false;
        }

    }
}