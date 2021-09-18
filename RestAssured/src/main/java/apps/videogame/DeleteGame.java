package apps.videogame;

import apps.videogame.config.BaseConfig;

import static io.restassured.RestAssured.*;

public class DeleteGame extends BaseConfig {
    public static void main(String[] args) {
        setup();
        delete("videogames/14");
    }
}
