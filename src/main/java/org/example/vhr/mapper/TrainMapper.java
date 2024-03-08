package org.example.vhr.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.example.vhr.model.entity.TrainEntity;
import org.example.vhr.model.vo.TrainVo;

/**
 * @author 阿运
 * @date 2024/3/7 18:44
 * TrainMapper 描述
 */
@Mapper
public interface TrainMapper extends BaseMapper<TrainEntity> {

    @Select("select et.*,e.name,e.workID " +
            "from emp_train et " +
            "left join employee e " +
            "on e.id = et.eid "+
            "where et.del_flag = 0 " +
            "${ew.customSqlSegment}")
    IPage<TrainVo> getPage(Page<TrainVo> page , @Param(Constants.WRAPPER) QueryWrapper<TrainVo> queryWrapper);

}
