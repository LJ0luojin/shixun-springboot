package edu.fit.api;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;
import java.util.Random;

public class JWTutil {
    private static long expire = 604800;
    private static String secret = "abcdefghabcdefghabcdefghabcdefgh";

    public static String generateToken(String username){
        Date now = new Date();
        Date expiration = new Date(now.getTime() + 1000 *expire);
        return Jwts.builder()
                .setHeaderParam("type","JWT")
                .setSubject(username)
                .setIssuedAt(now)
                .setExpiration(expiration)
                .signWith(SignatureAlgorithm.HS256,secret)
                .compact();
    }

    public  static Claims getClaimsByToken(String token){
        return Jwts.parser()
                .setSigningKey(secret)
                .parseClaimsJws(token)
                .getBody();
    }

    public static void main(String[] args) {
        Random random = new Random();
        int i = random.nextInt(100);
        String s = i+"";
        if(i<10){
            s = "0"+i;
        }
        System.out.println(s);
    }
}
