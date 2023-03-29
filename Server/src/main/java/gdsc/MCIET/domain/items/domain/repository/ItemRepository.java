package gdsc.MCIET.domain.items.domain.repository;

import gdsc.MCIET.domain.items.domain.Item;
import gdsc.MCIET.domain.user.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface ItemRepository extends JpaRepository<Item, Long> {

    Item save(Item item);

    List<Item> findByUser(User user);

    Optional<Item> findById(Long id);

    @Query("select i from Item i where i.user = :user and i.expirationDate = :compareDate")
    List<Item> findByRemainDate(@Param("user") User user, @Param("compareDate") LocalDate compareDate);
}
