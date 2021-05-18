# ScoreApiTest

API USED - https://www.football-data.org

Project built using Maven, RestAssured, TestNG, Java

1) src/test/java/Tests - contains TopPlayersList and TopTeamsList classes
2) src/test/java/helpers - contains helper classes Utils,ApiResources and properties file.

Approach:

Using the common baseUri: https://www.football-data.org and :

1) using path parameters "/v2/competitions/SA/scorers" for Player Scores and "/v2/competitions/SA/standings" to extract Team Standings of League "Serie A"  2019.
2) Response is stored and using JsonPath extracted the required results of Top ten players(Scorers) and Top ten teams according to points table. Storing them in Collection and printing them.
3) Assertions done for player scores and teams points.
