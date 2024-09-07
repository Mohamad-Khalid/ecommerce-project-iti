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

    public static String generate(String email) {
        System.out.println(email);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.add(Calendar.DAY_OF_MONTH, 1);
        Date expire = calendar.getTime();
        return Jwts.builder().setIssuedAt(new Date())
                .setExpiration(expire)
                .setSubject(email)
                .signWith(getKey(),
                        SignatureAlgorithm.HS256)
                .compact();
    }

    public static boolean isExpired(String token) {
        return extractExpiryDate(token).after(new Date());
    }

    public static String extractEmail(String token) {
        return extractAllClaims(token).getSubject();
    }

    private static Date extractExpiryDate(String token) {
        return extractAllClaims(token).getExpiration();
    }

    private static Claims extractAllClaims(String token) {
        return Jwts.parserBuilder().setSigningKey(getKey()).build().parseClaimsJws(token).getBody();
    }

    private static Key getKey() {
        byte[] keyBytes = Decoders.BASE64.decode(SECRET_KEY);
        return Keys.hmacShaKeyFor(keyBytes);
    }
}
