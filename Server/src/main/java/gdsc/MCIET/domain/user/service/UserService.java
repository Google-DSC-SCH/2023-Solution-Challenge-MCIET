package gdsc.MCIET.domain.user.service;

import gdsc.MCIET.domain.refreshtoken.domain.RefreshToken;
import gdsc.MCIET.domain.refreshtoken.domain.repository.RefreshTokenRepository;
import gdsc.MCIET.domain.user.domain.User;
import gdsc.MCIET.domain.user.domain.repository.UserRepository;
import gdsc.MCIET.domain.user.presentation.dto.request.UserInfoDto;
import gdsc.MCIET.domain.user.presentation.dto.response.ShowUserInfoDto;
import gdsc.MCIET.global.security.JwtTokenProvider;
import gdsc.MCIET.global.utils.SecurityUtils;
import gdsc.MCIET.global.utils.UserUtilsImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import java.util.Collections;

@Service
@RequiredArgsConstructor
public class UserService {

    private final JwtTokenProvider jwtTokenProvider;

    private final UserRepository userRepository;

    private final RefreshTokenRepository refreshTokenRepository;

    private final UserUtilsImpl userUtils;

    public String signIn(UserInfoDto userInfoDto, HttpServletResponse response){
        if(userRepository.findByEmail(userInfoDto.getEmail()).isEmpty()) {
            User user = userRepository.save(User.builder()
                    .name(userInfoDto.getName())
                    .email(userInfoDto.getEmail())
                    .roles(Collections.singletonList("USER"))
                    .build());
            extracted(user.getEmail(), response);
            return user.getEmail();
        } else {
            User user = userUtils.findUser(userInfoDto.getEmail());
            extracted(user.getEmail(), response);
            return user.getEmail();
        }
    }

    public ShowUserInfoDto showUserInfo(){
        String email = SecurityUtils.getCurrentUserId();
        User user = userUtils.findUser(email);
        return new ShowUserInfoDto(user);
    }


    private void extracted(String email, HttpServletResponse response) {

        String accessToken = jwtTokenProvider.createAccessToken(email, Collections.singletonList("ROLE_USER"));
        String refreshToken = jwtTokenProvider.createRefreshToken(email, Collections.singletonList("ROLE_USER"));

        jwtTokenProvider.setHeaderAccessToken(response, accessToken);
        jwtTokenProvider.setHeaderRefreshToken(response, refreshToken);

        refreshTokenRepository.save(new RefreshToken(refreshToken));
    }
}
