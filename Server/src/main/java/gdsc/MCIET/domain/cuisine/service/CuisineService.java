package gdsc.MCIET.domain.cuisine.service;

import gdsc.MCIET.domain.cuisine.domain.Cuisine;
import gdsc.MCIET.domain.cuisine.domain.repository.CuisineRepository;
import gdsc.MCIET.domain.cuisine.exception.CuisineNotFound;
import gdsc.MCIET.domain.cuisine.presentation.dto.request.SaveCuisineDto;
import gdsc.MCIET.domain.cuisine.presentation.dto.response.ShowCuisineInfoDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class CuisineService implements CuisineUtils{

    private final CuisineRepository cuisineRepository;

    //요리 저장
    public Long saveCuisine(SaveCuisineDto saveCuisineDto){
        return cuisineRepository.save(Cuisine.builder()
                .title(saveCuisineDto.getTitle())
                .ingredients(saveCuisineDto.getIngredients())
                .build()).getId();
    }

    //요리 세부사항 보여주기
    public ShowCuisineInfoDto cuisineInfo(String title){
        log.info("title = {}",title);
        Cuisine cuisine = findCuisineByTitle(title);
        ShowCuisineInfoDto showCuisineInfoDto = new ShowCuisineInfoDto(cuisine);
        return showCuisineInfoDto;
    }


    @Override
    public Cuisine findCuisine(Long id) {
        return cuisineRepository.findById(id).orElseThrow(() -> CuisineNotFound.EXCEPTION);
    }

    @Override
    public Cuisine findCuisineByTitle(String title) {
        return cuisineRepository.findByTitle(title).orElseThrow(() -> CuisineNotFound.EXCEPTION);
    }
}
