package apps.jira.api;

import apps.jira.config.JiraConfig;
import apps.jira.config.JiraEndpoints;
import apps.jira.payloads.GetSessionCookiePayloads;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;
public class GetSessionCookie extends JiraConfig {
    public String getSessionCookie(String userName, String userPassword){
        String response = given().body(GetSessionCookiePayloads.getSessionCookiePayloads(userName,userPassword))
                .when().post(JiraEndpoints.SESSION_COOKIE_AUTH).asString();
        JsonPath jsonPath = new JsonPath(response);
        return jsonPath.get("session.value");
    }
}
