package restApi.security;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import io.jsonwebtoken.Jwts;
import restApi.model.User;
import restApi.service.SearchMethodService;

@Service
public class TokenAuthenticationService {
	static final long EXPIRATIONTIME = 864_000_000; // 10 days
	static final String SECRET = "ThisIsASecret";
	static final String TOKEN_PREFIX = "Bearer";
	static final String HEADER_STRING = "Authorization";

	@Autowired
	UserDetailsService useDetailsService;

	@Autowired
	SearchMethodService searchUser;

	/*
	 * method return Authentication of user which was in token claim.
	 * If there is no user there will be null value return.
	 */
	
	public Authentication getAuthentication(HttpServletRequest request) {

		String token = request.getHeader(HEADER_STRING);
		if (token != null) {
			// parse the token.
			String user = Jwts.parser().setSigningKey(SECRET).parseClaimsJws(token.replace(TOKEN_PREFIX, "")).getBody()
					.getSubject();

			User applicationUser = searchUser.searchUserCascade(user);
			if (applicationUser == null) {
				throw new UsernameNotFoundException(user);
			}
			List<GrantedAuthority> lista = new ArrayList<GrantedAuthority>();
			lista.add(new SimpleGrantedAuthority(applicationUser.getRole().getRole()));

			return user != null ? new UsernamePasswordAuthenticationToken(user, null, lista) : null;
		}
		return null;

	}
}
