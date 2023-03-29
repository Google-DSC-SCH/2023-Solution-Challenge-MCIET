package gdsc.MCIET.global.filter;

import gdsc.MCIET.global.security.JwtTokenProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@RequiredArgsConstructor
@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    private final JwtTokenProvider jwtTokenProvider;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        // 헤더에서 JWT 를 받아옵니다.
        String accessToken = jwtTokenProvider.resolveAccessToken(request);
        String refreshToken = jwtTokenProvider.resolveRefreshToken(request);

        if (accessToken != null) {
            // 액세스 유효
            if (jwtTokenProvider.validateToken(accessToken)) {
                this.setAuthentication(accessToken);
//                request.setAttribute("userId", jwtTokenProvider.getUid(accessToken));
//                request.setAttribute("userUid", jwtTokenProvider.getUid(accessToken));
            }

            // 액세스 만료 && 리프레시 공백
            else if (!jwtTokenProvider.validateToken(accessToken) && refreshToken == null){
                request.setAttribute("exception", "access token end" );
            }

            // 액세스 만료 && 리프레시 존재
            else if (!jwtTokenProvider.validateToken(accessToken) && refreshToken != null) {
                boolean validateRefreshToken = jwtTokenProvider.validateToken(refreshToken);
                boolean isRefreshToken = jwtTokenProvider.existsRefreshToken(refreshToken);

                // 리프레시 유효
                if (validateRefreshToken && isRefreshToken) {
                    //if (jwtTokenProvider.isTokenPeriodLeftEnough(refreshToken)) {
                    String id = jwtTokenProvider.getEmail(refreshToken);
                    List roles = jwtTokenProvider.getRoles(refreshToken);

                    String newAccessToken = jwtTokenProvider.createAccessToken(id, roles);
                    jwtTokenProvider.setHeaderAccessToken(response, newAccessToken);

                    this.setAuthentication(newAccessToken);
//                    request.setAttribute("userId", jwtTokenProvider.getUid(newAccessToken));
//                    request.setAttribute("userUid", jwtTokenProvider.getUid(newAccessToken));
                    //}

                    // 일정 기간 이상 남았다면
//                    else {
//                        /// 리프레시 토큰으로 이메일 정보 가져오기
//                        String id = jwtTokenProvider.getUid(refreshToken);
//                        List roles = jwtTokenProvider.getRoles(refreshToken);
//
//                        String newAccessToken = jwtTokenProvider.createAccessToken(id, roles);
//                        String newRefreshToken = jwtTokenProvider.createRefreshToken(id, roles);
//
//                        jwtTokenProvider.updateRefreshToken(refreshToken, newRefreshToken);
//
//                        jwtTokenProvider.setHeaderAccessToken(response, newAccessToken);
//                        jwtTokenProvider.setHeaderRefreshToken(response, newRefreshToken);
//
//                        this.setAuthentication(newAccessToken);
//
//                        request.setAttribute("userId", jwtTokenProvider.getId(newAccessToken));
//                        request.setAttribute("userUid", jwtTokenProvider.getUid(newAccessToken));
//                    }
                }
                else {
                    request.setAttribute("exception", "refresh token not available" );
                }
            }
            else {
                request.setAttribute("exception", "refresh token not available" );
            }
        }
        filterChain.doFilter(request, response);
    }

    public void setAuthentication(String token) {
        Authentication authentication = jwtTokenProvider.getAuthentication(token);
        SecurityContextHolder.getContext().setAuthentication(authentication);
    }
}
