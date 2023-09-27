import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class Test02_POST {
	
	@Test
	public void test_1_post() {
		//Hash Map Object creation but response body will be not in JSON format i.e. {name=Venu, job=Consultant}
		Map <String, Object> map = new HashMap<String, Object>();
		
		map.put("name", "Venu");
		map.put("job", "Consultant I");
		System.out.println(map);
			
	}
	
	@Test
	public void test_2_post() {
		// example of JSON message - {"name"="Venu", job=Consultant}
		Map <String, Object> map1 = new HashMap<String, Object>();
		
		map1.put("\"name\"", "\"Venugopal\"");
		map1.put("job", "Consultant II");
		System.out.println(map1);
		
	}
	
	@Test
	public void test_3_post() {
		
		
		// converting key value pairs into JSON format
		JSONObject request = new JSONObject();
		request.put("name", "Venu");
		request.put("job", "Consultant");
		
		System.out.println("JSON formt: " + request);
		System.out.println(request.toJSONString());
		
		//BDD style
		given().
			header("Content-Type", "application/json").
			contentType(ContentType.JSON).
			accept(ContentType.JSON).body(request.toString()).
		when().post("https://reqres.in/api/users").
		then().statusCode(201);
	}
	
	

}
