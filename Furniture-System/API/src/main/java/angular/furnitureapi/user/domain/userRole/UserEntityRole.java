package angular.furnitureapi.user.domain.userRole;

import angular.furnitureapi.user.domain.userEntity.UserEntity;

import javax.persistence.*;

@Entity
@Table(name = "user_entity_roles")
public class UserEntityRole {

    public long id;
    public String role;
    public UserEntity user;

    public UserEntityRole() {
    }

    @Id()
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
