package com.wipro.usermgmtv2.service.impl;

import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.util.Base64;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.crypto.bcrypt.BCrypt;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.stereotype.Service;

import com.wipro.usermgmtv2.dto.Token;
import com.wipro.usermgmtv2.entity.User;
import com.wipro.usermgmtv2.repo.UserRepo;
import com.wipro.usermgmtv2.service.UserService;
import com.wipro.usermgmtv2.util.AppConstant;
import com.wipro.usermgmtv2.util.EncryptUtil;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

@Service
public class USerServiceImpl implements UserService {
	// private static final String SECRET = "d3No4uat7HEgU6RHjJ902G+gTj3+qHNZZ/CN6BUeCa4cKFSkp1AGFXH7ODj3A+fPDf1WQB2x6Yknr6VFh5ySyw==";


	@Autowired
    UserRepo userRepo;

    @Override
    public List<User> findAll() {
        return userRepo.findAll();
    }

    @Override
    public User findById(int id) {
        Optional<User> userOpt = userRepo.findById(id);
        return userOpt.orElse(null);
    }

    @Override
    public void save(User user) {
        if (user.getSalt() == null || user.getSalt().isEmpty()) {
            String salt = BCrypt.gensalt();
            user.setSalt(salt);
            user.setPassword(EncryptUtil.getEncryptedPassword(user.getPassword(), salt));
        }
        userRepo.save(user);
    }

    @Override
    public void deleteById(int id) {
        userRepo.deleteById(id);
    }

    @Override
    public Token login(User user) {
        User userData = userRepo.findByEmail(user.getEmail());
        if (userData == null) {
            throw new RuntimeException("Invalid credentials");
        }

        
        if (userData.getSalt() == null || userData.getSalt().isEmpty()) {
            String salt = BCrypt.gensalt();
            userData.setSalt(salt);
            userData.setPassword(EncryptUtil.getEncryptedPassword(userData.getPassword(), salt));
            userRepo.save(userData);
        }

        
        String hashedPassword = EncryptUtil.getEncryptedPassword(user.getPassword(), userData.getSalt());
        if (!hashedPassword.equals(userData.getPassword())) {
            throw new RuntimeException("Invalid credentials");
        }

        String jwtToken = "Bearer " + getJWTToken(user.getEmail());
        Token token = new Token();
        token.setToken(jwtToken);
        return token;
    }


    private String getJWTToken(String username) {
        Key key = Keys.hmacShaKeyFor(Base64.getDecoder().decode(AppConstant.SECRET));
        List<GrantedAuthority> authorities = AuthorityUtils.commaSeparatedStringToAuthorityList("ROLE_USER");

        return Jwts.builder()
                .setId("jwtExample")
                .setSubject(username)
                .claim("authorities", authorities.stream()
                                                  .map(GrantedAuthority::getAuthority)
                                                  .collect(Collectors.toList()))
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 600000))
                .signWith(key)
                .compact();
    }

}
