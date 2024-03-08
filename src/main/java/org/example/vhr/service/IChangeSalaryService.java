package org.example.vhr.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import org.example.vhr.model.entity.ChangeSalaryEntity;
import org.example.vhr.model.vo.ChangeSalaryVo;

/**
 * @author 阿运
 * @date 2024/3/7 15:44
 * IChangeSalaryService 描述
 */
public interface IChangeSalaryService extends IService<ChangeSalaryEntity> {
    IPage<ChangeSalaryVo> getListPage(Long current, Long size, ChangeSalaryVo changeSalaryVo);
}
