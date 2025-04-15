package pack.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import pack.model.BuserDto;
import pack.model.DataInter;
import pack.model.JikwonDto;
import pack.model.PayDto;

@Service
public class BusinessImpl implements BusinessInter{
	@Autowired
	@Qualifier("jikwonImpl")
	private DataInter<JikwonDto> inter;
	@Autowired
	@Qualifier("buserImpl")
	private DataInter<BuserDto> inter2;
	@Autowired
	@Qualifier("payImpl")
	private DataInter<PayDto> inter3;
	
	@Override
	public void printData() {
		List<JikwonDto> list = inter.selectList();
		List<BuserDto> list2 = inter2.selectList();
		List<PayDto> list3 = inter3.selectList();
		
		for(JikwonDto j : list) {
			System.out.println(j.getJikwonNo() + " " + j.getJikwonName() + " " + j.getBuserName() + " " + j.getIbsa());
		}
		
		System.out.println();
		
		for(BuserDto b : list2) {
			System.out.println(b.getBuserName() + " " + b.getInwon());
		}
		
		System.out.println();
		
		for(PayDto p : list3) {
			System.out.println(p.getBuserName() + " " + p.getJikwonName() + " " + p.getJikwonPay());
		}
	}
}
