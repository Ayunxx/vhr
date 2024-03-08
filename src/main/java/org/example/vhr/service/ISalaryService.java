package org.example.vhr.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import org.example.vhr.model.entity.SalaryEntity;
import org.example.vhr.model.vo.SalaryVo;

/**
 * @author 阿运
 * @date 2024/3/7 18:39
 * ISalaryService 描述
 */
public interface ISalaryService extends IService<SalaryEntity> {

    IPage<SalaryVo> getPage(Long current, Long size, SalaryVo vo);

    SalaryVo getSalaryById(Integer id);
}
