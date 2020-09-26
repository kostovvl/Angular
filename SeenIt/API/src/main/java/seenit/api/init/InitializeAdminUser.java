package seenit.api.init;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import seenit.api.user.domain.UserEntity;
import seenit.api.user.domain.UserEntityRole;
import seenit.api.user.repository.UserEntityRepository;

import java.util.Set;

@Component
public class InitializeAdminUser implements CommandLineRunner {

    private final UserEntityRepository userEntityRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public InitializeAdminUser(UserEntityRepository userEntityRepository, PasswordEncoder passwordEncoder) {
        this.userEntityRepository = userEntityRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void run(String... args) throws Exception {

        if (this.userEntityRepository.count() != 0) {
            return;
        }

        UserEntity admin = new UserEntity();
        UserEntityRole roleUser = new UserEntityRole();
        UserEntityRole roleAdmin = new UserEntityRole();

        admin.setUsername("Vlado");
        admin.setPassword(this.passwordEncoder.encode("123456"));

        roleUser.setRole("USER");
        roleAdmin.setRole("ADMIN");

        roleUser.setUser(admin);
        roleAdmin.setUser(admin);

        admin.setRoles(Set.of(roleUser, roleAdmin));

        this.userEntityRepository.saveAndFlush(admin);

    }
}
