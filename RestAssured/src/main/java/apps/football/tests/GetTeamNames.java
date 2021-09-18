package apps.football.tests;

import apps.football.config.FootballConfig;
import io.restassured.response.Response;

import java.util.List;

import static io.restassured.RestAssured.*;

public class GetTeamNames extends FootballConfig {
    public static void main(String[] args) {
        setup();
        String firstTeamName = get("competitions/2021/teams").jsonPath().getString("teams.name[0]");
        //System.out.println(firstTeamName);
        Response response = get("competitions/2021/teams").then().extract().response();
        List<String> allTeams = response.path("teams.name");
        for(String name : allTeams)
            System.out.println(name);
    }
}
