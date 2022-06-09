package apps.jira.config;

public interface JiraEndpoints {
    String SESSION_COOKIE_AUTH = "auth/1/session";
    String CREATE_ISSUE = "/api/2/issue";
    String ADD_COMMENT = "/api/2/issue/{issueId}/comment";
    String ADD_ATTACHMENT = "/api/2/issue/{issueId}/attachments";
    String GET_ISSUE = "/api/2/issue/{issueId}";

}
