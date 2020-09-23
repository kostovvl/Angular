package angular.furnitureapi.furniture.web;

import angular.furnitureapi.furniture.domain.Furniture;
import angular.furnitureapi.furniture.domain.FurnitureDto;
import angular.furnitureapi.furniture.service.FurnitureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/furniture")
public class FurnitureController {

    private final FurnitureService furnitureService;

    @Autowired
    public FurnitureController(FurnitureService furnitureService) {
        this.furnitureService = furnitureService;
    }

    @PostMapping("/create")
    public FurnitureDto addNewFurniture (@RequestBody FurnitureDto newFurnitureDto, Principal principal) {
        return this.furnitureService.addNew(newFurnitureDto, principal);
    }

    @GetMapping("/all")
    public List<FurnitureDto> getAll() {
        return this.furnitureService.getAll();
    }

    @GetMapping("/mine")
    public List<FurnitureDto> getMine(Principal principal) {
        return this.furnitureService.getMine(principal);
    }

    @GetMapping("details/{id}")
    public FurnitureDto getDetails(@PathVariable(name = "id")long id) {
        return this.furnitureService.getDetails(id);
    }

    @DeleteMapping("delete/{id}/{username}")
    public ResponseEntity<?> delete(@PathVariable(name = "id") long id,
                                    @PathVariable(name = "username") String username, Principal principal) {
        try  {
            this.furnitureService.delete(id, username, principal);
            return new ResponseEntity<>("Success", HttpStatus.OK);

        } catch (UnsupportedOperationException e) {
            return new ResponseEntity<>("You are not authorised for this operation", HttpStatus.UNAUTHORIZED);
        }
    }
}

