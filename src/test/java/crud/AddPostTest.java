package crud;

import io.restassured.http.ContentType;
import model.Post;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class AddPostTest extends BaseTest {

    @Test
    public void addPost() {

        Post post = new Post("Added by API", 999, 0);

        Post createdPost = given()
                                .spec(reqSpec)
                                .body(post)
                        .when()
                                .post()
                        .then()
                                .statusCode(201)
                                .contentType(ContentType.JSON)
                                .extract().body().as(Post.class);

        Assert.assertEquals(post, createdPost);
   }
}
