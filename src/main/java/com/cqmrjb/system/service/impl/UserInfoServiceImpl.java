
package com.cqmrjb.system.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.cqmrjb.common.config.SecurityConfig.JwtTokenUtil;
import com.cqmrjb.common.config.SecurityConfig.UserDetailsServiceImpl;
import com.cqmrjb.common.config.redis.RedisUtilsImpl;
import com.cqmrjb.system.base.service.impl.BaseServiceImpl;
import com.cqmrjb.system.entity.UserInfo;
import com.cqmrjb.system.mapper.UserInfoMapper;
import com.cqmrjb.system.service.IUserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


/**
 * @ClassName:用户信息表 服务实现类
 * @Description:
 * @author: zhou
 * @date 2020-10-28
 */
@Service
@Transactional
public class UserInfoServiceImpl extends BaseServiceImpl<UserInfoMapper, UserInfo> implements IUserInfoService {

    @Autowired
    private UserDetailsServiceImpl userDetailsService;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private IUserInfoService userInfoService;

    @Autowired
    private RedisUtilsImpl redisUtils;

    @Override
    public UserInfo getUserByUserName(String phone) {
        QueryWrapper<UserInfo> wrapper = new QueryWrapper<>();
        wrapper.eq("phone", phone);
        return baseMapper.selectOne(wrapper);
    }

    @Override
    public List<UserInfo> listUserInfo(String phone, String role) {
        QueryWrapper<UserInfo> wrapper = new QueryWrapper<>();
        if(phone !=null && phone !=""){
            wrapper.eq("phone",phone);
        }
        if(role !=null && role !=""){
            wrapper.eq("role",role);
        }
        wrapper.eq("status",0);
        wrapper.orderByDesc("update_date");

        return baseMapper.selectList(wrapper);
    }

    @Override
    public String login(UserInfo entity ) {

        if (entity.getPhone().isEmpty()) {
            return "用户名不能为空";
        }
        if (entity.getPassword().isEmpty()) {
            return "密码不能为空";
        }
        UserInfo userByUserName = userInfoService.getUserByUserName(entity.getPhone());
        if (userByUserName == null) {
            return "用户名或密码错误";
        }
        //验证密码
        String password1 = userByUserName.getPassword();

        if (!password1.equals(entity.getPassword())) {
            return "用户名或密码错误";
        }
        UserDetails userDetails = userDetailsService.loadUserByUsername(entity.getPhone());
        String token = jwtTokenUtil.generateToken(userDetails);
        redisUtils.set(token, entity.getPhone(), 86400);
        //token
        String tokenUser = (String) redisUtils.get(token);
        if (tokenUser == null) {
            return "登陆验证token失败";
        }
        if (!tokenUser.equals(entity.getPhone())) {
            return "登陆验证token失败";
        }
        return "登录成功token=>" + token;
    }


}
