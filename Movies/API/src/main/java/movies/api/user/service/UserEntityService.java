package movies.api.user.service;

import movies.api.user.domain.UserDto;
import movies.api.user.domain.UserEntity;
import movies.api.user.repository.UserEntityRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class UserEntityService {

    private final UserEntityRepository userEntityRepository;
    private final ModelMapper mapper;

    public UserEntityService(UserEntityRepository userEntityRepository, ModelMapper mapper) {
        this.userEntityRepository = userEntityRepository;
        this.mapper = mapper;
    }

    public UserDto register(UserDto userDto) {
        UserEntity userEntity = this.mapper.map(userDto, UserEntity.class);
        userEntity.setPhoneNumber(userDto.getPhonePrefix() + userDto.getPhoneNumber());
        return this.mapper.map(this.userEntityRepository.saveAndFlush(userEntity), UserDto.class);
    }
}
