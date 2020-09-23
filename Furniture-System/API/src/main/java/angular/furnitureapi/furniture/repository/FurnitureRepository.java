package angular.furnitureapi.furniture.repository;

import angular.furnitureapi.furniture.domain.Furniture;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FurnitureRepository extends JpaRepository<Furniture, Long> {

    List<Furniture> findAll();

    List<Furniture> findByCreatorId(long id);

}
