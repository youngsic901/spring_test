package anno2;

import org.springframework.stereotype.Component;

@Component("abc2")
public class Abc2 {
	private int nai;
	
	public void setNai(int nai) {
		this.nai = nai;
	}
	
	public int getNai() {
		return nai;
	}
}
