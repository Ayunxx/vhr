package org.example.vhr.mapper;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.example.vhr.model.entity.*;
import org.example.vhr.model.vo.EmployeeVo;

import java.util.List;

/**
 * @author 阿运
 * @date 2024/3/7 18:26
 * EmployeeMapper 描述
 */
@Mapper
public interface EmployeeMapper extends BaseMapper<EmployeeEntity> {

    /**
     * 传入一个workid 查看
     */
    Boolean getWorkId(@Param("workID") String workID);



    @Select("SELECT e.*,d.name as departmentname ,n.name as nationname,j.name as joblevelname,p.name as posname, pl.name as polName "+
            "from employee e " +
            "LEFT JOIN department d ON e.departmentId = d.id " +
            "LEFT JOIN nation n ON e.nationId = n.id " +
            "LEFT JOIN joblevel j ON e.jobLevelId = j.id " +
            "LEFT JOIN position p ON e.posId = p.id " +
            "LEFT JOIN politicsstatus pl ON e.politicId = pl.id "+
            "${ew.customSqlSegment} "
    )
    IPage<EmployeeVo> getList(Page<EmployeeEntity> page, @Param(Constants.WRAPPER) Wrapper<EmployeeEntity> wrapper);

    @Select("select * from nation ")
    List<NationEntity> getNationList();

    @Select("select id,name from department where del_flag = 0 ")
    List<DepartmentEntity> getDepartmentList();

    @Select("select id,name from joblevel where del_flag = 0 ")
    List<JobLevelEntity> getJobLevelList();

    @Select("select id,name from position where del_flag = 0 ")
    List<PositionEntity> getPositionList();
}