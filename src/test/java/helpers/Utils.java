package helpers;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import io.restassured.path.json.JsonPath;

public class Utils {

	Properties prop = new Properties();
	// BASE URI
	public String getBaseUri() throws IOException
	{
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"/src/test/java/helpers/data.properties");
		prop.load(fis);
		return prop.getProperty("baseURI");
	}
	
	// API TOKEN
	public String getApiToken() throws IOException
	{
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"/src/test/java/helpers/data.properties");
		prop.load(fis);
		return prop.getProperty("ApiToken");
		
	}
	// JSON PATH
	public String getJsonPath(String response, String path)
	{
		
		JsonPath js = new JsonPath(response);
		
		return js.get(path);
	}
	
	
}
