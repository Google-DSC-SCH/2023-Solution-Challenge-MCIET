package gdsc.MCIET.domain.cuisine.domain;

import gdsc.MCIET.domain.recipe.domain.Recipe;
import gdsc.MCIET.domain.user.domain.User;
import gdsc.MCIET.global.database.BaseTimeEntity;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Cuisine {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cuisine_id")
    private Long id;

    private String title;
    private String ingredients;

    @OneToMany(mappedBy = "cuisine", orphanRemoval = true)
    private List<Recipe> recipes = new ArrayList<>();

    @Builder
    public Cuisine(String title, String ingredients){
        this.title = title;
        this.ingredients = ingredients;
    }
}
