package ctcorp.iviewAPI.object;

import org.apache.commons.lang3.RandomStringUtils;

public class UserBody {
	
	public String userName = randomString();
	public String userJob = "job " + randomString();
	
	public String randomString() {
		String rdmString = RandomStringUtils.randomAlphanumeric(8);
		return rdmString;
	}
	
	public String randomNumber() {
		String rdmNum = RandomStringUtils.randomNumeric(3);
		return rdmNum;
	}
	
	public String postUserBody() {
		String userBody = "{\n" + 
				"\"name\": \"" + userName + "\",\n" + 
				"\"job\": \"" + userJob + "\"\n" + 
				"}";
		return userBody;
	}

}
