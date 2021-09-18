package jiraTest;

import apps.jira.api.GetSessionCookie;
import apps.jira.config.JiraConfig;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

public class JiraAPISetup {
    public String jiraSessionCookie;
    @BeforeClass
    public void setup(){
        JiraConfig.setup();
        GetSessionCookie sessionCookie = new GetSessionCookie();
        jiraSessionCookie = sessionCookie.getSessionCookie("subodhsingh","vitsub");
    }
}
