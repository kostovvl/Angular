package angular.furnitureapi.user.web;

import angular.furnitureapi.furniture.service.FurnitureService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("/admin")
public class AdminController {

    private final FurnitureService furnitureService;

    public AdminController(FurnitureService furnitureService) {
        this.furnitureService = furnitureService;
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteAdmin(@PathVariable(name = "id") long id) {
        this.furnitureService.deleteAdmin(id);
        return new ResponseEntity<String>("Success", HttpStatus.OK);
    }
}
