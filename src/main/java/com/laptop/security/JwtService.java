package com.laptop.security;

import java.security.Key;
import java.util.Calendar;
import java.util.Date;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;

public class JwtService {
    private static final String SECRET_KEY = "396e5674627033673968724355774777703864586b4a466e69636a3146574944";

    public static String generate(Integer id, String role) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.add(Calendar.DAY_OF_MONTH, 1);
        Date expire = calendar.getTime();
        try{
            return Jwts.builder().setIssuedAt(new Date())
                    .setExpiration(expire)
                    .setSubject(role)
                    .setId(String.valueOf(id))
                    .signWith(getKey(),
                            SignatureAlgorithm.HS256)
                    .compact();
        }
        catch (Exception e) {
            return null;
        }

    }

    public static boolean isExpired(String token) {
        return extractExpiryDate(token).after(new Date());
    }

    public static String extractRole(String token) {
        return extractAllClaims(token).getSubject();
    }

    public static Integer extractId(String token) {
        try{
            return Integer.parseInt(extractAllClaims(token).getId());
        }
        catch (Exception ex){
            return null;
        }
    }

    private static Date extractExpiryDate(String token) {
        return extractAllClaims(token).getExpiration();
    }

    private static Claims extractAllClaims(String token) {
        try {
            return Jwts.parserBuilder().setSigningKey(getKey()).build().parseClaimsJws(token).getBody();
        }
        catch (Exception e) {
            return null;
        }

    }

    private static Key getKey() {
        byte[] keyBytes = Decoders.BASE64.decode(SECRET_KEY);
        return Keys.hmacShaKeyFor(keyBytes);
    }
}
