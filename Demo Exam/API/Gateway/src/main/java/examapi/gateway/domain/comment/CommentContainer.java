package examapi.gateway.domain.comment;

import java.util.List;

public class CommentContainer {

    public CommentContainer() {}

    public CommentContainer(List<Comment> comments) {
        this.all = comments;
    }

    public List<Comment> all;

    public List<Comment> getAll() {
        return all;
    }

    public void setAll(List<Comment> all) {
        this.all = all;
    }
}
