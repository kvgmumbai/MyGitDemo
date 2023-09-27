import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class Test03_PUT {
	
	
	@Test
	public void test_1_put() {
		
		
		// converting key value pairs into JSON format
		JSONObject request = new JSONObject();
		request.put("name", "SriCharan");
		request.put("job", "Student");
		
		System.out.println("JSON formt: " + request);
		System.out.println(request.toJSONString());
		
		//BDD style
		given().
			header("Content-Type", "application/json").
			contentType(ContentType.JSON).
			accept(ContentType.JSON).body(request.toString()).
		when().put("https://reqres.in/api/users/2").
		then().
			statusCode(200).
			log().all();
	}
	
	

}
