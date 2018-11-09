import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.jayway.restassured.RestAssured.*;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.response.Response;

public class GetStatusCodeTest {

	@BeforeClass
	public void SetBaseUrl()
	{
		RestAssured.baseURI= "https://maps.googleapis.com";
	}
	
	@Test
	public void testStatusCode() {
		Response resp = 
		(Response) given().parameter("query", "restaurants in mumbai")
		.parameter("key", "xyz")
		
		.when().get("/maps/api/place/textsearch/json");
		
		Assert.assertEquals (resp.statusCode (), 200);
		
	
	}
	
	
	@Test
	public void testStatusCodeRestAssured () {

	given ().param ("query", "restaurants in mumbai")
	        .param ("key", "Xyz")
	        .when()
	        .get ("/maps/api/place/textsearch/json")
	        .then ()
	        .assertThat ().statusCode (200);

	}
}
