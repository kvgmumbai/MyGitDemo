import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

//import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.json.simple.JSONObject;


public class Example_Test_Local_API {
	
	//@Test
	public void test_GET() {
		
		baseURI = "http://localhost:3000/";
		
		given().
			param("name", "DevOps").
			get("/subjects").
		then().
			statusCode(200).
			log().all();
		
	}
	
	//@Test
	public void test_POST() {
		
		JSONObject request = new JSONObject();
		
		request.put("firstName", "Tom");
		request.put("lastName", "Cuper");
		request.put("subjectId", "1");	
		baseURI = "http://localhost:3000/";
		
		given().
			contentType(ContentType.JSON).
			accept(ContentType.JSON).
			header("Content-Type", "application/json").
			body(request.toJSONString()).
		when().
			post("/users").
		then().statusCode(201).log().all();		
	}
	
	//@Test
	public void test_PATCH() {
		
		JSONObject request = new JSONObject();
		
		request.put("firstName", "Tom1");
			
		baseURI = "http://localhost:3000/";
		
		given().
			contentType(ContentType.JSON).
			accept(ContentType.JSON).
			header("Content-Type", "application/json").
			body(request.toJSONString()).
		when().
			patch("/users/5").
		then().statusCode(200).
		log().all();		
	}
	
	//@Test
	public void test_PUT() {
			
			JSONObject request = new JSONObject();
			
			request.put("firstName", "Rama");
			request.put("lastName", "Ayodhya");
			request.put("subjectId", "1");
				
			baseURI = "http://localhost:3000/";
			
			given().
				contentType(ContentType.JSON).
				accept(ContentType.JSON).
				header("Content-Type", "application/json").
				body(request.toJSONString()).
			when().
				put("/users/5").
			then().statusCode(200).
			log().all();		
		}
	
	@Test
	public void test_DELETE() {
			
			JSONObject request = new JSONObject();
			
			baseURI = "http://localhost:3000/";
			
			given().
				contentType(ContentType.JSON).
				accept(ContentType.JSON).
				header("Content-Type", "application/json").
				body(request.toJSONString()).
			when().
				delete("/users/7").
			then().statusCode(200).
			log().all();		
		}

}
