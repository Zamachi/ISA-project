package com.example.trade_centre.config.filters;

import com.example.trade_centre.config.JWT.JWTTokenUtil;
import com.example.trade_centre.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import static org.springframework.util.ObjectUtils.isEmpty;

@Component
public class JWTTokenFilter extends OncePerRequestFilter {

    @Autowired
    JWTTokenUtil jwtTokenUtil;

    @Autowired
    UserService userService;


    @Override
//    @CrossOrigin(origins = "*")
    protected void doFilterInternal(HttpServletRequest httpServletRequest,
                                    HttpServletResponse httpServletResponse,
                                    FilterChain filterChain) throws ServletException, IOException {

        String header = httpServletRequest.getHeader(HttpHeaders.AUTHORIZATION );

        if( isEmpty(header) || !header.startsWith("Bearer ") )
        {
            filterChain.doFilter(httpServletRequest,httpServletResponse);
            return;
        }

        String token = header.split(" ")[1].trim();

        if( !jwtTokenUtil.validate(token) ){
            filterChain.doFilter(httpServletRequest,httpServletResponse);
        }

        var user_details = userService.loadUserByUsername( jwtTokenUtil.getUsername(token) );

        UsernamePasswordAuthenticationToken authenticationToken =
                new UsernamePasswordAuthenticationToken(  user_details , null, user_details == null ? List.of():user_details.getAuthorities() );

        authenticationToken.setDetails( new WebAuthenticationDetailsSource().buildDetails(httpServletRequest));

        SecurityContextHolder.getContext().setAuthentication(authenticationToken);

        filterChain.doFilter(httpServletRequest,httpServletResponse);
    }
}
