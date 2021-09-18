package library;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LibraryAPITest extends LibraryAPISetup{
    @Test (dataProvider = "Book Data")
    public void addBookTest(String bookName, String isbn, String aisle, String author){
        String bookId = library.addBookAndGetId(bookName,isbn,aisle,author);
        System.out.println("Book ID is: "+bookId);
        Assert.assertNotNull(bookId);
    }
    @DataProvider(name = "Book Data")
    public Object[][] getBookData(){
        return new Object[][] {{"Master Selenium","web automation","1228","Subodh Singh"},{"Master Appium","mobile automation","1229","Subodh Singh"}};
    }
}
