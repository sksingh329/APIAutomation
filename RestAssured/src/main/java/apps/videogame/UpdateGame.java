package apps.videogame;

import apps.videogame.config.BaseConfig;

import static io.restassured.RestAssured.*;

public class UpdateGame extends BaseConfig {
    public static void main(String[] args) {
        setup();
        String updateGameJson = "{\n" +
                "  \"id\": 2,\n" +
                "  \"name\": \"New Game\",\n" +
                "  \"releaseDate\": \"2021-08-22T06:34:57.576Z\",\n" +
                "  \"reviewScore\": 10\n" +
                "}";
        given()
                .body(updateGameJson).
        when()
                .put("videogames/2").
        then();

    }
}
