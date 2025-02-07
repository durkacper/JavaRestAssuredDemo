package crud;

import model.Post;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class ReplacePostTest extends BaseTest {

    @Test
    public void replacePost() {
        Post post = new Post("New Post Body", 100, 200);

        Post newPost = given()
                .spec(reqSpec)
                .pathParam("postId", 2)
                .body(post)
                .when()
                .put("{postId}")
                .then()
                .spec(respSpec)
                .extract().body().as(Post.class);

        Assert.assertEquals(post, newPost);
    }
}
