package org.example.vhr.model.vo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;

import java.sql.ConnectionBuilder;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author 阿运
 * @date 2024/2/29 23:37
 * HrVo 描述
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties({"enabled","accountNonExpired", "accountNonLocked", "credentialsNonExpired", "authorities"})
public class HrVo implements UserDetails {

    private Integer id;

    private String name;

    private String username;

    private String password;

    private String userface;

    private String phone;

    private String token;

    private Date expire;

    private String roleKey;

    private String roleName;

    private Integer status;

    private List<String> roles;

    private List<SimpleGrantedAuthority> authorities;


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        if (authorities !=null) {
            return  authorities;
        }
        authorities = roles.stream().
                map(SimpleGrantedAuthority::new).
                collect(Collectors.toList());

        return authorities;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
