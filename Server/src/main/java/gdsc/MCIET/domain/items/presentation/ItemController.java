package gdsc.MCIET.domain.items.presentation;

import gdsc.MCIET.domain.items.domain.Item;
import gdsc.MCIET.domain.items.presentation.dto.request.SaveItemDto;
import gdsc.MCIET.domain.items.presentation.dto.response.RecommendItemDto;
import gdsc.MCIET.domain.items.presentation.dto.response.Show1DayDto;
import gdsc.MCIET.domain.items.presentation.dto.response.ShowItemDetailDto;
import gdsc.MCIET.domain.items.presentation.dto.response.ShowItemDto;
import gdsc.MCIET.domain.items.service.ItemService;
import gdsc.MCIET.global.s3.service.AwsS3Service;
import gdsc.MCIET.global.successResponse.ResponseMessage;
import gdsc.MCIET.global.successResponse.StatusCode;
import gdsc.MCIET.global.successResponse.SuccessResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/item")
public class ItemController {

    private final ItemService itemService;
    private final AwsS3Service awsS3Service;

    @PostMapping("/add")
    public ResponseEntity addItems(@RequestPart(value = "multipartFile") MultipartFile multipartFile,
                                   @RequestPart(value = "addItemDto") SaveItemDto saveItemDto){

        String filePath = awsS3Service.uploadFile(multipartFile);
        Long itemId = itemService.saveItem(filePath, saveItemDto);
        return SuccessResponse.successtoResponseEntity(StatusCode.OK, itemId, ResponseMessage.SAVE_ITEM);
    }

    @GetMapping("/list")
    public ResponseEntity showItems(){
        List<ShowItemDto> result = itemService.showItems();
        return SuccessResponse.successtoResponseEntity(StatusCode.OK, result, ResponseMessage.SHOW_ITEM_LIST);
    }

    @GetMapping("/{itemId}")
    public ResponseEntity showItemDetail(@PathVariable Long itemId){
        ShowItemDetailDto result = itemService.showItemDetail(itemId);
        return SuccessResponse.successtoResponseEntity(StatusCode.OK, result, ResponseMessage.SHOW_ITEM_DETAIL);
    }

    @DeleteMapping("/{itemId}")
    public ResponseEntity deleteItem(@PathVariable Long itemId){
        Item item = itemService.sendItem(itemId);
        awsS3Service.deleteFile(item.getFilePath());
        itemService.deleteItem(itemId);
        return SuccessResponse.successtoResponseEntity(StatusCode.OK, null, ResponseMessage.DELETE_ITEM);
    }

    @GetMapping("/1day/list")
    public ResponseEntity item1dayRemain(){
        List<Show1DayDto> result = itemService.ShowItems1Day();
        return SuccessResponse.successtoResponseEntity(StatusCode.OK, result, ResponseMessage.SHOW_ITEM_1DAY_LIST);
    }

    @GetMapping("/{email}/recommend-list")
    public ResponseEntity showRecommendItems(@PathVariable String email){
        List<RecommendItemDto> result = itemService.sendItemName(email);
        return SuccessResponse.successtoResponseEntity(StatusCode.OK, result, ResponseMessage.SHOW_ITEM_NAME);
    }


}
