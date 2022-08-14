package ctcorp.iviewAPI.testCase;

import ctcorp.iviewAPI.object.UserBody;
import ctcorp.iviewAPI.object.BaseClassAPI;
import static io.restassured.RestAssured.*;
import org.testng.annotations.Test;
import org.testng.Assert;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class APIcase extends BaseClassAPI {
	
	UserBody usb = new UserBody();
	String postCreate = usb.postUserBody();
	
	@Test(priority=0, description="checking on List users statusCode and email contains", groups="API")
	public void TC01() {
		RestAssured.basePath = userPath;
		
		Response response = given().contentType(ContentType.JSON)
				.queryParam("id", 8)
				.when()
				.get()
				.then()
				.extract()
				.response();
		
		JsonPath jsp = response.jsonPath();
		int statusCode = response.getStatusCode();
		
		String email = jsp.get("data.email");
		
		if(statusCode == 200 && email.equalsIgnoreCase("lindsay.ferguson@reqres.in")) {
			System.out.println("code received: " + statusCode);
			System.out.println("email received: " + email);
			Assert.assertTrue(true);
		} else {
			System.out.println("Test failed");
			System.out.println("code received: " + statusCode);
			System.out.println("email received: " + email);
			Assert.assertTrue(false);
		}
	}
	
	@Test(priority=1, description="POST and check if status code + response body is correct", groups="API")
	public void TC02() {
		RestAssured.basePath = userPath;
		
		Response response = given()
				.accept(ContentType.JSON)
				.contentType(ContentType.JSON)
				.body(postCreate)
				.when()
				.post()
				.then()
				.extract()
				.response();
		
		JsonPath jsp = response.jsonPath();
		String respName = jsp.get("name");
		String respJob = jsp.get("job");
		int statusCode = response.getStatusCode();
		
		if(respName.equals(usb.userName) && respJob.equals(usb.userJob) && statusCode == 201) {
			System.out.println("name received: " + respName);
			System.out.println("job received: " + respJob);
			Assert.assertTrue(true);
		} else {
			System.out.println("Test failed");
			System.out.println("name received: " + respName);
			System.out.println("job received: " + respJob);
			Assert.assertTrue(false);
		}
	}
}
