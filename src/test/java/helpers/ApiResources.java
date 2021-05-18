package helpers;

public enum ApiResources {
	
	TeamStandings("/v2/competitions/SA/standings"),
	PlayerStandings("/v2/competitions/SA/scorers");
	String resource;
	
	ApiResources(String resource) {
		this.resource =resource;
	}
	
	
	public String getResourceValue()
	{
		return resource;
	}

}
