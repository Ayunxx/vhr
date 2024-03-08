package org.example.vhr.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import jakarta.annotation.Resource;
import org.example.vhr.model.entity.RandPEntity;
import org.example.vhr.model.result.Result;
import org.example.vhr.model.vo.RandPVo;
import org.example.vhr.service.IRandPService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

/**
 * @author 阿运
 * @date 2024/3/7 18:33
 * RandPController 描述
 */

@RestController
@RequestMapping("/RandP")
@CrossOrigin
@PreAuthorize("hasAnyAuthority('system:RandP')")
public class RandPController {
    @Resource
    private IRandPService randPService;

    /**
     * 获取列表并分页返回
     * @param current
     * @param size
     * @param randPVo
     * @return
     */
    @PreAuthorize("hasAnyAuthority('system:RandP:list','system:RandP')")
    @PostMapping("/getListPage/{current}/{size}")
    public Result getListPage(@PathVariable Long current,
                              @PathVariable Long size,
                              @RequestBody RandPVo randPVo){

        IPage<RandPVo> page = randPService.getPage(current, size, randPVo);

        return Result.ok(page);
    }
    /**
     * 根据id查询
     * @param id
     * @return
     */
    @GetMapping("/getRandPById/{id}")
    public Result getRandPById(@PathVariable Integer id) {
        RandPEntity randPServiceById = randPService.getById(id);

        return Result.ok(randPServiceById);
    }

    /**
     * 添加
     * @param randPEntity
     * @return
     */
    @PostMapping("/addRandP")
    public Result addRandP(@RequestBody RandPEntity randPEntity){

        boolean flag = randPService.save(randPEntity);

        if (flag) {
            return Result.ok();
        } else {
            return Result.fail();
        }
    }

    /**
     * 修改更新
     * @param randPEntity
     * @return
     */
    @PostMapping("/updateRandP")
    public Result updateRandP(@RequestBody RandPEntity randPEntity){
        boolean flag = randPService.updateById(randPEntity);
        if (flag) {
            return Result.ok();
        } else {
            return Result.fail();
        }

    }

    /**
     * 根据id删除
     * @param id
     * @return
     */
    @DeleteMapping("/deleteRandPById/{id}")
    public Result deleteRandPById(@PathVariable Integer id){

        boolean flag = randPService.removeById(id);
        if (flag) {
            return Result.ok();
        } else {
            return Result.fail();
        }
    }
}
