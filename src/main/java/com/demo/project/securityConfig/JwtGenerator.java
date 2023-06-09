package com.demo.project.securityConfig;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.boot.autoconfigure.neo4j.Neo4jProperties;
import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.Date;
@Service
public class JwtGenerator {

    public String generateToken(String email)
    {
        Date currentDate=new Date();
        Date expireyDate=new Date(currentDate.getTime()+1800000);
         String token=Jwts.builder()
                 .setSubject(email)
                 .setIssuedAt(currentDate)
                 .setExpiration(expireyDate)
                 .signWith(SignatureAlgorithm.HS512,"register")
                 .compact();
        return token;
    }
    public String getUserEmailFromJwt(String token)
    {
        Claims claims=Jwts.parser()
                .setSigningKey("register")
                .parseClaimsJws(token)
                .getBody();
                return claims.getSubject();
    }
    public boolean validateToken(String token){
        try
        {
            Jwts.parser().setSigningKey("register").parseClaimsJws(token);
            return true;
        }
        catch (Exception ex)
        {
            throw new AuthenticationCredentialsNotFoundException("JwT was expired or incorrect");
        }
    }
}
