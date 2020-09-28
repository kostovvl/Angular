package seenit.api.user.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import seenit.api.user.domain.UserEntity;
import seenit.api.user.domain.UserEntityDTO;
import seenit.api.user.domain.UserEntityRole;
import seenit.api.user.repository.UserEntityRepository;

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

    public boolean userExists(String username) {
        return this.userEntityRepository.findByUsername(username).orElse(null) != null;
    }

    public UserEntityDTO registerUser(UserEntityDTO userEntityDTO) {
        UserEntity userEntity = this.mapper.map(userEntityDTO, UserEntity.class);
        userEntity.setPassword(this.passwordEncoder.encode(userEntityDTO.getPassword()));

        UserEntityRole roleUser = new UserEntityRole();

        roleUser.setRole("USER");
        roleUser.setUser(userEntity);

        userEntity.setRoles(Set.of(roleUser));

        UserEntity response = this.userEntityRepository.saveAndFlush(userEntity);

        return this.mapper.map(response, UserEntityDTO.class);
    }

    public long getIdByUsername(String username) {
        return this.userEntityRepository.findByUsername(username).orElse(null).getId();
    }
}
