package com.treeofworld.elf.filter;

import com.treeofworld.elf.common.HttpConstant;
import com.treeofworld.elf.context.UserContext;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

/**
 * UserInfoFilter
 *
 * @author: elf
 * @data: 2025/7/2
 * @version: 1.0
 */
@Slf4j
@Component
public class UserInfoFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        String username = request.getHeader(HttpConstant.USERNAME);
        String password = request.getHeader(HttpConstant.PASSWORD);

        log.info("username:{}, password:{}", username, password);

        ScopedValue<UserContext.UserInfo> userInfoContext = UserContext.getContext();

        // 为当前线程（也可以是虚拟线程）绑定UserContext的值
        // 为UserContext定义ScopedValue的作用域为filterChain.doFilter(request, response);
        ScopedValue.where(userInfoContext, new UserContext.UserInfo(username, password)).run(() -> {
            try {
                filterChain.doFilter(request, response);
            } catch (IOException | ServletException e) {
                throw new RuntimeException(e);
            }
        });
    }
}
