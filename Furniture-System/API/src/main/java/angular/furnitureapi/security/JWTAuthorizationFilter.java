package angular.furnitureapi.security;

import angular.furnitureapi.user.service.UserDetailServiceImpl;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collection;

import static angular.furnitureapi.security.SecurityConstraints.*;

public class JWTAuthorizationFilter extends BasicAuthenticationFilter {

    private UserDetailServiceImpl userDetailService;

    public JWTAuthorizationFilter(AuthenticationManager authenticationManager, UserDetailServiceImpl userDetailService) {
        super(authenticationManager);
        this.userDetailService = userDetailService;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest req,
                                    HttpServletResponse res,
                                    FilterChain chain) throws IOException, ServletException {
        String header = req.getHeader(HEADER_STRING);
        String urI = req.getRequestURI();

        if (header == null || !header.startsWith(TOKEN_PREFIX)) {
            chain.doFilter(req, res);
            return;
        }

        if (!urI.equals(SIGN_UP_URL)) {
            UsernamePasswordAuthenticationToken authentication = getAuthentication(req, userDetailService);
            SecurityContextHolder.getContext().setAuthentication(authentication);
        } else {
            SecurityContextHolder.createEmptyContext();
        }
        chain.doFilter(req, res);
    }

    // Reads the JWT from the Authorization header, and then uses JWT to validate the token
    private UsernamePasswordAuthenticationToken getAuthentication(HttpServletRequest request,
                                                                  UserDetailServiceImpl userDetailsService) {
        String token = request.getHeader(HEADER_STRING);

        if (token != null) {
            // parse the token.
            String user = JWT.require(Algorithm.HMAC512(SECRET.getBytes()))
                    .build()
                    .verify(token.replace(TOKEN_PREFIX, ""))
                    .getSubject();

            Collection<GrantedAuthority> authorities =
                    (Collection<GrantedAuthority>) userDetailsService.loadUserByUsername(user).getAuthorities();

            if (user != null) {
                // new arraylist means authorities
                return new UsernamePasswordAuthenticationToken(user, null, authorities);

            }

            return null;
        }

        return null;
    }
}
