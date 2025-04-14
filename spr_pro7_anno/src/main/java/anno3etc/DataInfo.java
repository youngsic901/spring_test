package anno3etc;

import org.springframework.stereotype.Component;

@Component
public class DataInfo {
	private String name = "신기해";
	private String part = "총무부";
	public String job = "programming";
	
	public String getName() {
		return name;
	}
	
	public String getPart() {
		return part;
	}
}
