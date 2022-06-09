package location;

import apps.location.api.GetPlace;
import org.testng.annotations.Test;

public class LocationTest extends LocationAPUSetup{
    @Test
    public void getPlaceTest(){
        GetPlace place = new GetPlace();
        place.getPlace("qaclick123","b92a1ed4c8de2e89856800f0d863a85a");
    }
}
