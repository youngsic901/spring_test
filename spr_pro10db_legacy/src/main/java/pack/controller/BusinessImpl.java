package pack.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import pack.model.SangpumDto;
import pack.model.SangpumInter;

import java.util.ArrayList;

@Service
public class BusinessImpl implements BusinessInter {
    @Autowired
    private SangpumInter sangpumInter;

    @Override
    public void dataShow(){
        ArrayList<SangpumDto> list = sangpumInter.selectList();

        for(SangpumDto s : list){
            System.out.println(s.getCode() + " " + s.getSang() + " " + s.getSu() + " " + s.getDan());
        }
    }
}
