package RestfulBooker;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class CreateBooking {

	public static void main(String[] args) {
		
		//Build Request
		RequestSpecification requestSpecification = RestAssured.given();
		
		requestSpecification = requestSpecification.log().all();
		requestSpecification.baseUri("https://restful-booker.herokuapp.com/");
		requestSpecification.basePath("booking");
		
		requestSpecification.body("{\r\n"
				+ "    \"firstname\" : \"Venu\",\r\n"
				+ "    \"lastname\" : \"Gopal\",\r\n"
				+ "    \"totalprice\" : 111,\r\n"
				+ "    \"depositpaid\" : true,\r\n"
				+ "    \"bookingdates\" : {\r\n"
				+ "        \"checkin\" : \"2023-09-01\",\r\n"
				+ "        \"checkout\" : \"2023-09-26\"\r\n"
				+ "    },\r\n"
				+ "    \"additionalneeds\" : \"Breakfast\"\r\n"
				+ "}");
		requestSpecification.contentType(ContentType.JSON);
		
		// hit request and get response
		
		Response response = requestSpecification.post();
		
		// Validate response
		ValidatableResponse validatableResponse = response.then().log().all();
		
		validatableResponse.statusCode(200);
		
		
		

	}

}
