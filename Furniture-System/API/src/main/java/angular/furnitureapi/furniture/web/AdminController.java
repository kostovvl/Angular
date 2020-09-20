package angular.furnitureapi.furniture.web;

import angular.furnitureapi.furniture.service.FurnitureService;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/admin")
public class AdminController {

    private final FurnitureService furnitureService;

    public AdminController(FurnitureService furnitureService) {
        this.furnitureService = furnitureService;
    }

    @DeleteMapping("/delete/{id}")
    public void deleteFurniture(@PathVariable(name = "id") long id) {



        this.furnitureService.deleteFurnitureAdmin(id);
    }
}
