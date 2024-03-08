package org.example.vhr.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.example.vhr.model.entity.MenuEntity;
import org.example.vhr.model.vo.MenuVo;

import java.util.List;

/**
 * @author 阿运
 * @date 2024/3/5 0:55
 * MenuMapper 描述
 */
@Mapper
public interface MenuMapper extends BaseMapper<MenuEntity> {

    @Select("select DISTINCT r.name " +
            "from hr_role hhr " +
            "left join role r on hhr.rid = r.id " +
            "left join menu_role rm on hhr.rid = rm.rid " +
            "left join menu m on m.id = rm.mid " +
            "where hhr.hrid= #{hrId}")
    List<String> selectPermsByHrId(Integer hrId);

    @Select("select * from menu")
    List<MenuVo> getMenuList();


    @Select("select rm.*,r.role_name,r.role_key,m.menu_name,m.perms " +
            "from menu_role rm " +
            "left join menu m on m.id = rm.menu_id " +
            "left join role r on r.id = rm.role_id")
    List<MenuVo> getRoleAndMenu();
}
