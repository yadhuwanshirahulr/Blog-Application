package com.yadhuwanshirahul.blog.application.Config;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import io.jsonwebtoken.*;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Component
public class JWTHelper {
    public static final long JWT_TOKEN_VALIDITY = 5*60*60;
    private String secret = "V3N2bHhQZVZ1QnJ0ZkNnU2Z5R1p1Z0d5R2J6N2tVZkFJY3B4Z1R4S2hKQkR6Q3pKQ1JzR0p4d1pFQk9aN1p0YkY5Qw==";

    //retrive username form token
    public String getUserNameFromToken(String token){
        return getClaimsFromToken(token,Claims::getSubject);
    }

    //retrive expiration date from jwt.token
    public Date getExpirationFromToken(String token){
        return getClaimsFromToken(token,Claims::getExpiration);
    }

    //for retriving any information from token
    public <T> T getClaimsFromToken(String token, Function<Claims,T> claimsResolver){
        final Claims claims = getAllClaimsFromToken(token);
        return  claimsResolver.apply(claims);
    }

    private Claims getAllClaimsFromToken(String token){
        return Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
    }

    //check if token expired
    private Boolean isTokenExpired(String token){
        final Date expiration = getExpirationFromToken(token);
        return expiration.before(new Date());
    }

    //generate token for user
    public String generateToken(UserDetails userDetails){
        Map<String,Object> claims = new HashMap<>();
        return doGenerateToken(claims,userDetails.getUsername());
    }
    private String doGenerateToken(Map<String,Object> claims, String subject){
        return Jwts.builder().setClaims(claims).setSubject(subject).setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis()+JWT_TOKEN_VALIDITY*1000))
                .signWith(SignatureAlgorithm.HS512,secret).compact();
    }
    public boolean validateToken(String token,UserDetails userDetails){
        final String username = getUserNameFromToken(token);
        return (username.equals(userDetails.getUsername())) && !isTokenExpired(token);
    }

}
