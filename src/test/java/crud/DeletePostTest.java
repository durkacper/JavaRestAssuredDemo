package crud;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class DeletePostTest extends BaseTest {

    @Test
    public void deletePost() {
        given()
                .spec(reqSpec)
                .pathParam("postId", 6)
        .when()
                .delete("{postId}")
        .then()
                .spec(respSpec);
    }
}
