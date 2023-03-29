package gdsc.MCIET.domain.cuisine.presentation;

import gdsc.MCIET.domain.cuisine.presentation.dto.response.ShowCuisineInfoDto;
import gdsc.MCIET.domain.cuisine.service.CuisineService;
import gdsc.MCIET.global.successResponse.ResponseMessage;
import gdsc.MCIET.global.successResponse.StatusCode;
import gdsc.MCIET.global.successResponse.SuccessResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/cuisine")
public class CuisineController {

    private final CuisineService cuisineService;

    @GetMapping("/show-info")
    public ResponseEntity showInfo(@RequestParam String title){
        ShowCuisineInfoDto result = cuisineService.cuisineInfo(title);
        return SuccessResponse.successtoResponseEntity(StatusCode.OK, result, ResponseMessage.SHOW_CUISINE_INFO);
    }
}
