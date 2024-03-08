package org.example.vhr.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import jakarta.annotation.Resource;
import org.example.vhr.mapper.RandPMapper;
import org.example.vhr.model.entity.RandPEntity;
import org.example.vhr.model.vo.RandPVo;
import org.example.vhr.service.IRandPService;
import org.springframework.stereotype.Service;

/**
 * @author 阿运
 * @date 2024/3/7 18:35
 * RandPServiceImpl 描述
 */
@Service
public class RandPServiceImpl extends ServiceImpl<RandPMapper, RandPEntity> implements IRandPService {
    @Resource
    private RandPMapper randPMapper;

    @Override
    public IPage<RandPVo> getPage(Long current, Long size, RandPVo randPVo) {
        Page<RandPVo> randPVoPage = new Page<>(current,size);
        QueryWrapper<RandPVo> queryWrapper = new QueryWrapper<>();
        //TODO 具体模糊查询业务
        /*if (!randPVo.equals(null)){
            String workId = randPVo.getWorkId();
            String name = randPVo.getEmpName();
            if (StringUtils.hasText(workId)){
                queryWrapper.like("workid",workId);
            }
            if (StringUtils.hasText(name)){
                queryWrapper.like("empname",name);
            }
        }*/

        return randPMapper.getListPage(randPVoPage, queryWrapper);
    }
}
