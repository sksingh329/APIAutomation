package apps.videogame.schema;

import apps.videogame.config.BaseConfig;
import apps.videogame.config.VideoGamesEndpoint;

import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

public class ValidateJsonSchemaVideoGame extends BaseConfig {
    public static void main(String[] args) {
        setup();
        given().
                pathParam("videoGameId",2).
                when().
                get(VideoGamesEndpoint.SINGLE_VIDEO_GAME).
                then().
                body(matchesJsonSchemaInClasspath("VideoGameSchema.json"));

    }
}
