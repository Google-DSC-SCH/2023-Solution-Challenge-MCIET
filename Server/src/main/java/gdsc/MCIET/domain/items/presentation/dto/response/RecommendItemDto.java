package gdsc.MCIET.domain.items.presentation.dto.response;

import gdsc.MCIET.domain.items.domain.Item;
import lombok.Getter;

@Getter
public class RecommendItemDto {

    private String name;

    public RecommendItemDto(Item item){
        this.name = item.getName();
    }
}
