import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import java.io.File;

import static io.restassured.RestAssured.given;


public class AddPostTest {

    @Test
    public void addPostFromJson() {
        RestAssured.baseURI = "http://localhost:3000";
        File file = new File("src/test/resources/post.json");

        given()
                .contentType(ContentType.JSON).body(file)
        .when()
                .post("/posts")
        .then()
                .log().all();
    }
}
