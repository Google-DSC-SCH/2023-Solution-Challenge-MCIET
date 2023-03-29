package gdsc.MCIET.domain.recipe.presentation.dto.response;

import gdsc.MCIET.domain.recipe.domain.Recipe;
import lombok.Getter;

@Getter
public class ShowRecipeDto {

    private String exposition;
    private String pictureUrl;

    public ShowRecipeDto(Recipe recipe){
        this.exposition = recipe.getExposition();
        this.pictureUrl = recipe.getPictureUrl();
    }
}
