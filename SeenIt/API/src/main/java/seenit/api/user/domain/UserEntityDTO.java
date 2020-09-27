package seenit.api.user.domain;

import seenit.api.comment.domain.Comment;
import seenit.api.post.domain.Post;

import java.util.Set;

public class UserEntityDTO {

    public String username;
    public String password;
    public Set<Post> posts;
    public Set<Comment> comments;

    public UserEntityDTO() {
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


    public Set<Post> getPosts() {
        return posts;
    }

    public void setPosts(Set<Post> posts) {
        this.posts = posts;
    }

    public Set<Comment> getComments() {
        return comments;
    }

    public void setComments(Set<Comment> comments) {
        this.comments = comments;
    }
}
