package angular.furnitureapi.user.service;

import angular.furnitureapi.user.domain.userEntity.UserEntity;
import angular.furnitureapi.user.domain.userEntity.UserEntityDto;
import angular.furnitureapi.user.domain.userRole.UserEntityRole;
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

    public UserEntityDto register(UserEntityDto newUser) {
        UserEntity userEntity = this.mapper.map(newUser, UserEntity.class);
        UserEntityRole roleUser = new UserEntityRole("USER");
        roleUser.setUser(userEntity);
        userEntity.setRoles(Set.of(roleUser));
        userEntity.setPassword(this.passwordEncoder.encode(userEntity.getPassword()));

        return this.mapper.map(this.userEntityRepository.saveAndFlush(userEntity), UserEntityDto.class);
    }

    public UserEntity getById(long id) {
        return this.userEntityRepository.getOne(id);
    }

    public long getUserId(String username) {
        return this.userEntityRepository.findByUsername(username).orElse(null).getId();
    }

    public long getUserIdForAdmin(long id) {
        return this.userEntityRepository.customQuery(id).orElse(null).getId();
    }

}
