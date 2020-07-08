package alla.shtokal.jwt;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Date;

public class JwtUsernameAndPasswordAuthentificationFilter extends UsernamePasswordAuthenticationFilter {

    private final AuthenticationManager authentificationManager;

    public JwtUsernameAndPasswordAuthentificationFilter(AuthenticationManager authentificationManager){
        this.authentificationManager = authentificationManager;
    }

    //@Order(Integer.MIN_VALUE)
    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
            throws AuthenticationException {
        try {
            UsernameAndPasswordAuthentificationRequest authentificationRequest =
                    new ObjectMapper().readValue(request.getInputStream(), UsernameAndPasswordAuthentificationRequest.class);
            Authentication authentication = new UsernamePasswordAuthenticationToken(
                    authentificationRequest.getUsername(),
                    authentificationRequest.getPassword()
            );
            Authentication authenticate = authentificationManager.authenticate(authentication);
            return authenticate;

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request,
                                            HttpServletResponse response,
                                            FilterChain chain,
                                            Authentication authResult) throws IOException, ServletException {
        String key = "sequresequresequresequresequresequresequre";
        String token = Jwts.builder()
                .setSubject(authResult.getName())
                .claim("authorities", authResult.getAuthorities())
                .setIssuedAt(new Date())
                .setExpiration(java.sql.Date.valueOf(LocalDate.now().plusWeeks(2)))
                .signWith(Keys.hmacShaKeyFor(key.getBytes()))
                .compact();
        response.addHeader("Authorization","Bearer" + token);

            }
}
