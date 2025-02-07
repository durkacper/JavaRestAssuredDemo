package crud;

import model.Post;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class UpdatePostTest extends BaseTest {

    @Test
    public void updatePostBody() {
        Post post = new Post();
        post.setBody("Updated Post Body");

        Post updatedPost = given()
                .spec(reqSpec)
                .pathParam("postId", 1)
                .body(post)
        .when()
                .patch("{postId}")
        .then()
                .spec(respSpec)
                .extract().body().as(Post.class);

        // Verify that the body is updated and other fields remain the same
        Assert.assertEquals(updatedPost.getBody(), "Updated Post Body");
        Assert.assertEquals(updatedPost.getCommentId(), 242);
        Assert.assertEquals(updatedPost.getLikes(), 3);
    }
}
