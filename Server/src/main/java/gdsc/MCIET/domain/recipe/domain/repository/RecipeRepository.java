package gdsc.MCIET.domain.recipe.domain.repository;

import gdsc.MCIET.domain.recipe.domain.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RecipeRepository extends JpaRepository<Recipe, Long> {
    Recipe save(Recipe recipe);
    Optional<Recipe> findById(Long id);
}
