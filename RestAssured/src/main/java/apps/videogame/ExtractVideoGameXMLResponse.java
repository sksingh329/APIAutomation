package apps.videogame;

import apps.videogame.config.BaseConfig;
import apps.videogame.config.VideoGamesEndpoint;
import io.restassured.path.xml.XmlPath;
import io.restassured.path.xml.element.Node;
import io.restassured.response.Response;

import java.util.List;

import static io.restassured.RestAssured.*;

public class ExtractVideoGameXMLResponse extends BaseConfig {
    public static void main(String[] args) {
        setup();
        Response response = get(VideoGamesEndpoint.ALL_VIDEO_GAMES);
        String name = response.path("videoGames.videoGame.name[0]");
        //System.out.println(name);
        String category = response.path("videoGames.videoGame[0].@category");
        //System.out.println(category);
        String responseAsString = get(VideoGamesEndpoint.ALL_VIDEO_GAMES).asString();
        List<Node> allResults = XmlPath.from(responseAsString).get("videoGames.videoGame.findAll { element -> return element }");
        //System.out.println(allResults.get(2).get("name").toString());

        List<Node> allShooter = XmlPath.from(responseAsString).get("videoGames.videoGame.findAll { videoGame -> def category = videoGame.@category; category == 'Shooter' }");

        System.out.println(allShooter.get(0).get("name").toString());
    }
}
