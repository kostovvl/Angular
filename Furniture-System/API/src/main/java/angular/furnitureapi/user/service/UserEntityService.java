package angular.furnitureapi.user.service;

import angular.furnitureapi.user.repository.UserEntityRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserEntityService {

    private final UserEntityRepository userEntityRepository;
    private final ModelMapper mapper;


    @Autowired
    public UserEntityService(UserEntityRepository userEntityRepository, ModelMapper mapper) {
        this.userEntityRepository = userEntityRepository;
        this.mapper = mapper;
    }

    // TODO: 17.9.2020 г.   MNOGO E VAJNO, KOGATO SUZDAVAM USER-A DA
    //  MU DAM PRAVILNATA ROLQ(POLETO "role" DA E NAPISANO PRAVILNO)
}
