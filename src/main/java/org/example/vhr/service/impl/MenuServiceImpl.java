package org.example.vhr.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import jakarta.annotation.Resource;
import org.example.vhr.mapper.MenuMapper;
import org.example.vhr.model.entity.MenuEntity;
import org.example.vhr.model.vo.MenuVo;
import org.example.vhr.service.IMenuService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 阿运
 * @date 2024/3/7 15:13
 * MenuServiceImpl 描述
 */

@Service
public class MenuServiceImpl extends ServiceImpl<MenuMapper, MenuEntity> implements IMenuService {

    @Resource
    private MenuMapper menuMapper;
    @Override
    public List<MenuVo> getRoleAndMenuList() {

        return menuMapper.getRoleAndMenu();
    }
    @Override
    public List<MenuVo> getMenuList() {
        return menuMapper.getMenuList();
    }
}
