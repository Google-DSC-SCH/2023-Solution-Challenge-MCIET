package gdsc.MCIET.global.config;

import gdsc.MCIET.global.filter.CustomAuthenticationEntryPoint;
import gdsc.MCIET.global.filter.JwtAuthenticationFilter;
import gdsc.MCIET.global.security.JwtTokenProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity //활성화 시키면 스프링 시큐리티 필터가 스프링 필터체인에 등록이 된다.
@RequiredArgsConstructor
public class SecurityConfig {

    private final JwtTokenProvider jwtTokenProvider;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
        http
                .csrf().disable()//crsf는 위조요청을 방지한다.
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS) // jwt는 토큰 방식이기 때문에 session을 사용하지 않는다
                .and()
                .authorizeRequests() // 인증절차에 대한 설정을 진행
                .antMatchers("/user/signIn", "/user/signIn2").permitAll() // 설정된 url은 인증되지 않더라도 누구든 접근 가능
                .anyRequest().authenticated() // 위 페이지 외 인증이 되어야 접근가능(ROLE에 상관없이)
                .and()
                .httpBasic().disable() //rest api 이므로 기본설정 사용안함. 기본설정은 비인증시 로그인 폼 화면으로 리다이렉트 된다.
                .formLogin().disable() //폼 로그인 방식 끄기
                .exceptionHandling()
                .authenticationEntryPoint(new CustomAuthenticationEntryPoint()) //인증 실패시 처리
                .and()
                .addFilterBefore(new JwtAuthenticationFilter(jwtTokenProvider),
                        UsernamePasswordAuthenticationFilter.class); //인증을 처리하는 기본필터 UsernamePasswordAuthenticationFilter
        // 대신 별도의 인증 로직을 가진 필터를 생성하고
        //사용하고 싶을 때 아래와 같이 필터를 등록하고 사용합니다.
        return http.build();
    }
}
