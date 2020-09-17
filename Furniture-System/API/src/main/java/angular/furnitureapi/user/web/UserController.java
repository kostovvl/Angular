package angular.furnitureapi.user.web;

import angular.furnitureapi.user.domain.userEntity.UserEntityDto;
import angular.furnitureapi.user.service.UserEntityService;
import org.springframework.web.bind.annotation.*;


@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/auth")
public class UserController {

    private final UserEntityService userEntityService;

    public UserController(UserEntityService userEntityService) {
        this.userEntityService = userEntityService;
    }

    @PostMapping("/register")
    public UserEntityDto register(@RequestBody UserEntityDto newUser) {
        return this.userEntityService.register(newUser);
    }

}
