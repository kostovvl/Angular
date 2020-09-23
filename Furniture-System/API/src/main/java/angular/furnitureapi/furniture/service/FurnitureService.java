package angular.furnitureapi.furniture.service;

import angular.furnitureapi.furniture.repository.FurnitureRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FurnitureService {

    private final FurnitureRepository furnitureRepository;
    private final ModelMapper mapper;

    @Autowired
    public FurnitureService(FurnitureRepository furnitureRepository, ModelMapper mapper) {
        this.furnitureRepository = furnitureRepository;
        this.mapper = mapper;
    }
}
