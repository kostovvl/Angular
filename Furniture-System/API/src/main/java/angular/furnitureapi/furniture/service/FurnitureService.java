package angular.furnitureapi.furniture.service;

import angular.furnitureapi.furniture.domain.Furniture;
import angular.furnitureapi.furniture.domain.FurnitureDto;
import angular.furnitureapi.furniture.repository.FurnitureRepository;
import angular.furnitureapi.user.domain.UserEntity;
import angular.furnitureapi.user.repository.UserEntityRepository;
import angular.furnitureapi.user.service.UserEntityService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.security.Principal;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class FurnitureService {

    private final FurnitureRepository furnitureRepository;
    private final UserEntityRepository userEntityRepository;
    private final UserEntityService userEntityService;
    private final ModelMapper mapper;

    @Autowired
    public FurnitureService(FurnitureRepository furnitureRepository,
                            UserEntityRepository userEntityRepository, UserEntityService userEntityService, ModelMapper mapper) {
        this.furnitureRepository = furnitureRepository;
        this.userEntityRepository = userEntityRepository;
        this.userEntityService = userEntityService;
        this.mapper = mapper;
    }

    @Transactional
    public FurnitureDto addNew(FurnitureDto newFurnitureDto, Principal principal) {
        //GetEntities
        Furniture newFurniture = this.mapper.map(newFurnitureDto, Furniture.class);
        UserEntity creator = this.userEntityRepository.findByUsername(principal.getName()).orElse(null);

        //Set connections between entities
        newFurniture.setCreator(creator);
        List<Furniture>creatorExistingFurniture = creator.getFurniture();
        creatorExistingFurniture.add(newFurniture);

        //Seed Furniture
        return this.mapper.map(this.furnitureRepository.saveAndFlush(newFurniture), FurnitureDto.class);
    }

    public List<FurnitureDto> getAll() {
        return this.furnitureRepository.findAll()
                .stream()
                .map(f -> this.mapper.map(f, FurnitureDto.class))
                .collect(Collectors.toList());
    }

    public List<FurnitureDto> getMine(Principal principal) {

        Long loggedUserId = this.userEntityService.getUserId(principal.getName());

        return this.furnitureRepository.findByCreatorId(loggedUserId)
                .stream()
                .map(f -> this.mapper.map(f, FurnitureDto.class))
                .collect(Collectors.toList());
    }

    public FurnitureDto getDetails(long id) {
        return this.furnitureRepository.findById(id)
                .map(f -> this.mapper.map(f, FurnitureDto.class))
                .orElse(null);
    }

    @Transactional
    public void delete (long id, String username, Principal principal) {
        Furniture furniture = this.furnitureRepository.findById(id).orElse(null);

        if (!furniture.getCreator().getUsername().equals(username) || !principal.getName().equals(username)) {
            throw new UnsupportedOperationException();
        }

        UserEntity creator = this.userEntityRepository.findByUsername(username).orElse(null);
        List<Furniture>existingFurniture = creator.getFurniture();
        existingFurniture = existingFurniture.stream()
                .filter(f -> f.getId() != furniture.getId())
                .collect(Collectors.toList());
        creator.setFurniture(existingFurniture);

     this.furnitureRepository.deleteById(furniture.getId());
    }

    @Transactional
    public void deleteAdmin(long id) {
        Furniture furniture = this.furnitureRepository.findById(id).orElse(null);

        UserEntity creator = this.userEntityRepository.findByUsername(furniture.getCreator().getUsername()).orElse(null);
        List<Furniture>existingFurniture = creator.getFurniture();
        existingFurniture = existingFurniture.stream()
                .filter(f -> f.getId() != furniture.getId())
                .collect(Collectors.toList());
        creator.setFurniture(existingFurniture);

        this.furnitureRepository.deleteById(furniture.getId());
    }
}
