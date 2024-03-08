package org.example.vhr.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.example.vhr.model.entity.RandPEntity;
import org.example.vhr.model.vo.RandPVo;

/**
 * @author 阿运
 * @date 2024/3/7 18:35
 * RandPMapper 描述
 */
@Mapper
public interface RandPMapper extends BaseMapper<RandPEntity> {

    @Select("select rap.*,e.name,e.workID " +
            "from emp_rewardandpunish rap " +
            "left join employee e " +
            "on e.id = rap.eid "+
            "where rap.del_flag = 0 "+
            "${ew.customSqlSegment}")
    IPage<RandPVo> getListPage(Page<RandPVo> randPVoPage, @Param(Constants.WRAPPER) QueryWrapper<RandPVo> queryWrapper);
}
