package org.example.vhr.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.example.vhr.model.entity.RoleEntity;

/**
 * @author 阿运
 * @date 2024/3/7 15:04
 * IRoleService 描述
 */
public interface IRoleService extends IService<RoleEntity> {
    boolean updateRoleStatus(Integer roleId, Integer menuId, Integer status);

    Boolean updateUserStatusById(Integer id, Integer status);
}
