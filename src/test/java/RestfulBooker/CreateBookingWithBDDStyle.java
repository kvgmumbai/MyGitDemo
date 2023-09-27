package RestfulBooker;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class CreateBookingWithBDDStyle {

	public static void main(String[] args) {
		
		RestAssured 
			.given()
				.log()
				.all()
				.baseUri("https://restful-booker.herokuapp.com/")
				.basePath("booking")
				.body("{\r\n"
						+ "    \"firstname\" : \"Jim\",\r\n"
						+ "    \"lastname\" : \"Test\",\r\n"
						+ "    \"totalprice\" : 111,\r\n"
						+ "    \"depositpaid\" : true,\r\n"
						+ "    \"bookingdates\" : {\r\n"
						+ "        \"checkin\" : \"2023-09-01\",\r\n"
						+ "        \"checkout\" : \"2023-09-26\"\r\n"
						+ "    },\r\n"
						+ "    \"additionalneeds\" : \"Breakfast\"\r\n"
						+ "}")
				.contentType(ContentType.JSON)
			.when()
				.post()
			.then().log().all()
				.statusCode(200);

	}

}
