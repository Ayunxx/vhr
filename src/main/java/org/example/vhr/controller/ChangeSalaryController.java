package org.example.vhr.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import org.example.vhr.model.result.Result;
import org.example.vhr.model.vo.ChangeSalaryVo;
import org.example.vhr.service.IChangeSalaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

/**
 * @author 阿运
 * @date 2024/3/7 15:44
 * ChangeSalaryController 描述
 */
@RestController
@RequestMapping("/changeSalary")
@CrossOrigin
@PreAuthorize("hasAnyAuthority('system:salary')")
public class ChangeSalaryController {

    @Autowired
    private IChangeSalaryService changeSalaryService;



    @PreAuthorize("hasAnyAuthority('system:salary:list','system:salary')")
    @PostMapping("/getChangeSalaryList/{current}/{size}")
    public Result getChangeSalaryList(@PathVariable Long current,
                                      @PathVariable Long size,
                                      @RequestBody ChangeSalaryVo changeSalaryVo){

        IPage<ChangeSalaryVo> listPage = changeSalaryService.getListPage(current, size, changeSalaryVo);

        return Result.ok(listPage);
    }

}