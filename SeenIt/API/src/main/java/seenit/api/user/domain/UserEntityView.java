package seenit.api.user.domain;

public class UserEntityView {

    public long id;
    public String username;

    public UserEntityView() {
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
}
