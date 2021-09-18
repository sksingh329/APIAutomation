package apps.videogame;

import apps.videogame.config.BaseConfig;
import apps.videogame.config.VideoGamesEndpoint;
import apps.videogame.pojo.NewVideoGame;

import static io.restassured.RestAssured.*;

public class AddNewGame extends BaseConfig {
    public static void main(String[] args) {
        setup();
        String addNewGamePayloadJson = "{\n" +
                "  \"id\": 12,\n" +
                "  \"name\": \"New Game\",\n" +
                "  \"releaseDate\": \"2021-08-22T05:48:49.436Z\",\n" +
                "  \"reviewScore\": 10,\n" +
                "  \"category\": \"Shooting\",\n" +
                "  \"rating\": \"5\"\n" +
                "}";
        String addNewGamePayloadXml = "<videoGame category=\"Driving\" rating=\"Universal\">\n" +
                "    <id>14</id>\n" +
                "    <name>Gran Turismo 3</name>\n" +
                "    <releaseDate>2001-03-10T00:00:00+05:30</releaseDate>\n" +
                "    <reviewScore>91</reviewScore>\n" +
                "  </videoGame>";

        NewVideoGame videoGame = new NewVideoGame(14,"Latest Games","2021-08-24T00:00:00+05:30",5,"Outdoor","5");
        given()
                .body(videoGame).
        when()
                .post(VideoGamesEndpoint.ALL_VIDEO_GAMES).
        then();
    }
}
