package apps.jira.config;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import java.util.regex.Matcher;

public class JiraConfig {
    private static RequestSpecification requestSpecification;
    private static ResponseSpecification responseSpecification;

    public static void setup(){
        requestSpecification = new RequestSpecBuilder()
                .setBaseUri("http://34.125.232.120:8080")
                .setBasePath("/rest/")
                .addHeader("Content-Type","application/json")
                .addHeader("Accept","application/json")
                .addFilter(new RequestLoggingFilter())
                .addFilter(new ResponseLoggingFilter())
                .build();
        RestAssured.requestSpecification = requestSpecification;

        responseSpecification = new ResponseSpecBuilder()
                .build();

        RestAssured.responseSpecification = responseSpecification;
    }
}
