package apps.jira.payloads;

public class JiraPayloads {
    public static String getSessionCookiePayloads(String userName, String userPassword){
        return "{ \n" +
                "    \"username\": \""+userName+"\",\n" +
                "    \"password\": \""+userPassword+"\"\n" +
                "}";
    }
    public static String createIssuePayload(String key,String summary,String description){
        return "{\n" +
                "    \"fields\": {\n" +
                "        \"project\": {\n" +
                "            \"key\": \""+key+"\"\n" +
                "        },\n" +
                "        \"summary\": \""+summary+"\",\n" +
                "        \"description\": \""+description+"\",\n" +
                "        \"issuetype\": {\n" +
                "            \"name\": \"Bug\"\n" +
                "        }\n" +
                "    }\n" +
                "}";
    }
    public static String addCommentPayload(String comment){
        return "{\n" +
                "    \"body\": \""+comment+"\",\n" +
                "    \"visibility\": {\n" +
                "        \"type\": \"role\",\n" +
                "        \"value\": \"Administrators\"\n" +
                "    }\n" +
                "}";
    }
}
