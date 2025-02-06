package model;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.Objects;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Post {

    private Integer id;
    private String body;
    private Integer commentId;
    private Integer likes;

    public Post() {
    }

    public Post(String newBody, Integer newCommentId, Integer newLikes) {
        this.body = newBody;
        this.commentId = newCommentId;
        this.likes = newLikes;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public Integer getCommentId() {
        return commentId;
    }

    public void setCommentId(Integer commentId) {
        this.commentId = commentId;
    }

    public Integer getLikes() {
        return likes;
    }

    public void setLikes(Integer likes) {
        this.likes = likes;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Post post = (Post) o;
        return Objects.equals(body, post.body) && Objects.equals(commentId, post.commentId) && Objects.equals(likes, post.likes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(body, commentId, likes);
    }
}
