package org.example.vhr.mapper;


import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import org.apache.ibatis.annotations.Mapper;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.example.vhr.model.entity.HrEntity;
import org.example.vhr.model.vo.HrVo;

import java.util.List;


/**
 * @author 阿运
 * @date 2024/3/2 1:21
 * HrMapper 描述
 */
@Mapper
public interface HrMapper extends BaseMapper<HrEntity> {

    @Select("select id,name,username,password,userface,phone "+
            "from hr " +
            "${ew.customSqlSegment} "+
            "and status = 1 ")
    HrVo getOneByUsername (@Param(Constants.WRAPPER) Wrapper<HrVo> wrapper);

    @Select("select h.id,h.name,h.phone,h.username,h.userface,h.remark,h.status,r.roleKey,r.name as roleName,h.del_flag " +
            "from hr h " +
            "left join role r on r.id = h.id ")
    List<HrVo> getUserList();
}
