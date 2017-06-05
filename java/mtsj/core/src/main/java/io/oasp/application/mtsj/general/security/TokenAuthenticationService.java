package io.oasp.application.mtsj.general.security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetailsService;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.oasp.application.mtsj.general.common.api.datatype.Role;
import io.oasp.application.mtsj.general.common.api.to.UserDetailsClientTo;
import io.oasp.module.security.common.api.accesscontrol.AccessControlProvider;

public class TokenAuthenticationService {

  /** Logger instance. */
  private static final Logger LOG = LoggerFactory.getLogger(TokenAuthenticationService.class);

  static final String ISSUER = "MyThaiStarApp";

  static final long EXPIRATIONTIME = 864_000_000; // 10 days

  static final String SECRET = "ThisIsASecret";

  static final String TOKEN_PREFIX = "Bearer";

  static final String HEADER_STRING = "Authorization";

  static final String CLAIM_SUBJECT = "sub";

  static final String CLAIM_ISSUER = "iss";

  static final String CLAIM_EXPIRATION = "exp";

  static final String CLAIM_CREATED = "iat";

  static final String CLAIM_SCOPE = "scope";

  @Inject
  private static UserDetailsService userDetailsService;

  // @Inject
  private static AccessControlProvider accessControlProvider;

  private static ApplicationContext applicationContext;

  static void addAuthentication(HttpServletResponse res, Authentication auth) {

    String token = generateToken(auth);
    res.addHeader(HEADER_STRING, TOKEN_PREFIX + " " + token);
  }

  static Authentication getAuthentication(HttpServletRequest request) {

    String token = request.getHeader(HEADER_STRING);
    if (token != null) {
      // parse the token.
      String user =
          Jwts.parser().setSigningKey(SECRET).parseClaimsJws(token.replace(TOKEN_PREFIX, "")).getBody().getSubject();

      // UsernamePasswordAuthenticationToken upat =
      // new UsernamePasswordAuthenticationToken(user, null, getAuthorities(token));
      // return user != null ? upat : null;
      return user != null ? new UsernamePasswordAuthenticationToken(user, null, getAuthorities(token)) : null;
    }
    return null;
  }

  @SuppressWarnings("unchecked")
  static Collection<? extends GrantedAuthority> getAuthorities(String token) {

    List<String> roles = getRolesFromToken(token);
    List<SimpleGrantedAuthority> authorities = new ArrayList<>();
    for (String role : roles) {
      authorities.add(new SimpleGrantedAuthority(role));
    }
    return authorities;

  }

  static String generateToken(Authentication auth) {

    List<String> scopes = new ArrayList<>();
    Collection<? extends GrantedAuthority> authorities = auth.getAuthorities();
    for (GrantedAuthority authority : authorities) {
      scopes.add(authority.getAuthority());
    }

    Map<String, Object> claims = new HashMap<>();
    claims.put(CLAIM_ISSUER, ISSUER);
    claims.put(CLAIM_SUBJECT, auth.getName());
    claims.put(CLAIM_SCOPE, auth.getAuthorities());
    claims.put(CLAIM_CREATED, new Date());
    claims.put(CLAIM_EXPIRATION, generateExpirationDate());

    return Jwts.builder().setClaims(claims).signWith(SignatureAlgorithm.HS512, SECRET).compact();
  }

  static Date generateExpirationDate() {

    return new Date(System.currentTimeMillis() + EXPIRATIONTIME);
  }

  static Set<GrantedAuthority> getAuthorities(List<String> roles) throws AuthenticationException {

    // determine granted authorities for spring-security...
    Set<GrantedAuthority> authorities = new HashSet<>();

    return authorities;
  }

  public static UserDetailsClientTo getUserdetailsFromToken(String token) {

    UserDetailsClientTo userDetails = new UserDetailsClientTo();
    try {
      String user =
          Jwts.parser().setSigningKey(SECRET).parseClaimsJws(token.replace(TOKEN_PREFIX, "")).getBody().getSubject();

      List<String> roles = getRolesFromToken(token);
      if (user != null) {
        userDetails.setName(user);
      }
      if (!roles.isEmpty()) {
        if (roles.get(0).equalsIgnoreCase(Role.WAITER.getName())) {
          userDetails.setRole(Role.WAITER);
        } else if (roles.get(0).equalsIgnoreCase(Role.CUSTOMER.getName())) {
          userDetails.setRole(Role.CUSTOMER);
        }
      }
    } catch (Exception e) {
      LOG.error(e.getMessage());
      userDetails = null;
    }

    return userDetails;
  }

  static List<String> getRolesFromToken(String token) {

    List<LinkedHashMap> scopes = Jwts.parser().setSigningKey(SECRET).parseClaimsJws(token.replace(TOKEN_PREFIX, ""))
        .getBody().get(CLAIM_SCOPE, List.class);

    List<String> roles = new ArrayList<>();
    for (LinkedHashMap<?, ?> scope : scopes) {
      roles.add(scope.get("authority").toString()/* .replace("ROLE_", "") */);
    }

    return roles;
  }

}