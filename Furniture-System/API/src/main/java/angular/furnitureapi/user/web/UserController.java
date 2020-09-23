package angular.furnitureapi.user.web;

import angular.furnitureapi.user.domain.UserEntityDto;
import angular.furnitureapi.user.service.UserEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class UserController {

    private final UserEntityService userEntityService;

    @Autowired
    public UserController(UserEntityService userEntityService) {
        this.userEntityService = userEntityService;
    }

    @PostMapping("/register")
    public ResponseEntity<?> signUp(@RequestBody UserEntityDto newUser) {
        if (this.userEntityService.userExists(newUser)) {

            return new ResponseEntity<>(newUser, HttpStatus.BAD_REQUEST);
        } else {
            return new ResponseEntity<>(this.userEntityService.signUp(newUser), HttpStatus.OK);
        }

    }

}
