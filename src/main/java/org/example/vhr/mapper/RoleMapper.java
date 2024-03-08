package org.example.vhr.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;
import org.example.vhr.model.entity.RoleEntity;

/**
 * @author 阿运
 * @date 2024/3/7 15:21
 * RoleMapper 描述
 */

@Mapper
public interface RoleMapper extends BaseMapper<RoleEntity> {
    /**
     * 改变状态限制登录
     * @param id
     * @param status
     * @return
     */
    @Update("update hr set status = ${status} where id = #{id}")
    boolean updateUserStatusById(@Param("id") Integer id, @Param("status") Integer status);

    @Update("update role_menu set status = #{status} where role_id = #{roleId} and menu_id = #{menuId}")
    boolean updateRoleStatusById(@Param("roleId") Integer roleId,@Param("menuId") Integer menuId,@Param("status") Integer status);
}
