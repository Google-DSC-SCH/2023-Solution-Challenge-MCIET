package gdsc.MCIET.domain.memo.presentaion;

import gdsc.MCIET.domain.memo.presentaion.dto.request.SaveMemoDto;
import gdsc.MCIET.domain.memo.presentaion.dto.response.ShowMemoDto;
import gdsc.MCIET.domain.memo.service.MemoService;
import gdsc.MCIET.global.successResponse.ResponseMessage;
import gdsc.MCIET.global.successResponse.StatusCode;
import gdsc.MCIET.global.successResponse.SuccessResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/memo")
public class MemoController {

    private final MemoService memoService;

    @PostMapping("/save")
    public ResponseEntity addMemo(@RequestBody SaveMemoDto saveMemoDto){
        Long memoId = memoService.saveMemo(saveMemoDto);
        return SuccessResponse.successtoResponseEntity(StatusCode.OK, memoId, ResponseMessage.SAVE_MEMO);
    }

    @GetMapping("/list")
    public ResponseEntity showAllMemo(){
        List<ShowMemoDto> result = memoService.showAllMemo();
        return SuccessResponse.successtoResponseEntity(StatusCode.OK, result, ResponseMessage.SHOW_MEMO_LIST);
    }

    @DeleteMapping ("/{memoId}")
    public ResponseEntity updateCheckBox(@PathVariable Long memoId){
        memoService.deleteMemo(memoId);
        return SuccessResponse.successtoResponseEntity(StatusCode.OK, null, ResponseMessage.DELETE_MEMO);
    }
}
