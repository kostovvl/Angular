package movies.api.user.web;

import movies.api.user.domain.UserDto;
import movies.api.user.service.UserEntityService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserEntityService userEntityService;

    public UserController(UserEntityService userEntityService) {
        this.userEntityService = userEntityService;
    }

    @CrossOrigin(origins = "http://localhost:4200/")
    @PostMapping("/register")
    public UserDto register(@RequestBody UserDto userDto) {

        return this.userEntityService.register(userDto);
    }

}
