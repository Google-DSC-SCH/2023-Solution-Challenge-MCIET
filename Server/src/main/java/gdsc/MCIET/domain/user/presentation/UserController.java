package gdsc.MCIET.domain.user.presentation;

import gdsc.MCIET.domain.user.presentation.dto.request.UserInfoDto;
import gdsc.MCIET.domain.user.presentation.dto.response.ShowUserInfoDto;
import gdsc.MCIET.domain.user.service.UserService;
import gdsc.MCIET.global.successResponse.ResponseMessage;
import gdsc.MCIET.global.successResponse.StatusCode;
import gdsc.MCIET.global.successResponse.SuccessResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    @PostMapping("/signIn")
    public ResponseEntity signIn(@RequestBody UserInfoDto userInfoDto, HttpServletResponse response){
        String result = userService.signIn(userInfoDto, response);
        return SuccessResponse.successtoResponseEntity(StatusCode.OK, result, ResponseMessage.SIGN_IN);
    }

    @GetMapping("/show")
    public ResponseEntity showUserInfo(){
        ShowUserInfoDto result = userService.showUserInfo();
        return SuccessResponse.successtoResponseEntity(StatusCode.OK, result, ResponseMessage.SHOW_USER_INFO);
    }

}
