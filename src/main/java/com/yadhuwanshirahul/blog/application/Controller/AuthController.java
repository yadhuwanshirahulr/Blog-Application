package com.yadhuwanshirahul.blog.application.Controller;

import com.yadhuwanshirahul.blog.application.Config.JWTHelper;
import com.yadhuwanshirahul.blog.application.PayLoad.JWTAuthRequest;
import com.yadhuwanshirahul.blog.application.PayLoad.JWTAuthResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthController {

    @Autowired
    private JWTHelper jwtHelper;
    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private AuthenticationManager authenticationManager;
    @PostMapping("/login")
    public ResponseEntity<JWTAuthResponse> getToken(@RequestBody JWTAuthRequest request){
        authenticate(request.getUsername(),request.getPassword());
        UserDetails user = userDetailsService.loadUserByUsername(request.getUsername());
        JWTAuthResponse response = new JWTAuthResponse();
        response.setToken(jwtHelper.generateToken(user));
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    private void authenticate(String username, String password) {
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(username,password);
        authenticationManager.authenticate(authenticationToken);
    }
}
