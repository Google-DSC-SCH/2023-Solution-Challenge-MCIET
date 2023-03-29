package gdsc.MCIET.domain.recipe.domain;

import gdsc.MCIET.domain.cuisine.domain.Cuisine;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Recipe {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "recipe_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cuisine_id")
    private Cuisine cuisine;

    private String exposition;
    private String pictureUrl;

    @Builder
    public Recipe(Cuisine cuisine, String exposition, String pictureUrl){
        this.cuisine = cuisine;
        this.exposition = exposition;
        this.pictureUrl = pictureUrl;
    }
}
