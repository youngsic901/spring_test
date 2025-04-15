package pack.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pack.model.DataInterface;
import pack.model.MemDto;

@Service
public class BusinessImpl implements BusinessInter{
	@Autowired
	private DataInterface dataInterface;
	
	@Override
	public void dataList() {
		List<MemDto> list = (List<MemDto>)dataInterface.selectDataAll();
		System.out.println("dataList에서 자료 출력");
		for(MemDto m : list) {
			System.out.println(m.getNum() + " " + m.getName() + " " + m.getAddr());
		}
	}
}
