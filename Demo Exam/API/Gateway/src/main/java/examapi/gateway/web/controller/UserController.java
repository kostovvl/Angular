package examapi.gateway.web.controller;
import examapi.gateway.domain.user.UserEntity;
import examapi.gateway.web.client.UserClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class UserController {

   private final UserClient userClient;
   private final PasswordEncoder passwordEncoder;

   public UserController(UserClient userClient, PasswordEncoder passwordEncoder) {
      this.userClient = userClient;
      this.passwordEncoder = passwordEncoder;
   }

   @PostMapping("/register")
   public ResponseEntity<?> registerUser(@RequestBody UserEntity newUser) {
      newUser.setPassword(this.passwordEncoder.encode(newUser.getPassword()));
      UserEntity result = this.userClient.postForNewUser(newUser);
      System.out.println();
      if (result != null) {
      return new ResponseEntity<>(result, HttpStatus.OK);
      } else {
         return new ResponseEntity<>("someShit", HttpStatus.BAD_REQUEST);
      }
   }
}
