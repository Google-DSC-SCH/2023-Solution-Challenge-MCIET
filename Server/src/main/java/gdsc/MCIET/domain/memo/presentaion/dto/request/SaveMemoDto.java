package gdsc.MCIET.domain.memo.presentaion.dto.request;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class SaveMemoDto {

    @NotNull
    private String contents;

    public SaveMemoDto(String contents){
        this.contents = contents;
    }
}
