package seenit.api.user.domain;

import seenit.api.comment.domain.Comment;
import seenit.api.global.BaseEntity;
import seenit.api.post.domain.Post;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "users")
public class UserEntity extends BaseEntity {

    public String username;
    public String password;
    public Set<UserEntityRole> roles;
    public Set<Post> posts;
    public Set<Comment> comments;

    public UserEntity() {
    }

    @Column(name = "username")
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Column(name = "password")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @OneToMany(mappedBy = "user", targetEntity = UserEntityRole.class,
    fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    public Set<UserEntityRole> getRoles() {
        return roles;
    }

    public void setRoles(Set<UserEntityRole> roles) {
        this.roles = roles;
    }

    @OneToMany(mappedBy = "creatorId", targetEntity = Post.class,
    fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    public Set<Post> getPosts() {
        return posts;
    }

    public void setPosts(Set<Post> posts) {
        this.posts = posts;
    }

    @OneToMany(mappedBy = "creatorId", targetEntity = Comment.class,
    fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    public Set<Comment> getComments() {
        return comments;
    }

    public void setComments(Set<Comment> comments) {
        this.comments = comments;
    }
}
