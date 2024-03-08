package org.example.vhr.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import jakarta.annotation.Resource;
import org.example.vhr.mapper.SalaryMapper;
import org.example.vhr.model.entity.SalaryEntity;
import org.example.vhr.model.vo.SalaryVo;
import org.example.vhr.service.ISalaryService;
import org.springframework.stereotype.Service;

/**
 * @author 阿运
 * @date 2024/3/7 18:39
 * SalaryServiceImpl 描述
 */
@Service
public class SalaryServiceImpl extends ServiceImpl<SalaryMapper, SalaryEntity> implements ISalaryService {
    @Resource
    private SalaryMapper salaryMapper;

    @Override
    public IPage<SalaryVo> getPage(Long current, Long size, SalaryVo vo) {

        Page<SalaryVo> voPage = new Page<>(current,size);
        QueryWrapper<SalaryVo> voQueryWrapper = new QueryWrapper<>();


        return salaryMapper.getListPage(voPage, voQueryWrapper);
    }

    @Override
    public SalaryVo getSalaryById(Integer id) {
        SalaryVo byId = salaryMapper.getById(id);
        return byId;
    }
}
