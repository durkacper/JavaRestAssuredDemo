package crud;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class GetAllPostsTest extends BaseTest {

    @Test
    public void getAllComments() {
        given()
                .spec(reqSpec)
        .when()
                .get()
        .then()
                .spec(respSpec)
                .assertThat().body("body[0]", equalTo("This is some awesome thinking!"))
        .and()
                .assertThat().body("body[1]", equalTo("What terrific math skills you're showing!"));
    }
}
