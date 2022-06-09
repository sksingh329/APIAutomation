package apps.jira.api;

import apps.jira.config.JiraEndpoints;
import apps.jira.config.JiraParam;
import apps.jira.payloads.JiraPayloads;
import io.restassured.filter.session.SessionFilter;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class CreateIssue {
    public String createIssue(String key,String summary,String description){
        GetSessionCookie sessionCookie = new GetSessionCookie();
        String jiraSessionCookie = sessionCookie.getSessionCookie(JiraParam.JIRA_USER_NAME,JiraParam.JIRA_USER_PASSWORD);

        String response = given().header("cookie","JSESSIONID="+jiraSessionCookie)
                .body(JiraPayloads.createIssuePayload(key,summary,description)).
        when().post(JiraEndpoints.CREATE_ISSUE).asString();

        JsonPath jsonPath = new JsonPath(response);
        String issueId = jsonPath.getString("id");
        return issueId;
    }
    public String createIssueUsingSessionFilter(String key,String summary,String description){
        GetSessionCookie sessionCookie = new GetSessionCookie();
        SessionFilter sessionFilter = sessionCookie.getSessionFilter(JiraParam.JIRA_USER_NAME,JiraParam.JIRA_USER_PASSWORD);

        String response = given().filter(sessionFilter).
                            body(JiraPayloads.createIssuePayload(key,summary,description)).
                          when().post(JiraEndpoints.CREATE_ISSUE).asString();

        JsonPath jsonPath = new JsonPath(response);
        String issueId = jsonPath.getString("id");
        return issueId;
    }
}
