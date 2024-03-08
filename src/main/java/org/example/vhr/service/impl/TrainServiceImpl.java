package org.example.vhr.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import jakarta.annotation.Resource;
import org.example.vhr.mapper.TrainMapper;
import org.example.vhr.model.entity.TrainEntity;
import org.example.vhr.model.vo.TrainVo;
import org.example.vhr.service.ITrainService;
import org.springframework.stereotype.Service;

/**
 * @author 阿运
 * @date 2024/3/7 18:43
 * TrainServiceImpl 描述
 */

@Service
public class TrainServiceImpl extends ServiceImpl<TrainMapper, TrainEntity> implements ITrainService {

    @Resource
    private TrainMapper trainMapper;


    @Override
    public IPage<TrainVo> getPageList(Long current, Long size, TrainVo trainVo) {

        Page<TrainVo> trainVoPage = new Page<>(current,size);

        QueryWrapper<TrainVo> queryWrapper = new QueryWrapper<>();
        //TODO 具体模糊查询业务


        return trainMapper.getPage(trainVoPage,queryWrapper);
    }
}