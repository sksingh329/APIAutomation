package apps.library.payloads;

public class LibraryPayloads {
    public static String addBook(String bookName, String isbn, String aisle,String author){
        String addBookPayload = "{\n" +
                "\"name\":\""+bookName+"\",\n" +
                "\"isbn\":\""+isbn+"\",\n" +
                "\"aisle\":\""+aisle+"\",\n" +
                "\"author\":\""+author+"\"\n" +
                "}";
        return addBookPayload;
    }
}
