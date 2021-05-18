package Tests;
import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;
import helpers.ApiResources;
import helpers.Utils;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TopPlayersList extends Utils {

	Response response;
	int numberOfGoals;
	@Test
	public void topTenPlayers() throws IOException
	{
		LinkedHashMap<String,Integer>playersList = new LinkedHashMap<String,Integer>();
		ApiResources resourceApi = ApiResources.valueOf("PlayerStandings");
		RestAssured.baseURI = getBaseUri();
	    RequestSpecification httpRequest = RestAssured.given().header("X-Auth-Token",getApiToken());
	    response = httpRequest.request(Method.GET,resourceApi.getResourceValue());
	    String responseBody= response.getBody().asString();
	    JsonPath js = new JsonPath(responseBody);
	    List size= js.get("scorers");
	    for(int i=0;i<=size.size()-1;i++)
	    {
	    	playersList.put(js.get("scorers["+i+"].player.name"),js.get("scorers["+i+"].numberOfGoals"));
	    	numberOfGoals=js.get("scorers["+i+"].numberOfGoals");
	    	Assert.assertTrue(numberOfGoals>1);
	    }
	  
	   for(Map.Entry<String, Integer>m :playersList.entrySet())
	   {
		   System.out.println(m.getKey() +" "+ m.getValue());
	   }
	}
}
