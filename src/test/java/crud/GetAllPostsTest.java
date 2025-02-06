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
                .assertThat().body("body[1]", equalTo("What terrific math skills you're showing!"))
        .and()
                .assertThat().body("body[2]", equalTo("You are an amazing writer!"))
        .and()
                .assertThat().body("body[3]", equalTo("Wow! You have improved so much!"))
        .and()
                .assertThat().body("body[4]", equalTo("Nice idea!"));
    }
}
