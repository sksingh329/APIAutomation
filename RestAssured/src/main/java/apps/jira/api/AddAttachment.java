package apps.jira.api;

import apps.jira.config.JiraEndpoints;
import apps.jira.config.JiraParam;
import io.restassured.filter.session.SessionFilter;

import java.io.File;

import static io.restassured.RestAssured.*;

public class AddAttachment {
    public void addAttachment(String issueId,String filePath){
        GetSessionCookie sessionCookie = new GetSessionCookie();
        SessionFilter sessionFilter = sessionCookie.getSessionFilter(JiraParam.JIRA_USER_NAME,JiraParam.JIRA_USER_PASSWORD);

        given().filter(sessionFilter).header("X-Atlassian-Token","no-check").pathParam("issueId",issueId).
                multiPart("file",new File(filePath)).header("Content-Type","multipart/form-data").
                when().post(JiraEndpoints.ADD_ATTACHMENT);
    }
}
