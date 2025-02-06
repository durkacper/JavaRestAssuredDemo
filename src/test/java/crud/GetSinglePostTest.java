package crud;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class GetSinglePostTest extends BaseTest {

    @Test
    public void getSingleComment() {
        given()
                .spec(reqSpec)
                .pathParam("id", 1)
        .when()
                .get("{id}")
        .then()
                .spec(respSpec)
                .assertThat().body("body", equalTo("This is some awesome thinking!"))
                .assertThat().body("commentId", equalTo(242));
    }
}
