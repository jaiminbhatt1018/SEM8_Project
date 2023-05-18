/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jwt;

/**
 *
 * @author praj4
 */


import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import java.security.Key;
import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import javax.crypto.spec.SecretKeySpec;



public class JwtAuthService {

    private static final long EXPIRATION_TIME = 864_000_000; // 10 days (in milliseconds)
    private static final String secret = "asdfSFS34wfsdfsdfSDSD32dfsddDDerQSNCK34SOWEK5354fdgdf4";

     Key hmacKey = new SecretKeySpec(Base64.getDecoder().decode(secret), 
                            SignatureAlgorithm.HS256.getJcaName());
    // Generate a new JWT token
    public String generateJwtToken(String username, String role) {
        Map<String, Object> claims = new HashMap<>();
        claims.put("username", username);
        claims.put("role", role);
        Date expirationDate = new Date(System.currentTimeMillis() + EXPIRATION_TIME);
        return Jwts.builder().setClaims(claims).setSubject(username).setIssuedAt(new Date()).setExpiration(expirationDate).signWith(hmacKey).compact();
      
    }
 // Validate a JWT token
    public boolean validateJwtToken(String token) {
        try {
            Jwts.parserBuilder().setSigningKey(hmacKey).build().parseClaimsJws(token);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    // Extract username from a JWT token
    public String extractUsername(String token) {
        try {
            Claims claims = Jwts.parserBuilder().setSigningKey(hmacKey).build().parseClaimsJws(token).getBody();
            return claims.getSubject();
        } catch (Exception e) {
            return null;
        }
    }

    // Extract role from a JWT token
    public String extractRole(String token) {
        try {
            Claims claims = Jwts.parserBuilder().setSigningKey(hmacKey).build().parseClaimsJws(token).getBody();
            return (String) claims.get("role");
        } catch (Exception e) {
            return null;}
    }
}
