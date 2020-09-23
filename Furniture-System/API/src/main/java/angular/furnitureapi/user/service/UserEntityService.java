package angular.furnitureapi.user.service;

import angular.furnitureapi.user.domain.UserEntity;
import angular.furnitureapi.user.domain.UserEntityDto;
import angular.furnitureapi.user.domain.UserEntityRole;
import angular.furnitureapi.user.repository.UserEntityRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class UserEntityService {

    private final UserEntityRepository userEntityRepository;
    private final ModelMapper mapper;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserEntityService(UserEntityRepository userEntityRepository, ModelMapper mapper, PasswordEncoder passwordEncoder) {
        this.userEntityRepository = userEntityRepository;
        this.mapper = mapper;
        this.passwordEncoder = passwordEncoder;
    }

    public UserEntityDto findByUsername(String username) {
        return this.userEntityRepository.findByUsername(username)
                .map(u -> this.mapper.map(u, UserEntityDto.class))
                .orElse(null);
    }

    public UserEntityDto signUp(UserEntityDto newUserDto) {
        UserEntity newUser = this.mapper.map(newUserDto, UserEntity.class);

        UserEntityRole roleUser = new UserEntityRole("USER");
        roleUser.setUser(newUser);

        newUser.setPassword(this.passwordEncoder.encode(newUserDto.getPassword()));
        newUser.setRoles(Set.of(roleUser));
        return this.mapper.map(this.userEntityRepository.saveAndFlush(newUser), UserEntityDto.class);
    }

    public Long getUserId(String username) {
        return this.userEntityRepository.findByUsername(username).orElse(null).getId();
    }

    public boolean userExists(UserEntityDto userEntityDto) {
        return this.userEntityRepository.findByUsername(userEntityDto.getUsername()).orElse(null) != null;
    }
}
