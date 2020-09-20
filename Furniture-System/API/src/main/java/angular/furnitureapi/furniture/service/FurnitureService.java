package angular.furnitureapi.furniture.service;

import angular.furnitureapi.furniture.domain.Furniture;
import angular.furnitureapi.furniture.domain.FurnitureDto;
import angular.furnitureapi.furniture.repository.FurnitureRepository;
import angular.furnitureapi.user.domain.userEntity.UserEntity;
import angular.furnitureapi.user.domain.userEntity.UserEntityDto;
import angular.furnitureapi.user.service.UserEntityService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class FurnitureService {

    private final FurnitureRepository furnitureRepository;
    private final UserEntityService userEntityService;
    private final ModelMapper mapper;

    public FurnitureService(FurnitureRepository furnitureRepository, UserEntityService userEntityService, ModelMapper mapper) {
        this.furnitureRepository = furnitureRepository;
        this.userEntityService = userEntityService;
        this.mapper = mapper;
    }

    @Transactional
    public FurnitureDto createNew(FurnitureDto furnitureDto, String username) {

        long id = this.userEntityService.getUserId(username);

        Furniture furniture = this.mapper.map(furnitureDto, Furniture.class);
        UserEntity user = this.userEntityService.getById(id);
        furniture.setCreator(user);
        List<Furniture> existingFurniture = user.getFurniture();
        existingFurniture.add(furniture);
        user.setFurniture(existingFurniture);

        return this.mapper.map(this.furnitureRepository.saveAndFlush(furniture), FurnitureDto.class);
    }

    public List<FurnitureDto> getAll() {
        return this.furnitureRepository.findAll()
                .stream().map(f -> this.mapper.map(f, FurnitureDto.class))
                .collect(Collectors.toList());
    }

    public FurnitureDto findById(long id) {
        return this.mapper.map(this.furnitureRepository.findById(id), FurnitureDto.class);
    }

    public List<FurnitureDto> getMine(String username) {
        return this.furnitureRepository.findByCreatorUsername(username)
                .stream().map(f -> this.mapper.map(f, FurnitureDto.class))
                .collect(Collectors.toList());
    }

    @Transactional
    public void deleteFurniture(long id, String username) {

        UserEntity user = this.userEntityService.getById(this.userEntityService.getUserId(username));

        List<Furniture> existing = this.furnitureRepository.findByCreatorId((long) 1);

        existing = existing.stream().filter(f -> f.id != id).collect(Collectors.toList());
        user.setFurniture(existing);

        this.furnitureRepository.deleteById(id);
    }
}
