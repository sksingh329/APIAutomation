package library;

import apps.library.api.LibraryAPI;
import apps.library.config.LibraryConfig;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

public class LibraryAPISetup {
    public LibraryAPI library;
    @BeforeClass
    public void setup(){
        LibraryConfig.setup();
        library = new LibraryAPI();
    }
}
