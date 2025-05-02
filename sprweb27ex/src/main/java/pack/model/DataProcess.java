package pack.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pack.controller.SangdataBean;

import java.util.List;
import java.util.stream.Collectors;

@Repository
public class DataProcess {
    @Autowired
    private SangdataRepository sangdataRepository;

    // 전체 자료 읽기
    public List<SangdataDto> getSangDataAll() {
        return sangdataRepository.findAll().stream()
                .map(SangdataDto::toDto)
                .collect(Collectors.toList());
    }

    public String insertSangData(SangdataBean sangdataBean) {
        if(sangdataRepository.findById(sangdataBean.getCode()).isPresent()) {
            return "이미 등록된 번호 입니다.";
        }

        try {
            Sangdata sangdata = new Sangdata(sangdataBean.getCode(), sangdataBean.getSang(), sangdataBean.getSu(), sangdataBean.getDan());
            sangdataRepository.save(sangdata);
            return "success";
        } catch (Exception e) {
            throw new RuntimeException("등록자료 오류 : " + e.getMessage());
        }
    }

    @Transactional
    public String updateSangData(SangdataBean sangdataBean) {
        if(sangdataRepository.findById(sangdataBean.getCode()).isEmpty()) {
            return "업데이트할 자료가 없습니다.";
        }
        
        try {
            Sangdata sangdata = new Sangdata(sangdataBean.getCode(), sangdataBean.getSang(), sangdataBean.getSu(), sangdataBean.getDan());
            sangdataRepository.save(sangdata);
            return "success";
        } catch (Exception e) {
            throw new RuntimeException("등록자료 오류 : " + e.getMessage());
        }
    }

    @Transactional
    public String deleteSangData(int code) {
        if(sangdataRepository.findById(code).isEmpty()) {
            return "삭제할 자료가 없습니다.";
        }
        try {
            sangdataRepository.deleteById(code);
            return "success";
        } catch (Exception e) {
            throw new RuntimeException("삭제자료 오류 : " + e.getMessage());
        }
    }
}
