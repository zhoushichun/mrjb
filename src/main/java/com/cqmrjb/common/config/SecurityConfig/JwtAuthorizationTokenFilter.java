package com.cqmrjb.common.config.SecurityConfig;

import com.cqmrjb.common.config.redis.RedisUtilsImpl;
import io.jsonwebtoken.ExpiredJwtException;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.web.filter.OncePerRequestFilter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Configuration
@Data
public class JwtAuthorizationTokenFilter extends OncePerRequestFilter {

    @Autowired
    @Qualifier("userDetailsServiceImpl")
    private UserDetailsService userDetailsService;

    @Autowired
    private  JwtTokenUtil jwtTokenUtil;

    @Value("${jwt.tokenHeader}")
    private  String tokenHeader;

    @Autowired
    private RedisUtilsImpl redisUtils;



    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain chain) throws ServletException,
            IOException { final String requestHeader = request.getHeader(this.tokenHeader);
        String username = null;
        String authToken = null;

        if (requestHeader != null && requestHeader.startsWith("Bearer ")) {
            //剔除前面的Bearer
            authToken = requestHeader.substring(7);
            try {
                //从redis里面获取判断
//                username = (String)redisUtils.get(authToken);
                username = jwtTokenUtil.getUsernameFromToken(authToken);
            } catch (ExpiredJwtException e) {
            }
        }

        if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {

            UserDetails userDetails = this.userDetailsService.loadUserByUsername(username);

			if (jwtTokenUtil.validateToken(authToken, userDetails)) {
                    UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
                    authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                    SecurityContextHolder.getContext().setAuthentication(authentication);
                }
        }
        chain.doFilter(request, response);
        //给redis重置时间86400:1天
        if (authToken != null){
            redisUtils.expire(authToken,86400);
        }
    }
}

