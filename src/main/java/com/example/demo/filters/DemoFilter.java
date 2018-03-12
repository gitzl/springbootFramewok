package com.example.demo.filters;

import org.springframework.http.HttpStatus;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

/**
 * Created by king on 2018/3/9.
 */

@WebFilter(urlPatterns = "/api/*")
public class DemoFilter extends OncePerRequestFilter {
    public static final String TOKEN_EXPIRED = "Authorization Token Expired";
    public static final String INVALID_TOKEN = "Authorization Token Invalid";
    private static final String MISSING_TOKEN = "Missing Authorization Token";
    private static final String TOKEN_HEADER_PREFIX = "Authorization";

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        if (shouldSkipUrl(request)) {
            filterChain.doFilter(request, response);
            return;
        }

        String header = request.getHeader(TOKEN_HEADER_PREFIX);
        if(StringUtils.isEmpty(header)) {
            unauthorizedError(response, MISSING_TOKEN);
        }
        filterChain.doFilter(request, response);
    }

    private void unauthorizedError(HttpServletResponse response, String msg) throws IOException {
        response.setStatus(HttpStatus.UNAUTHORIZED.value());
        response.getWriter().write(msg);
    }

    private boolean  shouldSkipUrl(HttpServletRequest request) {
        String[]  skipUrl = {"/api/user/login","/api/auth"};
        List<String> skipUrlList = Arrays.asList(skipUrl);
        return skipUrlList.stream().anyMatch(url->request.getRequestURI().contains(url));
    }

}
