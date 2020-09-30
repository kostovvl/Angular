package seenit.api.post.domain;

import seenit.api.comment.domain.Comment;
import seenit.api.global.BaseEntity;
import seenit.api.user.domain.UserEntity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "posts")
public class Post extends BaseEntity {

    public String title;
    public String body;
    public String imageUrl;
    public String author;
    public UserEntity creatorId;
    public Set<Comment> comments;

    public Post() {
    }

    @Column(name = "title")
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Column(name = "body", columnDefinition = "text")
    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    @Column(name = "image_Url")
    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    @Column(name = "author")
    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @ManyToOne()
    @JoinColumn(name = "creator_id", referencedColumnName = "id")
    public UserEntity getCreatorId() {
        return creatorId;
    }

    public void setCreatorId(UserEntity creatorId) {
        this.creatorId = creatorId;
    }

    @OneToMany(mappedBy = "postId", targetEntity = Comment.class,
    fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    public Set<Comment> getComments() {
        return comments;
    }

    public void setComments(Set<Comment> comments) {
        this.comments = comments;
    }
}
