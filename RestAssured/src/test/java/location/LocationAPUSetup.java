package location;

import apps.location.config.LocationConfig;
import org.testng.annotations.BeforeClass;

public class LocationAPUSetup {
    @BeforeClass
    public void setup(){
        LocationConfig.setup();
    }
}
