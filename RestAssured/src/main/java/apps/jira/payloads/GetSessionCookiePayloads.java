package apps.jira.payloads;

public class GetSessionCookiePayloads {
    public static String getSessionCookiePayloads(String userName, String userPassword){
        return "{ \n" +
                "    \"username\": \""+userName+"\",\n" +
                "    \"password\": \""+userPassword+"\"\n" +
                "}";
    }
}
