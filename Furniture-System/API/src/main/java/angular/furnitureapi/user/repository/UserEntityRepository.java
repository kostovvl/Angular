package angular.furnitureapi.user.repository;

import angular.furnitureapi.user.domain.userEntity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserEntityRepository extends JpaRepository<UserEntity, Long> {

    Optional<UserEntity> findByUsername(String username);

    @Query("select u from UserEntity as u left join Furniture as f on u.id = f.creator.id where f.id =:productId ")
    Optional<UserEntity> customQuery(long productId);

}
