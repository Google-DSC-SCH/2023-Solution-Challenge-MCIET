package gdsc.MCIET.global.utils;

import gdsc.MCIET.domain.user.domain.User;
import gdsc.MCIET.domain.user.domain.repository.UserRepository;
import gdsc.MCIET.global.exception.UserNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserUtilsImpl implements UserUtils{

    private final UserRepository userRepository;

    @Override
    public User findUser(String email) {
        return userRepository.findByEmail(email).orElseThrow(()-> UserNotFoundException.EXCEPTION);
    }
}
