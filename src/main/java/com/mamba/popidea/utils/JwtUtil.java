package com.mamba.popidea.utils;

import com.mamba.popidea.exception.ErrorCodes;
import com.mamba.popidea.exception.RestException;
import com.mamba.popidea.model.UserBean;
import com.mamba.popidea.model.common.project.Audience;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;
import java.security.Key;
import java.util.Date;

import static com.mamba.popidea.utils.DateUtil.*;

/**
 * program: JwtUtil
 * Description: Jwt工具类
 * author: joebig7
 **/
public final class JwtUtil {

    private static SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;

    public static String createJWT(UserBean userBean, Audience audience) {
        JwtBuilder builder = Jwts.builder().setHeaderParam("typ", "JWT")
                .claim("role", userBean.getStatus())
                .claim("unique_name", userBean.getNickName())
                .claim("userId", userBean.getId())
                .setIssuer(audience.getClientId())
                .setAudience(audience.getName())
                .setSubject(audience.getName())
                .signWith(signatureAlgorithm, calculateKey(audience.getBase64Secret()));
        //添加Token过期时间
        if (audience.getExpiresSecond() >= 0) {
            Long expMillis = getCurrentTimeMillis() + audience.getExpiresSecond();
            Date expireDate = new Date(expMillis);
            builder.setExpiration(expireDate).setNotBefore(getCurrentTime());
        }
        return builder.compact();
    }

    public static Claims parseJWT(String jsonWebToken, String base64Security) {
        Claims claims = Jwts.parser()
                .setSigningKey(DatatypeConverter.parseBase64Binary(base64Security))
                .parseClaimsJws(jsonWebToken)
                .getBody();
        return claims;

    }

    private static Key calculateKey(String secret) {
        //生成签名密钥
        byte[] apiKeySecretBytes = DatatypeConverter.parseBase64Binary(secret);
        Key signingKey = new SecretKeySpec(apiKeySecretBytes, signatureAlgorithm.getJcaName());
        return signingKey;
    }


    /**
     * 根据claims获取userId
     *
     * @param claims
     * @return
     */
    public static Long getUserId(Claims claims) {
        if (claims != null) {
            Long userId = (Long) claims.get("userId");
            return userId;
        }
        throw RestException.newInstance(ErrorCodes.USER_LOGIN_FAULT);
    }


}