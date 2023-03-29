package gdsc.MCIET.domain.items.service;

import gdsc.MCIET.domain.items.domain.Item;
import gdsc.MCIET.domain.items.domain.repository.ItemRepository;
import gdsc.MCIET.domain.items.exception.ItemNotFound;
import gdsc.MCIET.domain.items.presentation.dto.request.SaveItemDto;
import gdsc.MCIET.domain.items.presentation.dto.response.RecommendItemDto;
import gdsc.MCIET.domain.items.presentation.dto.response.Show1DayDto;
import gdsc.MCIET.domain.items.presentation.dto.response.ShowItemDetailDto;
import gdsc.MCIET.domain.items.presentation.dto.response.ShowItemDto;
import gdsc.MCIET.domain.user.domain.User;
import gdsc.MCIET.global.utils.SecurityUtils;
import gdsc.MCIET.global.utils.UserUtilsImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ItemService implements ItemUtils {

    private final ItemRepository itemRepository;
    private final UserUtilsImpl userUtils;

    //아이템 저장하기
    public Long saveItem(String filePath, SaveItemDto saveItemDto){
        String email = SecurityUtils.getCurrentUserId();
        User user = userUtils.findUser(email);
        return itemRepository.save(Item.builder()
                .user(user)
                .name(saveItemDto.getName())
                .expirationDate(saveItemDto.getExpirationDate())
                .filePath(filePath)
                .remainExpirationDate(Period.between(LocalDate.now(), saveItemDto.getExpirationDate()).getDays())
                .itemCategory(saveItemDto.getItemCategory())
                .build()
        ).getId();
    }

    //아이템 보여주기
    public List<ShowItemDto> showItems(){
        String email = SecurityUtils.getCurrentUserId();
        User user = userUtils.findUser(email);
        List<Item> itemList = itemRepository.findByUser(user);
        for (Item item : itemList) {
            item.calculationExpirationDate(item.getExpirationDate());
        }
        return itemList.stream()
                .map(item -> new ShowItemDto(item))
                .collect(Collectors.toList());
    }

    //아이템 세부사항 보여주기
    public ShowItemDetailDto showItemDetail(Long itemId){
        String email = SecurityUtils.getCurrentUserId();
        userUtils.findUser(email);
        Item item = findItems(itemId);
        item.calculationExpirationDate(item.getExpirationDate());
        return new ShowItemDetailDto(item);
    }

    //아이템 id로 아이템 넘겨주기
    public Item sendItem(Long itemId){
        return findItems(itemId);
    }

    //아이템 삭제하기
    public void deleteItem(Long itemId){
        String email = SecurityUtils.getCurrentUserId();
        userUtils.findUser(email);
        Item item = findItems(itemId);
        itemRepository.delete(item);
    }

    //유통기한 1일 남은 재료 보여주기
    public List<Show1DayDto> ShowItems1Day(){
        String email = SecurityUtils.getCurrentUserId();
        User user = userUtils.findUser(email);
        LocalDate compareDate = LocalDate.now().plusDays(1);
        List<Item> items = itemRepository.findByRemainDate(user, compareDate);
        return items.stream().map(item -> new Show1DayDto(item)).collect(Collectors.toList());
    }

    //요리 추천 페이지 이름 보내주기
    public List<RecommendItemDto> sendItemName(String email){
        User user = userUtils.findUser(email);
        List<Item> itemList = itemRepository.findByUser(user);
        return itemList.stream()
                .map(items -> new RecommendItemDto(items))
                .collect(Collectors.toList());
    }

    @Override
    public Item findItems(Long itemId) {
        return itemRepository.findById(itemId).orElseThrow(() -> ItemNotFound.EXCEPTION);
    }
}
