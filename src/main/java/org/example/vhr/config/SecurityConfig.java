package org.example.vhr.config;


import jakarta.annotation.Resource;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.vhr.filter.JwtAuthenticationFilter;
import org.example.vhr.model.result.Result;
import org.example.vhr.model.vo.HrVo;
import org.example.vhr.utils.JwtUtils;
import org.springframework.context.annotation.Bean;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
/**
 * @author 阿运
 * @date 2024/2/29 23:27
 * SecurityConfig 描述
 */
@EnableWebSecurity
@Configuration
public class SecurityConfig {

    @Resource
    JwtUtils jwtUtils;

    @Resource
    private RedisTemplate<String,Object> redisTemplate;


    @Resource
    JwtAuthenticationFilter jwtAuthenticationFilter;

    // 定义密码编码器，这里使用BCryptPasswordEncoder作为密码的加密方式
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {

        return httpSecurity
                .authorizeHttpRequests(auth -> {
                    auth.requestMatchers("/api/auth/**").permitAll();
                    auth.anyRequest().authenticated();
                })
                .formLogin(form -> {
                    form.loginProcessingUrl("/api/auth/login");
                    form.successHandler(this::onAuthenticationSuccess);
                    form.failureHandler(this::onAuthenticationFailure);
                    form.permitAll();
                })
                .logout(conf -> conf.logoutUrl("/api/auth/logout")
                        .logoutSuccessHandler(this::onLogoutSuccess))
                .cors(conf -> {
                    CorsConfiguration cors = new CorsConfiguration();
                    cors.addAllowedOrigin(""); //前端站点
                    cors.setAllowCredentials(false); //是否携带cookie
                    cors.addAllowedHeader("*");
                    cors.addAllowedMethod("*");
                    cors.addExposedHeader("*");
                    UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
                    source.registerCorsConfiguration("/**",cors);
                    conf.configurationSource(source);
                })
                .sessionManagement(conf -> conf.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class)
                .csrf(AbstractHttpConfigurer::disable)
                .build();
    }



    public void onAuthenticationSuccess(HttpServletRequest request,
                                 HttpServletResponse response,
                                 Authentication authentication) throws IOException {
        response.setContentType("application/json");
        response.setCharacterEncoding("utf-8");
        HrVo user = (HrVo) authentication.getPrincipal();
        String token = jwtUtils.createJwt(user);
        user.setPassword("");
        user.setToken(token);
        user.setExpire(jwtUtils.expireTime());
        Map<String, String> mapToken = new HashMap<>();
        mapToken.put("token",token);
        redisTemplate.opsForValue().set("tokenId:"+user.getId(),user);
        PrintWriter writer = response.getWriter();
        writer.write(Result.ok(mapToken).asJson());
    }


    public void onAuthenticationFailure (HttpServletRequest request,
                                  HttpServletResponse response,
                                  AuthenticationException exception) throws IOException {
        response.setContentType("application/json");
        response.setCharacterEncoding("utf-8");
        PrintWriter writer = response.getWriter();
        writer.write(Result.fail().asJson());

    }


    public void onLogoutSuccess(HttpServletRequest request,
                                HttpServletResponse response,
                                Authentication authentication) throws IOException, ServletException {

    }





}

