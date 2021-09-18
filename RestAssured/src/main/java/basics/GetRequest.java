package basics;


import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class GetRequest {
    public static void main(String[] args) {
        Response response = RestAssured.get("https://demoqa.com/utilities/weather/city/ranchi");
        //System.out.println(response.asString());
        //System.out.println(response.getBody().asString());
        JsonPath jsonPath = response.jsonPath();
        System.out.println(jsonPath.get("Temperature").toString());
    }
}
