package gdsc.MCIET.global.security.auth;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Getter
@ToString
public class AuthUser implements UserDetails {

    private final Long id;
    private final String email;
    private List<String> roles = new ArrayList<>();

    //계정의 권한 목록을 리턴
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.roles.stream()
                .map(SimpleGrantedAuthority::new)
                .collect(Collectors.toList());
    }

    //계정의 비밀번호를 리턴
    @Override
    public String getPassword() {
        return null;
    }

    //계정의 고유한 값을 리턴
    @Override
    public String getUsername() {
        return email;
    }

    //계정의 만료 여부 리턴
    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    //계정의 잠김 여부 리턴
    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    //비밀번호 만류 여부 리턴
    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    //계정의 활성화 여부 리턴
    @Override
    public boolean isEnabled() {
        return false;
    }
}
