package org.example.vhr.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import jakarta.annotation.Resource;
import org.example.vhr.mapper.ChangeJobMapper;
import org.example.vhr.model.entity.ChangeJobEntity;
import org.example.vhr.model.vo.ChangeJobVo;
import org.example.vhr.service.IChangeJobService;
import org.springframework.stereotype.Service;

/**
 * @author 阿运
 * @date 2024/3/7 15:41
 * ChangeJobServiceImpl 描述
 */
@Service
public class ChangeJobServiceImpl extends ServiceImpl<ChangeJobMapper, ChangeJobEntity> implements IChangeJobService {

    @Resource
    private ChangeJobMapper changeJobMapper;
    @Override
    public IPage<ChangeJobVo> getPage(Long current, Long size, ChangeJobVo changeJobVo) {
        Page<ChangeJobVo> jobVoPage = new Page<>(current,size);
        QueryWrapper<ChangeJobVo> queryWrapper = new QueryWrapper<>();
        //TODO 模糊业务


        IPage<ChangeJobVo> listPage = changeJobMapper.getListPage(jobVoPage, queryWrapper);
        return listPage;
    }
}
