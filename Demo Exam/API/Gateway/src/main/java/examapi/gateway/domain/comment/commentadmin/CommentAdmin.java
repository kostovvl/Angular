package examapi.gateway.domain.comment.commentadmin;

public class CommentAdmin {

    private  long id;
    private String content;

    public CommentAdmin() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
