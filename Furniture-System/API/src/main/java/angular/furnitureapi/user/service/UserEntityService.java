package angular.furnitureapi.user.service;

import angular.furnitureapi.user.domain.UserEntity;
import angular.furnitureapi.user.domain.UserEntityDto;
import angular.furnitureapi.user.repository.UserEntityRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

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

    public UserEntityDto signUp(UserEntityDto newUserDto) {
        UserEntity newUser = this.mapper.map(newUserDto, UserEntity.class);
        newUser.setPassword(this.passwordEncoder.encode(newUserDto.getPassword()));
        return this.mapper.map(this.userEntityRepository.saveAndFlush(newUser), UserEntityDto.class);
    }
}
