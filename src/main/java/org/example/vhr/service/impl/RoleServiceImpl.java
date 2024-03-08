package org.example.vhr.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import jakarta.annotation.Resource;
import org.example.vhr.mapper.RoleMapper;
import org.example.vhr.model.entity.RoleEntity;
import org.example.vhr.service.IRoleService;
import org.springframework.stereotype.Service;

/**
 * @author 阿运
 * @date 2024/3/7 15:20
 * RoleServiceImpl 描述
 */
@Service
public class RoleServiceImpl extends ServiceImpl<RoleMapper, RoleEntity> implements IRoleService {
    @Resource
    private RoleMapper roleMapper;




    @Override
    public Boolean updateUserStatusById(Integer id, Integer status) {
        return roleMapper.updateUserStatusById(id, status);
    }

    @Override
    public boolean updateRoleStatus(Integer roleId, Integer menuId, Integer status) {

        //TODO 删除redis中的缓存 重新获取

        boolean flag = roleMapper.updateRoleStatusById(roleId, menuId, status);

        return flag;
    }
}
