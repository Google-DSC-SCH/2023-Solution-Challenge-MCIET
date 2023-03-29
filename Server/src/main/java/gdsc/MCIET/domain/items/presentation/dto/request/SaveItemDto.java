package gdsc.MCIET.domain.items.presentation.dto.request;

import gdsc.MCIET.domain.items.domain.ItemCategory;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Getter
@RequiredArgsConstructor
public class SaveItemDto {

    @NotNull
    private String name;
    @NotNull
    private LocalDate expirationDate;
    @NotNull
    private ItemCategory itemCategory;

    public SaveItemDto(String name, LocalDate expirationDate, ItemCategory itemCategory){
        this.name = name;
        this.expirationDate = expirationDate;
        this.itemCategory = itemCategory;
    }
}
