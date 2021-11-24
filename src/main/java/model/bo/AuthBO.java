package model.bo;
import javax.crypto.spec.SecretKeySpec;
import model.bean.User;
import model.dao.AuthDao;
import javax.xml.bind.DatatypeConverter;
import java.security.Key;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;

import io.jsonwebtoken.SignatureAlgorithm;
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
		System.out.println("meow");
		return true;
	}
	public String resetPassword(String token,String oldPW,String newPW) {
		String msg = "";
		
		int id = encodeJWT(token).getId();
		User user = authDao.getUserById(id);
		if(!(bcrypt.matches(oldPW, user.getPassword()))) {
			msg = "current password is not correct";
		}else {
			String hashedPW = bcrypt.encode(user.getPassword());
			authDao.resetPassword(id, hashedPW);
			msg = generateToken(user);
		}
		return msg;
	}
	public String login(String username,String password) {
		String msg =  "user or password is invalid";
		User u = authDao.findUser(username);
		if(u == null) {
			return msg;
		}
		if(bcrypt.matches(password, u.getPassword())) {
			return generateToken(u);
		}
		return msg;
	}
	public String generateToken(User user) {
		SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;
		
		long nowMillis = System.currentTimeMillis();
		long tillMillis = 100000000;
	    Date now = new Date(nowMillis);
	    byte[] apiKeySecretBytes = DatatypeConverter.parseBase64Binary(keyTest);
	    Key signingKey = new SecretKeySpec(apiKeySecretBytes, signatureAlgorithm.getJcaName());
	    JwtBuilder builder = Jwts.builder().setId(Integer.toString(user.getId())).claim("username",user.getUsername())
	    		.claim("realname", user.getRealname())
                .setIssuedAt(now)
                .setExpiration(new Date(nowMillis + tillMillis))
                .signWith(signatureAlgorithm, signingKey);
	            
	    return builder.compact();
	}
	public boolean validateJWTToken(String token) {
		    boolean check = false;
		    try {
		      Jwts.parser().setSigningKey(keyTest).parseClaimsJws(token);
		     check = true;
		      }catch(ExpiredJwtException e) {
		    	  System.out.println("meow "+e);
		      }
		    return check;
	}
	public User encodeJWT(String token) {
		Claims claims = Jwts.parser().setSigningKey(DatatypeConverter.parseBase64Binary(keyTest))
				.parseClaimsJws(token).getBody();
		int id = Integer.parseInt(claims.getId());
		String username = (String)claims.get("username");
		String realname = (String)claims.get("realname");
		
		return new User(id,username,"",realname);
	}
	public User getUser(String token) {
		
		return encodeJWT(token);
	}

//	public String refreshToken() {
//		
//	}
}
