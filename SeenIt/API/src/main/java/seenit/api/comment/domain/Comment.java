package seenit.api.comment.domain;

import seenit.api.global.BaseEntity;
import seenit.api.post.domain.Post;
import seenit.api.user.domain.UserEntity;

import javax.persistence.*;

@Entity
@Table(name = "comments")
public class Comment extends BaseEntity {

    public String body;
    public Post postId;
    private UserEntity creatorId;

    public Comment() {
    }

    @Column(name = "body")
    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }


    @ManyToOne()
    @JoinColumn(name = "post_id", referencedColumnName = "id")
    public Post getPostId() {
        return postId;
    }

    public void setPostId(Post postId) {
        this.postId = postId;
    }


    @ManyToOne()
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    public UserEntity getCreatorId() {
        return creatorId;
    }

    public void setCreatorId(UserEntity creatorId) {
        this.creatorId = creatorId;
    }
}
