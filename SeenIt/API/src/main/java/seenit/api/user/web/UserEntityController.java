package seenit.api.user.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import seenit.api.user.domain.UserEntityDTO;
import seenit.api.user.service.UserEntityService;

@RestController
@RequestMapping("/auth")
public class UserEntityController {

    private final UserEntityService userEntityService;

    @Autowired
    public UserEntityController(UserEntityService userEntityService) {
        this.userEntityService = userEntityService;
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody() UserEntityDTO userEntityDTO) {
        if (this.userEntityService.userExists(userEntityDTO.getUsername())) {
            return new ResponseEntity<>(HttpStatus.UNPROCESSABLE_ENTITY);
        } else {
            UserEntityDTO responseUserEntity = this.userEntityService.registerUser(userEntityDTO);
            return new ResponseEntity<>(responseUserEntity, HttpStatus.OK);
        }

    }
}
