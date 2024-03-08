package org.example.vhr.controller;

import jakarta.annotation.Resource;
import org.example.vhr.model.entity.DepartmentEntity;
import org.example.vhr.model.result.Result;
import org.example.vhr.service.IDepartmentService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author 阿运
 * @date 2024/3/7 16:11
 * DepartmentController 描述
 */
@RestController
@RequestMapping("/department")
@CrossOrigin
@PreAuthorize("hasAnyAuthority('system:department')")
public class DepartmentController {
    @Resource
    private IDepartmentService departmentService;



    @PreAuthorize("hasAnyAuthority('system:department:list','system:department')")
    @GetMapping("/getDepartmentList")
    public Result getDepartmentList(){
        List<DepartmentEntity> list = departmentService.list();

        return Result.ok(list);
    }



}