package org.example.vhr.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.example.vhr.model.entity.MenuEntity;
import org.example.vhr.model.vo.MenuVo;

import java.util.List;

/**
 * @author 阿运
 * @date 2024/3/7 15:05
 * IMenuService 描述
 */

public interface IMenuService extends IService<MenuEntity> {
    List<MenuVo> getRoleAndMenuList();

    List<MenuVo> getMenuList();
}
