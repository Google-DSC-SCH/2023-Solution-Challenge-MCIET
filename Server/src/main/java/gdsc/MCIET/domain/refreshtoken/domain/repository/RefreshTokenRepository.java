package gdsc.MCIET.domain.refreshtoken.domain.repository;

import gdsc.MCIET.domain.refreshtoken.domain.RefreshToken;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;

public interface RefreshTokenRepository extends JpaRepository<RefreshToken, Long> {

    boolean existsByRefreshToken(String token);

    RefreshToken findByRefreshToken(String token);

    @Transactional
    void deleteByRefreshToken(String token);
}
