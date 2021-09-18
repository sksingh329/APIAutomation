package apps.videogame;

import apps.videogame.config.BaseConfig;
import apps.videogame.config.VideoGamesEndpoint;
import apps.videogame.pojo.NewVideoGame;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class ConvertResponseToPOJO extends BaseConfig {
    public static void main(String[] args) {
        setup();
        Response  response = given().
                pathParam("videoGameId",2).
                when().
                get(VideoGamesEndpoint.SINGLE_VIDEO_GAME);

        NewVideoGame videoGame = response.getBody().as(NewVideoGame.class);
        System.out.println(videoGame.toString());
    }
}
