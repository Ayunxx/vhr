package org.example.vhr.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.example.vhr.model.entity.SalaryEntity;
import org.example.vhr.model.vo.SalaryVo;

/**
 * @author 阿运
 * @date 2024/3/7 18:40
 * SalaryMapper 描述
 */
@Mapper
public interface SalaryMapper extends BaseMapper<SalaryEntity> {

    @Select("select sa.*,e.name as empName,e.workID " +
            "from emp_salary es " +
            "left join employee e on e.id = es.eid " +
            "left join salary sa on sa.id = es.sid " +
            "${ew.customSqlSegment}")
    IPage<SalaryVo> getListPage(Page<SalaryVo> voPage, @Param(Constants.WRAPPER) QueryWrapper<SalaryVo> voQueryWrapper);


    @Select("select s.*,e.name " +
            "from salary s " +
            "left join employee e on s.eid = e.id " +
            "where s.del_flag = 0 " +
            "and s.id = #{id}")
    SalaryVo getById(@Param("id") Integer id);
}