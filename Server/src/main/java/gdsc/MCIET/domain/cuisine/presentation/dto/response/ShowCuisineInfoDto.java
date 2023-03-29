package gdsc.MCIET.domain.cuisine.presentation.dto.response;

import gdsc.MCIET.domain.cuisine.domain.Cuisine;
import gdsc.MCIET.domain.recipe.presentation.dto.response.ShowRecipeDto;
import lombok.Getter;

import java.util.List;
import java.util.stream.Collectors;

@Getter
public class ShowCuisineInfoDto {

    private String title;
    private String ingredients;
    private List<ShowRecipeDto> recipes;

    public ShowCuisineInfoDto(Cuisine cuisine){
        this.title = cuisine.getTitle();
        this.ingredients = cuisine.getIngredients();
        this.recipes = cuisine.getRecipes().stream()
                .map(recipe -> new ShowRecipeDto(recipe))
                .collect(Collectors.toList());
    }
}
