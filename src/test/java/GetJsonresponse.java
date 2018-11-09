import static com.jayway.restassured.RestAssured.given;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.response.Response;

public class GetJsonresponse {

	@BeforeClass
	  public void setBaseUri () {

	    RestAssured.baseURI = "https://maps.googleapis.com";
	  }
	
	@Test
	public void test1() {
		
		Response resp = 
				(Response) given().parameter("query", "Churchgate Station")
				.param ("key", "Xyz")
				.when()
				.get("/maps/api/place/textsearch/json")
				.then()
				.contentType(ContentType.JSON)
				.extract().response();
		
		 System.out.println(resp.asString());
	}
}

