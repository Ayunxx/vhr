package org.example.vhr.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import org.example.vhr.model.entity.AssessmentEntity;
import org.example.vhr.model.vo.AssessmentVo;

/**
 * @author 阿运
 * @date 2024/3/7 15:26
 * IAssessmentService 描述
 */
public interface IAssessmentService extends IService<AssessmentEntity> {
    IPage<AssessmentVo> getPage(Long current, Long size, AssessmentVo assessmentVo);
}
