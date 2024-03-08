package org.example.vhr.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.example.vhr.model.entity.ChangeJobEntity;
import org.example.vhr.model.vo.ChangeJobVo;

/**
 * @author 阿运
 * @date 2024/3/7 15:42
 * ChangeJobMapper 描述
 */

@Mapper
public interface ChangeJobMapper extends BaseMapper<ChangeJobEntity> {

    @Select("select ec.* ,e.emp_name,e.workid,d.depart_name as afterDepartName ,p.pos_name as afterJobName,dd.depart_name as beforeDepartname,pp.pos_name as beforeJobname "+
            "from emp_changejob ec "+
            "left join employee e on ec.eid = e.id "+
            "left join department d on ec.after_depId = d.id "+
            "left join department dd on dd.id = ec.before_depId "+
            "left join position p on ec.after_posId = p.id "+
            "left join position pp on ec.before_posId = pp.id "+
            "where ec.del_flag = 0 "+
            "${ew.customSqlSegment}")
    IPage<ChangeJobVo> getListPage(Page<ChangeJobVo> jobVoPage, @Param(Constants.WRAPPER) QueryWrapper<ChangeJobVo> queryWrapper);
}
