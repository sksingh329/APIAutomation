package apps.library.config;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class LibraryConfig {
    private static RequestSpecification requestSpecification;
    private static ResponseSpecification responseSpecification;

    public static void setup(){
        requestSpecification = new RequestSpecBuilder()
                .setBaseUri("http://216.10.245.166")
                .setBasePath("/Library/")
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
