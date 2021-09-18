package apps.videogame;

import apps.videogame.config.BaseConfig;
import apps.videogame.config.VideoGamesEndpoint;

import static io.restassured.RestAssured.*;

public class GetVideoGamesList extends BaseConfig {
    public static void main(String[] args) {
        setup();
        //given().log().all().when().get("videogames").then().log().all();
        //get(VideoGamesEndpoint.ALL_VIDEO_GAMES).then().log().all();

        given()
                .pathParam("videoGameId","1").
        when()
                .get(VideoGamesEndpoint.SINGLE_VIDEO_GAME).
        then();
    }
}
