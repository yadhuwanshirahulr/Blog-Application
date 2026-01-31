package com.yadhuwanshirahul.blog.application.Config;

import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.MalformedJwtException;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
//public class JWTAuthenticationFilter extends OncePerRequestFilter {
//    @Autowired
//    UserDetailsService userDetailsService;
//    @Autowired
//    private JWTHelper jwtTokenHelper;
//    @Override
//    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
//
//        //1.get token
//        String requestToken=request.getHeader("Authorization");
//
//        //Bearer
//        String username = null;
//        String token = null;
//        if(request!=null && requestToken.startsWith("Bearer ")){
//            token = requestToken.substring(7);
//            try{
//                username = jwtTokenHelper.getUserNameFromToken(token);
//            }
//            catch (IllegalArgumentException e){
//                System.out.println("Unable to get JWT Token");
//            }
//            catch(ExpiredJwtException e){
//                System.out.println("Jwt Token is expired");
//            }
//            catch (MalformedJwtException e){
//                System.out.println("Jwt token is wrong");
//            }
//        }
//        else{
//            System.out.println("Jwt toke is null");
//        }
//        if(username!=null && SecurityContextHolder.getContext().getAuthentication()==null){
//            UserDetails user = userDetailsService.loadUserByUsername(username);
//            if(jwtTokenHelper.validateToken(token,user)){
//                //alll ok
//                //now authenticate
//                UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(user,null,user.getAuthorities());
//                usernamePasswordAuthenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
//                SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
//
//            }
//            else{
//                System.out.println("Invalid JWT Token");
//            }
//
//        }
//        else{
//            System.out.println("Username is null");
//        }
//        filterChain.doFilter(request,response);
//    }
//}

public class JWTAuthenticationFilter extends OncePerRequestFilter {

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private JWTHelper jwtTokenHelper;

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain)
            throws ServletException, IOException {

        // 🔹 Skip login API
        if (request.getServletPath().equals("/api/v1/auth/login")) {
            filterChain.doFilter(request, response);
            return;
        }

        String requestToken = request.getHeader("Authorization");

        String username = null;
        String token = null;

        if (requestToken != null && requestToken.startsWith("Bearer ")) {

            token = requestToken.substring(7);

            try {
                username = jwtTokenHelper.getUserNameFromToken(token);
            }
            catch (IllegalArgumentException e) {
                System.out.println("Unable to get JWT Token");
            }
            catch (ExpiredJwtException e) {
                System.out.println("JWT Token has expired");
            }
            catch (MalformedJwtException e) {
                System.out.println("JWT Token is malformed");
            }
        }

        if (username != null &&
                SecurityContextHolder.getContext().getAuthentication() == null) {

            UserDetails user =
                    userDetailsService.loadUserByUsername(username);

            if (jwtTokenHelper.validateToken(token, user)) {

                UsernamePasswordAuthenticationToken authentication =
                        new UsernamePasswordAuthenticationToken(
                                user, null, user.getAuthorities());

                authentication.setDetails(
                        new WebAuthenticationDetailsSource()
                                .buildDetails(request));

                SecurityContextHolder.getContext()
                        .setAuthentication(authentication);
            }
        }

        filterChain.doFilter(request, response);
    }
}

