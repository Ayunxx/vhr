package org.example.vhr.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import jakarta.annotation.Resource;
import org.example.vhr.model.entity.*;
import org.example.vhr.model.result.Result;
import org.example.vhr.model.vo.EmployeeVo;
import org.example.vhr.service.IEmployeeService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author 阿运
 * @date 2024/3/7 16:13
 * EmployeeController 描述
 */
@SuppressWarnings("rawtypes")
@RestController
@RequestMapping("/employee")
@CrossOrigin
@PreAuthorize("hasAnyAuthority('system:employee')")
public class EmployeeController {
    @Resource
    private IEmployeeService employeeService;


    /**
     * 获取员工列表并分页
     */

    @PreAuthorize("hasAnyAuthority('system:employee:list','system:employee')")
    @PostMapping("/getEmployeeList/{current}/{size}")
    public Result getEmployeeList(@PathVariable Long current,
                                  @PathVariable Long size,
                                  @RequestBody EmployeeVo employeeVo
    ){
        IPage<EmployeeVo> entityIPage = employeeService.getListPage(current, size,employeeVo);

        return Result.ok(entityIPage);
    }

    /**
     * 添加员工

     */
    @PostMapping("/addEmployee")
    public Result addEmployee(@RequestBody EmployeeEntity employeeEntity){
        EmployeeEntity checkWorkId = employeeService.checkWorkId(employeeEntity);

        if (checkWorkId != null){
            employeeService.save(checkWorkId);

        } else {
            Result.fail("添加失败");
        }
        return Result.ok();
    }

    /**
     * 修改员工信息
     */
    @PostMapping("/updateEmployee")
    public Result updateEmployee(@RequestBody EmployeeEntity employeeEntity){

        boolean flag = employeeService.updateById(employeeEntity);

        if (flag){
            return Result.ok();
        } else {
            return Result.fail();
        }

    }

    /**
     * 根据id查询员工信息
     */
    @GetMapping("/getEmployeeById/{id}")
    public Result getEmployeeById(@PathVariable Integer id){

        EmployeeEntity employeeServiceById = employeeService.getById(id);

        return Result.ok(employeeServiceById);

    }

    /**
     * 根据id删除员工
     */
    @DeleteMapping("/deleteEmployeeById/{id}")
    public Result deleteEmployeeById(@PathVariable Long id){

        boolean flag = employeeService.removeById(id);

        if (flag){
            return Result.ok();
        } else {
            return Result.fail();
        }
    }

    /**
     * 获取民族列表
     */
    @GetMapping("/getNationList")
    public Result getNationList(){
        List<NationEntity> list =  employeeService.getNation();

        return Result.ok(list);
    }

    /**
     * 获取部门列表
     */
    @GetMapping("/getDepartmentList")
    public Result getDepartmentList(){
        List<DepartmentEntity> list = employeeService.getDepartment();
        return Result.ok(list);
    }

    /**
     * 获取职称列表
     */
    @GetMapping("/getJobLevelList")
    public Result getJobLevelList(){
        List<JobLevelEntity> list = employeeService.getJobLevel();
        return Result.ok(list);
    }

    /**
     * 获取职位列表
     */
    @GetMapping("/getPositionList")
    public Result getPositionList(){

        List<PositionEntity> list = employeeService.getPosition();

        return Result.ok(list);
    }
}
