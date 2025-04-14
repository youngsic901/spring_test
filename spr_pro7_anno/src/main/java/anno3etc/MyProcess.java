package anno3etc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service("my")
//@Service
public class MyProcess {
	private String name;
	private String part;
	
	public MyProcess() {
		
	}
	
	@Autowired
//	public MyProcess(@Value("총무부") String part) {
	public MyProcess(@Value("#{dataInfo.part}") String part) { // spEl을 사용
		this.part = part;
	}
	
	@Value("30")
	private int age;
	
	public void showDatas() {
		System.out.println("part : " + part);
		System.out.println("age : " + age);
	}
}
