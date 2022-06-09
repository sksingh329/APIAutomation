package apps.location.api;

import apps.location.config.LocationEndpoints;
import apps.location.pojo.GetPlacePOJO;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class GetPlace {
    public void getPlace(String key,String placeId){
        Response response = given().queryParam("key",key).
                queryParam("place_id",placeId).
                when().get(LocationEndpoints.GET_PLACE);
        GetPlacePOJO place = response.getBody().as(GetPlacePOJO.class);
        System.out.println("Name: "+place.getName()+"Phone: "+place.getPhone_number());
    }
}
