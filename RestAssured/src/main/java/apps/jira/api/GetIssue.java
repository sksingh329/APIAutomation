package apps.jira.api;

import apps.jira.config.JiraEndpoints;
import apps.jira.config.JiraParam;
import io.restassured.filter.session.SessionFilter;
import io.restassured.path.json.JsonPath;

import java.util.ArrayList;

import static io.restassured.RestAssured.*;

public class GetIssue {
    public String getIssue(String issueId, String filter){
        GetSessionCookie sessionCookie = new GetSessionCookie();
        SessionFilter sessionFilter = sessionCookie.getSessionFilter(JiraParam.JIRA_USER_NAME,JiraParam.JIRA_USER_PASSWORD);

        String response = given().filter(sessionFilter).pathParam("issueId",issueId).
                            queryParam("fields",filter).when().get(JiraEndpoints.GET_ISSUE).asString();
        
        return response;
    }
    public String getCommentInIssue(String issueId){
        GetSessionCookie sessionCookie = new GetSessionCookie();
        SessionFilter sessionFilter = sessionCookie.getSessionFilter(JiraParam.JIRA_USER_NAME,JiraParam.JIRA_USER_PASSWORD);

        String response = given().filter(sessionFilter).pathParam("issueId",issueId).
                queryParam("fields","comment").when().get(JiraEndpoints.GET_ISSUE).asString();

        JsonPath comment = new JsonPath(response);
        ArrayList<String> body = comment.get("fields.comment.comments.body");
        return body.get(0);
    }
}
