package angular.furnitureapi.user.service;

import angular.furnitureapi.user.domain.userEntity.UserEntity;
import angular.furnitureapi.user.domain.userEntity.UserEntityDto;
import angular.furnitureapi.user.domain.userRole.UserEntityRole;
import angular.furnitureapi.user.repository.UserEntityRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserEntityService {

    private final UserEntityRepository userEntityRepository;
    private final ModelMapper mapper;


    @Autowired
    public UserEntityService(UserEntityRepository userEntityRepository, ModelMapper mapper) {
        this.userEntityRepository = userEntityRepository;
        this.mapper = mapper;
    }

    public UserEntityDto register(UserEntityDto newUser) {
        UserEntity userEntity = this.mapper.map(newUser, UserEntity.class);
        UserEntityRole roleUser = new UserEntityRole("ROLE_USER");
        roleUser.setUser(userEntity);
        userEntity.setRoles(List.of(roleUser));

        return this.mapper.map(this.userEntityRepository.saveAndFlush(userEntity), UserEntityDto.class);
    }

}
