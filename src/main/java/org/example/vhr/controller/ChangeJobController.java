package org.example.vhr.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import jakarta.annotation.Resource;
import org.example.vhr.model.result.Result;
import org.example.vhr.model.vo.ChangeJobVo;
import org.example.vhr.service.IChangeJobService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

/**
 * @author 阿运
 * @date 2024/3/7 15:36
 * ChangeJobController 描述
 */

@SuppressWarnings("rawtypes")
@RestController
@RequestMapping("/changejob")
@CrossOrigin
@PreAuthorize("hasAnyAuthority('system:changejob')")
public class ChangeJobController {

    @Resource
    private IChangeJobService changeJobService;


    @PreAuthorize("hasAnyAuthority('system:changejob:list','system:changejob')")
    @PostMapping("/getChangeJobList/{current}/{size}")
    public Result getChangeJobList(@PathVariable Long current,
                                   @PathVariable Long size,
                                   @RequestBody ChangeJobVo changeJobVo){

        IPage<ChangeJobVo> page = changeJobService.getPage(current, size, changeJobVo);

        return Result.ok(page);

    }
    //TODO 添加业务还未实现

    @DeleteMapping("/deleteChangeJobById/{id}")
    public Result deleteChangeJobById(@PathVariable Integer id){
        boolean flag = changeJobService.removeById(id);
        if (flag) {
            return Result.ok();
        } else {
            return Result.fail();
        }
    }
}
