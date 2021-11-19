/*
 * package com.cg.wallet.controller;
 * 
 * 
 * import java.util.Date; import java.util.List; import
 * java.util.stream.Collectors;
 * 
 * import org.springframework.beans.factory.annotation.Autowired; import
 * org.springframework.security.core.GrantedAuthority; import
 * org.springframework.security.core.authority.AuthorityUtils; import
 * org.springframework.security.crypto.password.PasswordEncoder; import
 * org.springframework.web.bind.annotation.PostMapping; import
 * org.springframework.web.bind.annotation.RequestBody; import
 * org.springframework.web.bind.annotation.RequestMapping; import
 * org.springframework.web.bind.annotation.RequestParam; import
 * org.springframework.web.bind.annotation.RestController;
 * 
 * import com.cg.wallet.dto.Users;
 * 
 * import io.jsonwebtoken.Jwts; import io.jsonwebtoken.SignatureAlgorithm;
 * 
 * @RestController public class UserController {
 * 
 * @Autowired PasswordEncoder coder;
 * 
 * @RequestMapping("hello") public String helloWorld(@RequestParam(value="name",
 * defaultValue="World") String name) { return "Hello "+name+"!!"; }
 * 
 * @PostMapping("user") public Users login(@RequestBody Users user) { // call
 * the service check user + pwd
 * 
 * 
 * String token = getJWTToken(user.getName()); Users newUser = new Users();
 * newUser.setName(user.getName()); newUser.setToken(token); return newUser;
 * 
 * }
 * 
 * private String getJWTToken(String username) { String secretKey =
 * "mySecretKey"; List<GrantedAuthority> grantedAuthorities = AuthorityUtils
 * .commaSeparatedStringToAuthorityList("ROLE_USER");
 * 
 * String token = Jwts .builder() .setId("softtekJWT") .setSubject(username)
 * .claim("authorities", grantedAuthorities.stream()
 * .map(GrantedAuthority::getAuthority) .collect(Collectors.toList()))
 * .setIssuedAt(new Date(System.currentTimeMillis())) .setExpiration(new
 * Date(System.currentTimeMillis() + 600000))
 * .signWith(SignatureAlgorithm.HS512, secretKey.getBytes()).compact();
 * 
 * return "Bearer " + token; } }
 */