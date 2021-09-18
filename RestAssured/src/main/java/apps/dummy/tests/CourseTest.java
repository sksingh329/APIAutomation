package apps.dummy.tests;

import apps.dummy.dummyReponse.DummyPayload;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;

public class CourseTest {
    public static void main(String[] args) {
        JsonPath jsonPath = new JsonPath(DummyPayload.DummyCourseResponse());
        int courseCount = jsonPath.getInt("courses.size()");

        for(int i = 0; i< courseCount; i++){
            String courseName = jsonPath.get("courses["+i+"].title");
            int coursePrice =jsonPath.get("courses["+i+"].price");
            System.out.println("Course name:  "+courseName+", Course Price: "+coursePrice);
            if(courseName.equals("RPA"))
                System.out.println("No of copies sold: "+jsonPath.getInt("courses["+i+"].copies"));
        }
    }
}
