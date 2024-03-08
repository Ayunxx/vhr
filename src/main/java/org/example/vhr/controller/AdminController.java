package org.example.vhr.controller;

import jakarta.annotation.Resource;
import org.example.vhr.model.entity.HrEntity;
import org.example.vhr.model.result.Result;
import org.example.vhr.model.vo.HrVo;
import org.example.vhr.model.vo.MenuVo;
import org.example.vhr.service.IHrService;
import org.example.vhr.service.IMenuService;
import org.example.vhr.service.IRoleService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author 阿运
 * @date 2024/3/7 15:03
 * AdminController 描述
 */
@SuppressWarnings("rawtypes")

@RestController
@CrossOrigin
@RequestMapping("/admin")
@PreAuthorize("hasAnyAuthority('system:admin')")
public class AdminController {
    @Resource
    private IRoleService roleService;

    @Resource
    private IHrService hrService;

    @Resource
    private IMenuService menuService;


    @PutMapping("/updateRoleStatus/{roleId}/{menuId}/{status}")
    public Result updateRoleStatus(@PathVariable Integer roleId,
                                   @PathVariable Integer menuId,
                                   @PathVariable Integer status){
        boolean flag = roleService.updateRoleStatus(roleId, menuId, status);
        if (flag) {
            return  Result.ok();
        } else{
            return  Result.fail();
        }

    }

    @GetMapping("/getRoleAndMenu")
    public Result getRoleAndMenu(){
        List<MenuVo> list = menuService.getRoleAndMenuList();
        return Result.ok(list);
    }

    /**
     * 获取菜单列表
     */
    @GetMapping("/getMenuList")
    public Result getMenuList(){

        List<MenuVo> list = menuService.getMenuList();

        return Result.ok(list);
    }

    /**
     * 获取用户列表
     */
    @GetMapping("/getUserList")
    public Result getUserList(){
        List<HrVo> list = hrService.getUserList();

        return Result.ok(list);
    }

    /**
     * 根据id删除
     */
    @DeleteMapping("/deleteUserById/{id}")
    public Result deleteUserById(@PathVariable Integer id){
        boolean flag = hrService.removeById(id);
        if (flag) {
            return Result.ok();
        } else {
            return Result.fail();
        }

    }
    /**
     * 新增
     */
    @PostMapping("/addUser")
    public Result addUser(@RequestBody HrEntity hrEntity){
        HrEntity entity = hrService.encryption(hrEntity);
        boolean flag = hrService.save(entity);
        if (flag) {
            return Result.ok();
        } else {
            return Result.fail();
        }
    }

    /**
     * 限制登录
     */
    @PutMapping("/updateUserStatusById/{id}/{status}")
    public Result updateUserStatusById(@PathVariable Integer id,
                                       @PathVariable Integer status){

        Boolean flag = roleService.updateUserStatusById(id, status);
        if (flag) {
            return Result.ok();
        } else {
            return Result.fail();
        }
    }
}
