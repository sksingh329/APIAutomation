package apps.jira.api;

import apps.jira.config.JiraEndpoints;
import apps.jira.payloads.JiraPayloads;
import io.restassured.filter.session.SessionFilter;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;
public class GetSessionCookie {
    public String getSessionCookie(String userName, String userPassword){
        String response = given().body(JiraPayloads.getSessionCookiePayloads(userName,userPassword))
                .when().post(JiraEndpoints.SESSION_COOKIE_AUTH).asString();
        JsonPath jsonPath = new JsonPath(response);
        return jsonPath.get("session.value");
    }
    public SessionFilter getSessionFilter(String userName, String userPassword){
        SessionFilter sessionFilter = new SessionFilter();
        String response = given().filter(sessionFilter).body(JiraPayloads.getSessionCookiePayloads(userName,userPassword))
                .when().post(JiraEndpoints.SESSION_COOKIE_AUTH).asString();
        JsonPath jsonPath = new JsonPath(response);
        return sessionFilter;
    }
}
