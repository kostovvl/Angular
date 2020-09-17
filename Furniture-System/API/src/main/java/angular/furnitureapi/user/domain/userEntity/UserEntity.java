package angular.furnitureapi.user.domain.userEntity;

import angular.furnitureapi.furniture.domain.Furniture;
import angular.furnitureapi.user.domain.userRole.UserEntityRole;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "users")
public class UserEntity {

    public long id;
    public String username;
    public String email;
    public String password;
    public Set<UserEntityRole> roles;
    public List<Furniture> furniture;

    public UserEntity() {
    }

    @Id()
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Column(name = "username")
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Column(name = "email")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    @OneToMany(mappedBy = "creator", targetEntity = Furniture.class,
    fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    public List<Furniture> getFurniture() {
        return furniture;
    }

    public void setFurniture(List<Furniture> furniture) {
        this.furniture = furniture;
    }
}
