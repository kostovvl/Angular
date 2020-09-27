package seenit.api.user.domain;

import seenit.api.comment.domain.Comment;
import seenit.api.comment.domain.CommentDto;
import seenit.api.post.domain.Post;
import seenit.api.post.domain.PostDto;

import java.util.Set;

public class UserEntityDTO {

    public long id;
    public String username;
    public String password;
    public Set<PostDto> posts;
    public Set<CommentDto> comments;

    public UserEntityDTO() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public Set<PostDto> getPosts() {
        return posts;
    }

    public void setPosts(Set<PostDto> posts) {
        this.posts = posts;
    }

    public Set<CommentDto> getComments() {
        return comments;
    }

    public void setComments(Set<CommentDto> comments) {
        this.comments = comments;
    }
}
