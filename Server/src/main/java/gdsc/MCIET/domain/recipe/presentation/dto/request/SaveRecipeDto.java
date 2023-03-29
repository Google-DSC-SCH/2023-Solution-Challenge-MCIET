package gdsc.MCIET.domain.recipe.presentation.dto.request;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class SaveRecipeDto {

    private Long cuisineId;
    private String exposition;
    private String pictureUrl;

    public SaveRecipeDto(Long cuisineId, String exposition, String pictureUrl){
        this.cuisineId =cuisineId;
        this.exposition = exposition;
        this.pictureUrl = pictureUrl;
    }
}
