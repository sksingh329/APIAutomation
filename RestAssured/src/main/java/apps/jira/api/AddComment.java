package apps.jira.api;

import apps.jira.config.JiraEndpoints;
import apps.jira.config.JiraParam;
import apps.jira.payloads.JiraPayloads;
import io.restassured.filter.session.SessionFilter;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;

public class AddComment {
    public String addComment(String issueId,String comment){
        GetSessionCookie sessionCookie = new GetSessionCookie();
        SessionFilter sessionFilter = sessionCookie.getSessionFilter(JiraParam.JIRA_USER_NAME,JiraParam.JIRA_USER_PASSWORD);

        String response = given().filter(sessionFilter).pathParam("issueId",issueId).
                body(JiraPayloads.addCommentPayload(comment)).
        when().post(JiraEndpoints.ADD_COMMENT).asString();

        JsonPath jsonPath = new JsonPath(response);
        return jsonPath.get("id");
    }
}
