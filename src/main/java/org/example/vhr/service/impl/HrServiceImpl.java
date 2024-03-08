package org.example.vhr.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import jakarta.annotation.Resource;
import org.example.vhr.mapper.HrMapper;
import org.example.vhr.mapper.MenuMapper;
import org.example.vhr.model.entity.HrEntity;
import org.example.vhr.model.vo.HrVo;
import org.example.vhr.service.IHrService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

/**
 * @author 阿运
 * @date 2024/3/4 23:27
 * HrServiceImpl 描述
 */

@Service
public class HrServiceImpl extends ServiceImpl<HrMapper, HrEntity> implements IHrService {

    @Resource
    HrMapper hrMapper;

    @Resource
    private MenuMapper menuMapper;
    @Override
    public HrVo loadUserByUsername(String username) throws UsernameNotFoundException {

        //查询用户信息
        QueryWrapper<HrVo> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username",username);
        HrVo hrVo = hrMapper.getOneByUsername(queryWrapper);
        if (Objects.isNull(hrVo)) {
            throw new RuntimeException("用户名或密码错误");
        }
        List<String> list = menuMapper.selectPermsByHrId(hrVo.getId());
        hrVo.setRoles(list);

        //把数据封装成UserDetails
        return hrVo;

    }

    @Override
    public List<HrVo> getUserList() {
        return hrMapper.getUserList();
    }

    @Override
    public HrEntity encryption(HrEntity hrEntity) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String password = hrEntity.getPassword();
        String encode = passwordEncoder.encode(password);
        hrEntity.setPassword(encode);
        return hrEntity;
    }
}
