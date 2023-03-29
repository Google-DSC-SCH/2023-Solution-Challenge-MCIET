package gdsc.MCIET.domain.cuisine.domain.repository;

import gdsc.MCIET.domain.cuisine.domain.Cuisine;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CuisineRepository extends JpaRepository<Cuisine, Long> {
    Cuisine save(Cuisine cuisine);
    Optional<Cuisine> findById(Long id);
    Optional<Cuisine> findByTitle(String title);
}
