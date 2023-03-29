package gdsc.MCIET.domain.items.presentation.dto.response;

import gdsc.MCIET.domain.items.domain.ItemCategory;
import gdsc.MCIET.domain.items.domain.Item;
import lombok.Getter;

import java.time.LocalDate;

@Getter
public class ShowItemDto {

    private String name;
    private LocalDate expirationDate;
    private int remainExpirationDate;
    private ItemCategory itemCategory;

    public ShowItemDto(Item item){
        this.name = item.getName();
        this.expirationDate = item.getExpirationDate();
        this.remainExpirationDate = item.getRemainExpirationDate();
        this.itemCategory = item.getItemCategory();
    }
}
