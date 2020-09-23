package angular.furnitureapi.user.domain;

import javax.persistence.*;

@Table()
@Entity(name = "user_roles")
public class UserEntityRole {

    public long id;
    public String role;
    public UserEntity user;

    public UserEntityRole() {
    }

    public UserEntityRole(String role) {
        this.role = role;
    }


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Column(name = "role")
    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @ManyToOne()
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }
}
