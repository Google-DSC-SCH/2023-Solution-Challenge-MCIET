package gdsc.MCIET.domain.recipe.service;

import gdsc.MCIET.domain.cuisine.domain.Cuisine;
import gdsc.MCIET.domain.cuisine.service.CuisineUtils;
import gdsc.MCIET.domain.recipe.domain.Recipe;
import gdsc.MCIET.domain.recipe.domain.repository.RecipeRepository;
import gdsc.MCIET.domain.recipe.presentation.dto.request.SaveRecipeDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RecipeService {

    private final RecipeRepository recipeRepository;
    private final CuisineUtils cuisineUtils;

    //레시피 저장
    public Long saveRecipe(SaveRecipeDto saveRecipeDto){
        Cuisine cuisine = cuisineUtils.findCuisine(saveRecipeDto.getCuisineId());
        return recipeRepository.save(Recipe.builder()
                .cuisine(cuisine)
                .exposition(saveRecipeDto.getExposition())
                .pictureUrl(saveRecipeDto.getPictureUrl())
                .build()).getId();
    }
}
