package gdsc.MCIET.domain.memo.presentaion.dto.response;

import gdsc.MCIET.domain.memo.domain.Memo;
import lombok.Getter;

@Getter
public class ShowMemoDto {

    private String contents;

    public ShowMemoDto(Memo memo){
        this.contents = memo.getContents();
    }
}
