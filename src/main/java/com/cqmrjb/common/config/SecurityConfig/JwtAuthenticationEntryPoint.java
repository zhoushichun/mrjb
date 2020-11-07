package com.cqmrjb.common.config.SecurityConfig;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Configuration
@Slf4j
public class JwtAuthenticationEntryPoint implements AuthenticationEntryPoint {

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException e) throws IOException {
//    response.setStatus(403);
//    response.setHeader("Access-Control-Allow-Origin","请先登录");

    log.info("没有凭证======需要登录");
   response.sendError(HttpServletResponse.SC_UNAUTHORIZED,"没有凭证");
    }
}
