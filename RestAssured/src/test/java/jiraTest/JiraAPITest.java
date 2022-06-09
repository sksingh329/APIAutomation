package jiraTest;

import apps.jira.api.AddAttachment;
import apps.jira.api.AddComment;
import apps.jira.api.CreateIssue;
import apps.jira.api.GetIssue;
import org.testng.annotations.Test;

public class JiraAPITest extends JiraAPISetup{
    @Test
    public void createIssueTest(){
        CreateIssue issue = new CreateIssue();
        String issueId = issue.createIssue("AUT","Issue created from Rest Assured","Create bug");
        System.out.println(issueId);
    }
    @Test
    public void createIssueTestUsingSessionFilter(){
        CreateIssue issue = new CreateIssue();
        String issueId = issue.createIssueUsingSessionFilter("AUT","Issue created from Rest Assured","Create bug");
        System.out.println(issueId);
    }
    @Test
    public void addCommentTest(){
        CreateIssue issue = new CreateIssue();
        String issueId = issue.createIssueUsingSessionFilter("AUT","Issue created from Rest Assured","Create bug");
        AddComment addComment = new AddComment();
        System.out.println(addComment.addComment(issueId,"Comment added from Rest Assured"));
    }

    @Test
    public void addAttachmentTest(){
        CreateIssue issue = new CreateIssue();
        String issueId = issue.createIssueUsingSessionFilter("AUT","Issue created from Rest Assured","Create bug");
        AddAttachment addAttachment = new AddAttachment();
        addAttachment.addAttachment(issueId,"/Users/subodhsingh/Desktop/code/automation/APIAutomation/RestAssured/src/main/resources/attachment/NotAbleToLogin.txt");
    }
    @Test
    public void getIssue() {
        CreateIssue issue = new CreateIssue();
        String issueId = issue.createIssueUsingSessionFilter("AUT", "Issue created from Rest Assured", "Create bug");
        GetIssue getIssue = new GetIssue();
        String issueDetail = getIssue.getIssue(issueId,"issuetype");
        System.out.println(issueDetail);
    }
    @Test
    public void validateCommentAdded(){
        CreateIssue issue = new CreateIssue();
        String issueId = issue.createIssueUsingSessionFilter("AUT","Issue created from Rest Assured","Create bug");
        AddComment addComment = new AddComment();
        addComment.addComment(issueId,"New: Comment added from Rest Assured");
        GetIssue getIssue = new GetIssue();
        System.out.println(getIssue.getCommentInIssue(issueId));
    }
}
