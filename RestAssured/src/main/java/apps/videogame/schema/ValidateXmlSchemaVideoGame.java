package apps.videogame.schema;

import apps.videogame.config.BaseConfig;
import apps.videogame.config.VideoGamesEndpoint;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.matchesXsdInClasspath;

public class ValidateXmlSchemaVideoGame extends BaseConfig {
    public static void main(String[] args) {
        setup();
        given().
                pathParam("videoGameId",2).
                header("Content-Type","application/xml").
                header("Accept","application/xml").
        when().
                get(VideoGamesEndpoint.SINGLE_VIDEO_GAME).
        then().
            body(matchesXsdInClasspath("VideoGameSchema.xsd"));

    }
}
