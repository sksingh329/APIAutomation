package apps.football.tests;

import apps.football.config.FootballConfig;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.equalTo;

public class ValidateTeamResponse extends FootballConfig {
    public static void main(String[] args) {
        setup();
        given()
        .when()
            .get("competitions/2021/teams").
        then()
            .body("teams.name[0]",equalTo("Arsenal FC"));
    }
}
