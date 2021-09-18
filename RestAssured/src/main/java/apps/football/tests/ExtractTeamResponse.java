package apps.football.tests;

import apps.football.config.FootballConfig;
import io.restassured.http.Headers;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class ExtractTeamResponse extends FootballConfig {
    public static void main(String[] args) {
        setup();
        Response response = get("teams/57").then().extract().response();
        System.out.println(response.asString());

        String client = response.getHeader("X-Authenticated-Client");
        System.out.println(client);

        Headers headers = response.getHeaders();
        System.out.println(headers.toString());
    }
}
