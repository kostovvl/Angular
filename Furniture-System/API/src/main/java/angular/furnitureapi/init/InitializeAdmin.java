package angular.furnitureapi.init;

import angular.furnitureapi.user.domain.userEntity.UserEntity;
import angular.furnitureapi.user.domain.userRole.UserEntityRole;
import angular.furnitureapi.user.repository.UserEntityRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;

@Component
public class InitializeAdmin implements CommandLineRunner {

    private final UserEntityRepository userEntityRepository;
    private final PasswordEncoder passwordEncoder;

    public InitializeAdmin(UserEntityRepository userEntityRepository, PasswordEncoder passwordEncoder) {
        this.userEntityRepository = userEntityRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void run(String... args) throws Exception {

        if (this.userEntityRepository.count() != 0) {
            return;
        }

        UserEntity admin = new UserEntity();
        UserEntityRole roleAdmin = new UserEntityRole("ADMIN");
        UserEntityRole roleUser = new UserEntityRole("USER");

        admin.setUsername("Vlado");
        admin.setPassword(this.passwordEncoder.encode("123456"));
        roleAdmin.setUser(admin);
        roleUser.setUser(admin);
        admin.setRoles(Set.of(roleUser, roleAdmin));

        this.userEntityRepository.saveAndFlush(admin);

    }
}
