package gdsc.MCIET.domain.cuisine.presentation.dto.request;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class SaveCuisineDto {

    private String title;
    private String ingredients;

    public SaveCuisineDto(String title, String ingredients){
        this.title = title;
        this.ingredients = ingredients;
    }
}
