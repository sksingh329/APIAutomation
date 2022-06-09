package jiraTest;


import apps.jira.config.JiraConfig;
import org.testng.annotations.BeforeClass;

public class JiraAPISetup {
    @BeforeClass
    public void setup(){
        JiraConfig.setup();
    }
}
