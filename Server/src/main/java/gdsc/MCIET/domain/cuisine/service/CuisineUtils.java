package gdsc.MCIET.domain.cuisine.service;

import gdsc.MCIET.domain.cuisine.domain.Cuisine;

public interface CuisineUtils {

    Cuisine findCuisine(Long id);

    Cuisine findCuisineByTitle(String title);
}
