package apps.football.tests;

import apps.football.config.FootballConfig;

import static io.restassured.RestAssured.*;

public class GetTeams extends FootballConfig {
    public static void main(String[] args) {
        setup();
        given()
                .queryParam("areas",2255).
        when()
                .get("areas").
        then();
    }
}
