package org.example.vhr.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import jakarta.annotation.Resource;
import org.example.vhr.mapper.AssessmentMapper;
import org.example.vhr.model.entity.AssessmentEntity;
import org.example.vhr.model.vo.AssessmentVo;
import org.example.vhr.service.IAssessmentService;
import org.springframework.stereotype.Service;

/**
 * @author 阿运
 * @date 2024/3/7 15:32
 * AssessmentService 描述
 */
@Service
public class AssessmentServiceImpl extends ServiceImpl<AssessmentMapper, AssessmentEntity> implements IAssessmentService {
    @Resource
    private AssessmentMapper assessmentMapper;

    @Override
    public IPage<AssessmentVo> getPage(Long current, Long size, AssessmentVo assessmentVo) {
        Page<AssessmentVo> voPage = new Page<>(current, size);
        QueryWrapper<AssessmentVo> queryWrapper = new QueryWrapper<>();

        //TODO 模糊业务

        IPage<AssessmentVo> listPage = assessmentMapper.getListPage(voPage, queryWrapper);


        return listPage;
    }
}
