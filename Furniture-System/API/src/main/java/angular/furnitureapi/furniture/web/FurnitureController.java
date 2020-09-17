package angular.furnitureapi.furniture.web;

import angular.furnitureapi.furniture.domain.FurnitureDto;
import angular.furnitureapi.furniture.service.FurnitureService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public FurnitureDto createNewFurniture (@RequestBody FurnitureDto furnitureDto) {
        return this.furnitureService.createNew(furnitureDto);
    }

    @GetMapping("/all")
    public List<FurnitureDto> getAllFurniture() {
        return this.furnitureService.getAll();
    }

    @GetMapping("/details/{id}")
    public FurnitureDto getDetails(@PathVariable(name = "id") long id) {
      return   this.furnitureService.findById(id);
    }

    @GetMapping("/mine")
    public List<FurnitureDto> getMine() {
        long id = 1; // get from session;
        return this.furnitureService.getMine(id);
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<Void> deleteFurniture(@PathVariable(name = "id") long id) {
        try {
            furnitureService.deleteFurniture(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

}
