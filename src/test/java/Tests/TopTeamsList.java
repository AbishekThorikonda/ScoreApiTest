package Tests;

import java.io.IOException;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;
import helpers.ApiResources;
import helpers.Utils;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TopTeamsList extends Utils{
	Response response;
	int points;
	@Test
	public void topTenTeams() throws IOException
	{
		ApiResources resourceApi = ApiResources.valueOf("TeamStandings");
		
		RestAssured.baseURI=getBaseUri();
		RequestSpecification httpRequest = RestAssured.given().header("X-Auth-Token",getApiToken());
		response = httpRequest.request(Method.GET,resourceApi.getResourceValue());
		String responseBody = response.getBody().asString();
		JsonPath js= new JsonPath(responseBody);
		List size= js.get("standings[0].table");
		
		
		for(int i=0;i<=size.size();i++)
		{
			System.out.println((js.get("standings[0].table["+i+"].position")+" "+js.get("standings[0].table["+i+"].team.name")+" "+js.get("standings[0].table["+i+"].points")));
			points =js.get("standings[0].table["+i+"].points");
			Assert.assertTrue(points>=1);
			if(i==9)
			break;
		}
	}
	
}
