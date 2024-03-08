package org.example.vhr.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import jakarta.annotation.Resource;
import org.example.vhr.model.entity.SalaryEntity;
import org.example.vhr.model.result.Result;
import org.example.vhr.model.vo.SalaryVo;
import org.example.vhr.service.ISalaryService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

/**
 * @author 阿运
 * @date 2024/3/7 18:37
 * SalaryController 描述
 */
@RestController
@RequestMapping("/salary")
@CrossOrigin
@PreAuthorize("hasAnyAuthority('system:salary')")
public class SalaryController {

    @Resource
    private ISalaryService salaryService;


    @PreAuthorize("hasAnyAuthority('system:salary:list','system:salary')")
    @PostMapping("/getSalaryList/{current}/{size}")
    public Result getListPage(@PathVariable Long current,
                              @PathVariable Long size,
                              @RequestBody SalaryVo salaryVo
    ){

        IPage<SalaryVo> page = salaryService.getPage(current, size, salaryVo);

        return Result.ok(page);
    }

    /**
     * 根据id查询
     * @param id
     * @return
     */
    @GetMapping("/getSalaryById/{id}")
    public Result getSalaryById(@PathVariable Integer id){
        SalaryVo salaryById = salaryService.getSalaryById(id);

        return Result.ok(salaryById);
    }

    /**
     * 根据id删除
     * @param id
     * @return
     */
    @DeleteMapping("/deleteSalaryById/{id}")
    public Result deleteSalaryById(@PathVariable Integer id){
        boolean flag = salaryService.removeById(id);
        if (flag) {
            return Result.ok();
        } else {
            return Result.fail();
        }
    }

    /**
     * 添加
     * @param salaryEntity
     * @return
     */
    @PostMapping("/addChangeSalary")
    public Result addSalary(@RequestBody SalaryEntity salaryEntity){
        boolean flag = salaryService.save(salaryEntity);

        if (flag) {
            return Result.ok();
        } else {
            return Result.fail();
        }
    }

    /**
     * 修改
     * @param salaryEntity
     * @return
     */
    @PostMapping("/upDateSalaryById")
    public Result upDateSalaryById(@RequestBody SalaryEntity salaryEntity){
        boolean flag = salaryService.updateById(salaryEntity);
        if (flag) {
            return Result.ok();
        } else{
            return Result.fail();
        }
    }

}
