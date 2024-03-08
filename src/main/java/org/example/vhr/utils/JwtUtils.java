package org.example.vhr.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.example.vhr.model.vo.HrVo;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.Calendar;
import java.util.Date;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;

/**
 * @author 阿运
 * @date 2024/3/3 21:20
 * JwtUtil 描述
 */

@Component
public class JwtUtils {
    //Jwt秘钥
    @Value("${spring.security.jwt.key}")
    String key;

    @Value("${spring.security.jwt.expire}")
    int expireTime;


    public String createJwt(HrVo vo) {
        Algorithm algorithm = Algorithm.HMAC256(key);
        Date time = this.expireTime();
        return JWT.create()
                .withClaim("id",vo.getId())
                .withClaim("username",vo.getUsername())
                .withClaim("authorities",vo.getAuthorities().stream().map(GrantedAuthority::getAuthority).collect(Collectors.toList()))
                .withExpiresAt(time)
                .withIssuedAt(new Date())
                .sign(algorithm);
    }

    public DecodedJWT resolveJwt(String headerToken){
        String token = this.convertToken(headerToken);
        if (token == null) return null;
        Algorithm algorithm = Algorithm.HMAC256(key);
        JWTVerifier jwtVerifier = JWT.require(algorithm).build();
        try {
            DecodedJWT verify = jwtVerifier.verify(token);
            Date expiresAt = verify.getExpiresAt();
            return new Date().after(expiresAt) ? null : verify;

        } catch (JWTVerificationException e) {
            return null;
        }
    }

    private String convertToken (String headerToken) {
        if (headerToken == null || !headerToken.startsWith("Bearer "))
            return null;
        return headerToken.substring(7);

    }

    public HrVo toHrVo(DecodedJWT jwt) {
        Map<String,Claim>  claimMap = jwt.getClaims();

        HrVo hrVo = new HrVo();
        hrVo.setUsername(claimMap.get("username").asString());
        hrVo.setPassword("");
        hrVo.setId(claimMap.get("id").asInt());
        hrVo.setAuthorities(claimMap.get("authorities").asList(SimpleGrantedAuthority.class));
        return hrVo;
    }


    public Date expireTime() {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.HOUR,expireTime * 24);
        return calendar.getTime();
    }
}