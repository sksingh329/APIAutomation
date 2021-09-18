package apps.football.tests;

import apps.football.config.FootballConfig;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.*;

public class ExtractTeamDataFromResponse extends FootballConfig {
    public static void main(String[] args) {
        setup();
        //Response response = get("competitions/2021/teams");
        //JsonPath jsonPath = new JsonPath(response.asString());
        //Map<String,?> allTeamDataForSingleTeam = jsonPath.getMap("teams.find { it.name == 'Manchester City FC' }");
        //Map<String,?> allTeamDataForSingleTeam = response.path("teams.find { it.name == 'Manchester City FC' }");
        //System.out.println(allTeamDataForSingleTeam);

        Response response = get("teams/66");
        List<String> midFieldersNames = response.path("squad.findAll { it.position == 'Midfielder' }.name");
        System.out.println(midFieldersNames);
        int sumOfIds = response.path("squad.collect { it.id }.sum()");
        System.out.println(sumOfIds);

    }
}
