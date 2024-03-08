package org.example.vhr.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.example.vhr.model.entity.ChangeSalaryEntity;
import org.example.vhr.model.vo.ChangeSalaryVo;

/**
 * @author 阿运
 * @date 2024/3/7 16:09
 * ChangeSalaryMapper 描述
 */
@Mapper
public interface ChangeSalaryMapper extends BaseMapper<ChangeSalaryEntity> {


    @Select("select sal.*,e.workId,e.emp_name " +
            "from sal_changesalary sal " +
            "left join employee e " +
            "on e.id = sal.eid" +
            "${ew.customSqlSegment}")
    IPage<ChangeSalaryVo> getPage(Page<ChangeSalaryVo> voPage, @Param(Constants.WRAPPER) QueryWrapper<ChangeSalaryVo> queryWrapper);
}