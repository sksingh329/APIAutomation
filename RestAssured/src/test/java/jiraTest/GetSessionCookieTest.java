package jiraTest;

import org.testng.annotations.Test;

public class GetSessionCookieTest extends JiraAPISetup{
    @Test
    public void jiraSessionCookieTest(){
        System.out.println(jiraSessionCookie);
    }
}
