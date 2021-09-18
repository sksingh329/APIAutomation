package apps.videogame.config;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class BaseConfig {
    private static RequestSpecification requestSpecification;
    private static ResponseSpecification responseSpecification;

    public static void setup(){
        //RestAssured.proxy("localhost",8866);
        requestSpecification = new RequestSpecBuilder()
                .setBaseUri("http://localhost")
                .setBasePath("app")
                .setPort(8080)
                .addHeader("Content-Type","application/json")
                .addHeader("Accept","application/xml")
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
