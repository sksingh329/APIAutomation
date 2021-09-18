package apps.library.api;

import apps.library.config.LibraryEndpoint;
import apps.library.payloads.LibraryPayloads;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;

public class LibraryAPI {
    public String addBookAndGetId(String bookName, String isbn, String aisle, String author){
        String addBookPayload = LibraryPayloads.addBook(bookName,isbn,aisle,author);
        String response = given().body(addBookPayload).when().post(LibraryEndpoint.ADD_BOOK).asString();
        JsonPath js = new JsonPath(response);
        String message = js.get("Msg");
        if(message.equals("successfully added")){
            return js.get("ID");
        }
        return null;
    }
}
