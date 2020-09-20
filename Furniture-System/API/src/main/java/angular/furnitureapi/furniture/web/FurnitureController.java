package angular.furnitureapi.furniture.web;

import angular.furnitureapi.furniture.domain.FurnitureDto;
import angular.furnitureapi.furniture.service.FurnitureService;
import angular.furnitureapi.user.service.UserEntityService;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.security.Principal;
import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/furniture")
public class FurnitureController {

    private final FurnitureService furnitureService;

    public FurnitureController(FurnitureService furnitureService) {
        this.furnitureService = furnitureService;
    }

    @PostMapping("/create")
    public FurnitureDto createNewFurniture(@RequestBody FurnitureDto furnitureDto, Principal principal) {
        return this.furnitureService.createNew(furnitureDto, principal.getName());
    }

    @GetMapping("/all")
    public List<FurnitureDto> getAllFurniture() {
        return this.furnitureService.getAll();
    }

    @GetMapping("/details/{id}")
    public FurnitureDto getDetails(@PathVariable(name = "id") long id) {
        return this.furnitureService.findById(id);
    }

    @GetMapping("/mine")
    public List<FurnitureDto> getMine(Principal principal) {
        return this.furnitureService.getMine(principal.getName());
    }

    @Transactional
    @DeleteMapping("/delete/{id}")
    public void deleteFurniture(@PathVariable(name = "id") long id, Principal principal) {

       this.furnitureService.deleteFurniture(id, principal.getName());
    }

}
