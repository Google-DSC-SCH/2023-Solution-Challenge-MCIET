package gdsc.MCIET.domain.user.presentation.dto.response;

import gdsc.MCIET.domain.user.domain.User;
import lombok.Getter;

@Getter
public class ShowUserInfoDto {

    private String name;
    private String email;

    public ShowUserInfoDto(User user){
        this.name = user.getName();
        this.email = user.getEmail();
    }
}
