package gdsc.MCIET.domain.user.presentation.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class UserInfoDto {

    private String name;
    private String email;

    public UserInfoDto(String name, String email) {
        this.name = name;
        this.email = email;
    }
}