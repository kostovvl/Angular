package angular.furnitureapi.init;

import angular.furnitureapi.user.domain.UserEntity;
import angular.furnitureapi.user.domain.UserEntityRole;
import angular.furnitureapi.user.repository.UserEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Set;

@Component
public class InitializeAdmin implements CommandLineRunner {

    private final UserEntityRepository userEntityRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
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
        UserEntityRole roleUser = new UserEntityRole("USER");
        UserEntityRole roleAdmin = new UserEntityRole("ADMIN");
        admin.setUsername("Vlado");
        admin.setEmail("vlado@vlado.com");
        admin.setPassword(this.passwordEncoder.encode("123456"));

        roleUser.setUser(admin);
        roleAdmin.setUser(admin);
        admin.setRoles(Set.of(roleUser, roleAdmin));

        this.userEntityRepository.saveAndFlush(admin);

    }
}
