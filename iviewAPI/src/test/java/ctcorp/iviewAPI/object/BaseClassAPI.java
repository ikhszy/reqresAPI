package ctcorp.iviewAPI.object;

import org.testng.annotations.BeforeClass;
import ctcorp.iviewAPI.utilities.ReadConfig;
import io.restassured.RestAssured;

public class BaseClassAPI {

ReadConfig reader = new ReadConfig();
	
	public String baseURI = reader.getBaseURI();
	public String userPath = reader.getUserPath();
	
	@BeforeClass
	public void setup() {
		RestAssured.baseURI = baseURI;
	}
}
