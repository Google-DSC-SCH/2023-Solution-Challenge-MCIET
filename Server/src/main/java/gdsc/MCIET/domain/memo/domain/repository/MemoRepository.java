package gdsc.MCIET.domain.memo.domain.repository;

import gdsc.MCIET.domain.memo.domain.Memo;
import gdsc.MCIET.domain.user.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface MemoRepository extends JpaRepository<Memo, Long> {
    Memo save(Memo memo);
    List<Memo> findByUser(User user);
    Optional<Memo> findById(Long id);
}
