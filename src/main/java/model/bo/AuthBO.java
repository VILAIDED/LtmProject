package model.bo;
import javax.crypto.spec.SecretKeySpec;
import model.bean.User;
import model.dao.AuthDao;

import javax.xml.bind.DatatypeConverter;
import java.security.Key;
import io.jsonwebtoken.*;
import java.util.Date; 
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
public class AuthBO {
	private String keyTest = "test thoi";
	BCryptPasswordEncoder bcrypt = new BCryptPasswordEncoder();
	AuthDao authDao = new AuthDao();
	public boolean register(User user) {
		if(authDao.findUser(user.getUsername()) != null) {
			return false;
		}
		
		String hashedPW = bcrypt.encode(user.getPassword());
		user.setPassword(hashedPW);
		authDao.insertUser(user);
		return true;
	}
	public String login(String username,String password) {
		String msg =  "";
		User u = authDao.findUser(username);
		if(u == null) {
			return "user or password is invalid";
		}
		if(bcrypt.matches(password, u.getPassword())) {
			return generateToken(Integer.toString(u.getId()));
		}
		return msg;
	}
	public String generateToken(String id) {
		SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;
		long nowMillis = System.currentTimeMillis();
	    Date now = new Date(nowMillis);
	    byte[] apiKeySecretBytes = DatatypeConverter.parseBase64Binary(keyTest);
	    Key signingKey = new SecretKeySpec(apiKeySecretBytes, signatureAlgorithm.getJcaName());
	    JwtBuilder builder = Jwts.builder().setId(id)
                .setIssuedAt(now)
                .signWith(signatureAlgorithm, signingKey);
	    
	    return builder.compact();
	}
	public int encodeJWT(String token) {
		Claims claims = Jwts.parser().setSigningKey(DatatypeConverter.parseBase64Binary(keyTest))
				.parseClaimsJws(token).getBody();
		return Integer.parseInt(claims.getId());
	}
	public User getUser(String token) {
		int id = encodeJWT(token);
		return authDao.getUserById(id);
	}
}
