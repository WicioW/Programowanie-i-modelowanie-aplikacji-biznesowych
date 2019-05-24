package restApi.security;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import restApi.exception.AuthenticationException;
import restApi.model.User;
import restApi.repository.UserRepository;

@Service
public class CreateToken {

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	@Autowired
	private UserDetailsService userDetailsService;
	@Autowired
	private UserRepository userRepo;
	
	private final long EXPIRATIONTIME = 864_000_000; // 10 days
	private final String SECRET = "ThisIsASecret";

	public String generateToken(User user) {
		UserDetails tt = null;
		try {
			tt = userDetailsService.loadUserByUsername(user.getUsername());
		} catch (Exception e) {

			throw new AuthenticationException("Błąd loginu");
		}

		String JWT = null;
		if (bCryptPasswordEncoder.matches(user.getPassword(), tt.getPassword())) {

			JWT = Jwts.builder().setSubject(user.getUsername())
					.setExpiration(new Date(System.currentTimeMillis() + EXPIRATIONTIME))
					.setId(String.valueOf(userRepo.getId(user.getUsername()))).signWith(SignatureAlgorithm.HS512, SECRET)
					.compact();
		} else {
			throw new AuthenticationException("Błąd hasła");
		}
		return JWT;
	}
}
