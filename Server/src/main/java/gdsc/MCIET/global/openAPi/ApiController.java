package gdsc.MCIET.global.openAPi;

import gdsc.MCIET.global.successResponse.ResponseMessage;
import gdsc.MCIET.global.successResponse.StatusCode;
import gdsc.MCIET.global.successResponse.SuccessResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/open-api")
public class ApiController {

    private final ApiService apiService;

    @GetMapping()
    public ResponseEntity saveOpenApi(){
        apiService.saveWithPoint();
        return SuccessResponse.successtoResponseEntity(StatusCode.OK, null, ResponseMessage.SAVE_OPEN_API);
    }

}
