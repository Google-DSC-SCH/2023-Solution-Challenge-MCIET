package gdsc.MCIET.domain.items.domain;

import gdsc.MCIET.domain.user.domain.User;
import gdsc.MCIET.global.database.BaseTimeEntity;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.Period;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Item extends BaseTimeEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "items_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    private String name;
    private LocalDate expirationDate;
    private String filePath;
    private int remainExpirationDate;

    @Enumerated(EnumType.STRING)
    private ItemCategory itemCategory;

    @Builder
    public Item(User user, String name, LocalDate expirationDate, String filePath, int remainExpirationDate, ItemCategory itemCategory){
        this.user = user;
        this.name = name;
        this.expirationDate = expirationDate;
        this.filePath = filePath;
        this.remainExpirationDate = remainExpirationDate;
        this.itemCategory = itemCategory;
    }

    public int calculationExpirationDate(LocalDate expirationDate){
        return Period.between(LocalDate.now(), expirationDate).getDays();
    }

}
