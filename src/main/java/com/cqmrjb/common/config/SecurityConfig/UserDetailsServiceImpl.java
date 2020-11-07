package com.cqmrjb.common.config.SecurityConfig;

import com.cqmrjb.system.entity.UserInfo;
import com.cqmrjb.system.service.IUserInfoService;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.util.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    public IUserInfoService userInfoService;
    @Override
    public UserDetails loadUserByUsername(String phone) throws UsernameNotFoundException {

        //根据用户名查找用户
        UserInfo userByUserName = userInfoService.getUserByUserName(phone);
        //装权限
        List<GrantedAuthority> authorities = Lists.newArrayList();
        if (userByUserName == null) {
            throw new UsernameNotFoundException(String.format("No user found with username '%s'.", userByUserName));
        } else {
            String role = userByUserName.getRole();
            GrantedAuthority grantedAuthority = new SimpleGrantedAuthority("ROLE_"+role);
            authorities.add(grantedAuthority);
            //查看是啥角色
            log.info(authorities+"111111111");
            return new SecurityUserDetails(phone, userByUserName.getPassword(),authorities);
        }
    }

}
