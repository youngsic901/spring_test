package anno2;

import org.springframework.stereotype.Component;

@Component("abc1")
public class Abc1 {
	private String irum;
	
	public void setIrum(String irum) {
		this.irum = irum;
	}
	
	public String getIrum() {
		return irum;
	}
}
