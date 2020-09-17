package angular.furnitureapi.furniture.service;

import angular.furnitureapi.furniture.domain.Furniture;
import angular.furnitureapi.furniture.domain.FurnitureDto;
import angular.furnitureapi.furniture.repository.FurnitureRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FurnitureService {

    private final FurnitureRepository furnitureRepository;
    private final ModelMapper mapper;

    public FurnitureService(FurnitureRepository furnitureRepository, ModelMapper mapper) {
        this.furnitureRepository = furnitureRepository;
        this.mapper = mapper;
    }

    public FurnitureDto createNew(FurnitureDto furnitureDto) {
        Furniture furniture = this.mapper.map(furnitureDto, Furniture.class);

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

    public List<FurnitureDto> getMine(long id) {
        return this.furnitureRepository.findByCreatorId(id)
                .stream().map(f -> this.mapper.map(f, FurnitureDto.class))
                .collect(Collectors.toList());
    }

    public void deleteFurniture(long id) {
        this.furnitureRepository.deleteById(id);
    }
}
