package apps.football.config;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class FootballConfig {
    private static RequestSpecification requestSpecification;
    private static ResponseSpecification responseSpecification;

    public static void setup(){
        requestSpecification = new RequestSpecBuilder()
                .setBaseUri("https://api.football-data.org")
                .setBasePath("/v2/")
                .addHeader("X-Auth-Token","b3804e98b01e40a98df3f991e8f5b279")
                .addHeader("X-Response-Control","minified")
                .addHeader("Content-Type","application/json")
                .addHeader("Accept","application/json")
                .addFilter(new RequestLoggingFilter())
                .addFilter(new ResponseLoggingFilter())
                .build();
        RestAssured.requestSpecification = requestSpecification;

        responseSpecification = new ResponseSpecBuilder()
                .expectStatusCode(200)
                .build();

        RestAssured.responseSpecification = responseSpecification;
    }
}
