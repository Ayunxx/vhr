package org.example.vhr.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import jakarta.annotation.Resource;
import org.example.vhr.mapper.ChangeSalaryMapper;
import org.example.vhr.model.entity.ChangeSalaryEntity;
import org.example.vhr.model.vo.ChangeSalaryVo;
import org.example.vhr.service.IChangeSalaryService;
import org.springframework.stereotype.Service;

/**
 * @author 阿运
 * @date 2024/3/7 16:09
 * ChangeSalaryServiceImpl 描述
 */
@Service
public class ChangeSalaryServiceImpl extends ServiceImpl<ChangeSalaryMapper, ChangeSalaryEntity>
        implements IChangeSalaryService {
    @Resource
    private ChangeSalaryMapper changeSalaryMapper;

    @Override
    public IPage<ChangeSalaryVo> getListPage(Long current, Long size, ChangeSalaryVo changeSalaryVo) {
        Page<ChangeSalaryVo> voPage = new Page<>(current, size);
        QueryWrapper<ChangeSalaryVo> queryWrapper = new QueryWrapper<>();


        IPage<ChangeSalaryVo> page = changeSalaryMapper.getPage(voPage, queryWrapper);

        return page;
    }
}
