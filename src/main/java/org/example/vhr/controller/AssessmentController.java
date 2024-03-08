package org.example.vhr.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import jakarta.annotation.Resource;
import org.example.vhr.model.entity.AssessmentEntity;
import org.example.vhr.model.result.Result;
import org.example.vhr.model.vo.AssessmentVo;
import org.example.vhr.service.IAssessmentService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

/**
 * @author 阿运
 * @date 2024/3/7 15:25
 * AssessmentController 描述
 */


@SuppressWarnings("rawtypes")
@RestController
@RequestMapping("/assessment")
@CrossOrigin
@PreAuthorize("hasAnyAuthority('system:assessment')")
public class AssessmentController {

    @Resource
    private IAssessmentService assessmentService;


    @PreAuthorize("hasAnyAuthority('system:assessment:list','system:assessment')")
    @PostMapping("/getAssessmentList/{current}/{size}")
    public Result getAssessmentList(@PathVariable Long current,
                                    @PathVariable Long size,
                                    @RequestBody AssessmentVo assessmentVo){
        IPage<AssessmentVo> page = assessmentService.getPage(current, size, assessmentVo);

        return Result.ok(page);
    }

    /**
     * 根据id查询
     */
    @GetMapping("/getAssessmentById/{id}")
    public Result getAssessmentById(@PathVariable Integer id) {
        AssessmentEntity assessmentServiceById = assessmentService.getById(id);

        return Result.ok(assessmentServiceById);
    }

    /**
     * 根据id删除
     */
    @DeleteMapping("/deleteAssessmentById/{id}")
    public Result deleteAssessmentById(@PathVariable Integer id){
        boolean flag = assessmentService.removeById(id);
        if (flag) {
            return Result.ok();
        } else {
            return Result.fail();
        }

    }

    /**
     * 添加
     */
    @PostMapping("/addAssessment")
    public Result addAssessment(@RequestBody AssessmentEntity assessmentEntity){
        System.out.println(assessmentEntity.toString());
        boolean flag = assessmentService.save(assessmentEntity);
        if (flag) {
            return Result.ok();
        } else {
            return Result.fail();
        }
    }

    /**
     * 修改
     */
    @PostMapping("/updateAssessment")
    public Result updateAssessment(@RequestBody AssessmentEntity assessmentEntity){
        boolean flag = assessmentService.updateById(assessmentEntity);
        if (flag) {
            return Result.ok();
        } else {
            return Result.fail();
        }
    }
}
