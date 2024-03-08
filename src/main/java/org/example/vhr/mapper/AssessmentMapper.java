package org.example.vhr.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.example.vhr.model.entity.AssessmentEntity;
import org.example.vhr.model.vo.AssessmentVo;

/**
 * @author 阿运
 * @date 2024/3/7 15:33
 * AssessmentMapper 描述
 */

@Mapper
public interface AssessmentMapper extends BaseMapper<AssessmentEntity> {
    @Select("select ass.*,e.name,e.workID " +
            "from emp_assessment ass " +
            "left join employee e " +
            "on e.id = ass.eid " +
            "${ew.customSqlSegment}")
    IPage<AssessmentVo> getListPage(Page<AssessmentVo> page,
                                    @Param(Constants.WRAPPER) QueryWrapper<AssessmentVo> queryWrapper);
}
